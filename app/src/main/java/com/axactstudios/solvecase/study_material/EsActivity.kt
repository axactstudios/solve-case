package com.axactstudios.solvecase.study_material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axactstudios.solvecase.R
import com.axactstudios.solvecase.WebViewActivity
import kotlinx.android.synthetic.main.activity_es.*
import java.util.*
import kotlin.collections.ArrayList

class EsActivity : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_es)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Biasing Circuits","https://drive.google.com/open?id=1942TjzeAN3JFhC6jE2QL1L8_6Uk9r7UF"))
        files.add(filesDetailsModel("BJTs","https://drive.google.com/open?id=1Wo1UI2Go4iGWMw0seB5jUT3JitwF-vYQ"))
        files.add(filesDetailsModel("Diode Characteristics","https://drive.google.com/open?id=1Jycgf1vDrtuKcXZDtw6XppIqVZJP690J"))
        files.add(filesDetailsModel("Introduction to Electrical Science","https://drive.google.com/open?id=1XsdjEChy-iQC7GIMxqyeGNsa3_4NiTlr"))
        files.add(filesDetailsModel("Max Power","https://drive.google.com/open?id=1apidBtshX0nBaA3l6oPcGoPZWXkYt9F3"))
        files.add(filesDetailsModel("Network Analysis - Part 2","https://drive.google.com/open?id=1Wv6OmHgi_cByvVxLLJNylNJ2LXilIVla"))
        files.add(filesDetailsModel("Network Theorem","https://drive.google.com/open?id=1fmeycow0iWQ9ZiiorOtC3slIVfVYI8_T"))
        files.add(filesDetailsModel("PN - Junction","https://drive.google.com/open?id=1PSsRuHIKWTBtAcnsNI2wvqIAu7SyfSkQ"))
        files.add(filesDetailsModel("Rectifiers","https://drive.google.com/open?id=1pUNB5lFhnO_MFeTmXojGaqujPuFA3liY"))
        files.add(filesDetailsModel("Resonance circuits","https://drive.google.com/open?id=1UyPTbW_Yg_9ogFmO9ry_DaDLMiHpPAqA"))
        files.add(filesDetailsModel("Resonance","https://drive.google.com/open?id=10VHec92diJ08z0BG5LECeBg_3avK0BP_"))
        files.add(filesDetailsModel("Sinusoidal Analysis","https://drive.google.com/open?id=1lfUjdYq4uqZKiuL73x3rAh5fyvCfE6bD"))
        files.add(filesDetailsModel("Theorems - AC","https://drive.google.com/open?id=1OZ9gT43Oss43nz5a_z-wP72WsjSAU_2S"))
        files.add(filesDetailsModel("Transistor Characteristics","https://drive.google.com/open?id=1jj2JcV6OlqQsp-DT5jFKfDUKQj6i8Zy4"))

        displayList.addAll(files)
        var adapter = filesAdapter(displayList,clickListener = this)
        recyclerView.setAdapter(adapter)
    }

    override fun onItemClick(item: filesDetailsModel, position: Int) {
        //Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("fileurl",item.fileurl)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem!=null) {
            val searchView = menuItem.actionView as androidx.appcompat.widget.SearchView

            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Search"

            searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        files.forEach {
                            if (it.filename.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }

                        studymatrecyclerView.adapter!!.notifyDataSetChanged()

                    }

                    else {
                        displayList.clear()
                        displayList.addAll(files)
                        studymatrecyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}


