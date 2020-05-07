package com.example.jiitsolutions

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.krishna.fileloader.FileLoader
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import kotlinx.android.synthetic.main.activity_view_pdf.*
import java.io.File

class ViewPdfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pdf)

        val bundle : Bundle? = intent.extras
        val url = bundle!!.getString("url")

        if(intent!=null)
        {
            val viewType : String = intent.getStringExtra("ViewType")
            if (!TextUtils.isEmpty(viewType) || viewType!= null)
            {
                if(viewType.equals("internet"))
                {
                    progress_bar.visibility = View.VISIBLE

                    FileLoader.with(this)
                        .load("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf",false)
                        .fromDirectory("PDFFile", FileLoader.DIR_INTERNAL)
                        .asFile(object : FileRequestListener<File> {
                            override fun onLoad(p0: FileLoadRequest?, p1: FileResponse<File>?) {
                                progress_bar.visibility = View.GONE
                                val pdfFile = p1!!.body

                                pdf_view.fromFile(pdfFile)
                                    .password(null)
                                    .defaultPage(0)
                                    .enableSwipe(true)
                                    .swipeHorizontal(true)
                                    .enableDoubletap(true)
                                    .onDraw{ canvas, pageWidth, pageHeight, displayedPage ->
                                    }
                                    .onDrawAll { canvas, pageWidth, pageHeight, displayedPage ->  }
                                    .onPageChange { page, pageCount ->  }
                                    .onPageError { page, t ->
                                        Toast.makeText(this@ViewPdfActivity,"Error while opening page "+page,
                                            Toast.LENGTH_SHORT).show()
                                        Log.d("Error",""+t.localizedMessage);
                                    }
                                    .onTap { false }
                                    .onRender { nbPages, pageWidth, pageHeight ->
                                        pdf_view.fitToWidth()
                                    }
                                    .enableAnnotationRendering(true)
                                    .invalidPageColor(Color.RED)
                                    .load()

                            }

                            override fun onError(p0: FileLoadRequest?, p1: Throwable?) {
                                Toast.makeText(this@ViewPdfActivity,""+p1!!.message, Toast.LENGTH_SHORT).show()
                                progress_bar.visibility = View.GONE
                            }

                            /*override fun onError(p0: FileLoadRequest?, p1: Throwable?) {
                                Toast.makeText(this,""+p1!!.message,Toast.LENGTH_SHORT).show()
                                progress_bar.visibility = View.GONE
                            }*/

                        })
                }
            }
        }
    }
}
