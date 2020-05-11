package com.aasc.solvecase.study_material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aasc.solvecase.R
import com.aasc.solvecase.ViewActivity
import com.aasc.solvecase.WebViewActivity
import kotlinx.android.synthetic.main.activity_maths.*
import kotlinx.android.synthetic.main.activity_operating_system.*
import java.util.*

class OperatingSystem : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operating_system)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Abraham Silberschatz - Operating System Concepts","https://drive.google.com/open?id=1hlY027o_x-eGiYcj_yyE4LPRz5yxeRzb"))
        files.add(filesDetailsModel("Chapter 1","https://drive.google.com/open?id=1ztyYbsSVKob8jHWyk8xy8giHYXUhbDy6"))
        files.add(filesDetailsModel("Chapter 2 : Computer Organization","https://drive.google.com/open?id=1MaICIGUFTBmA_XiElMoxQrmKnGqBzLd0"))
        files.add(filesDetailsModel("Chapter 3 : OS Architecture","https://drive.google.com/open?id=1Y3ipS0WW3N_e5O0KuWF3e0U_AEmNXp53"))
        files.add(filesDetailsModel("Chapter 4 : Process","https://drive.google.com/open?id=1cl17JQ7Ls1AFWCGCNaTMVjmTuBNvFnsc"))
        files.add(filesDetailsModel("Chapter 5 : IPC","https://drive.google.com/open?id=19W0S6ZOnt5n6DnYe3IlFTXI5RnrZqciq"))
        files.add(filesDetailsModel("Chapter 6 : CPU Scheduling","https://drive.google.com/open?id=1fsBhw6MiHQULhGzFI5hkuPjG391YLdoO"))
        files.add(filesDetailsModel("Chapter 7 : Threads","https://drive.google.com/open?id=1bbPBpWWL4fiCn0yLH0QS1bvSoFHdPZmm"))

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
