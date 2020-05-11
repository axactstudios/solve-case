package com.aasc.solvecase

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
import kotlinx.android.synthetic.main.activity_view.*
import java.io.File

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val bundle : Bundle?= intent.extras
        val fileurl = bundle!!.getString("fileurl")
        Toast.makeText(this,fileurl,Toast.LENGTH_SHORT).show()

        if(intent!=null)
        {
            val viewType : String = intent.getStringExtra("ViewType")
            if (!TextUtils.isEmpty(viewType) || viewType!= null)
            {
                if(viewType.equals("internet"))
                {
                    progress_bar.visibility = View.VISIBLE

                    FileLoader.with(this)
                        .load(fileurl,false)
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
                                        Toast.makeText(this@ViewActivity,"Error while opening page "+page,
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
                                Toast.makeText(this@ViewActivity,""+p1!!.message, Toast.LENGTH_SHORT).show()
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
