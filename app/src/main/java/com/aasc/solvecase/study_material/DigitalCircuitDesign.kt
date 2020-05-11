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
import kotlinx.android.synthetic.main.activity_digital_circuit_design.*
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*
import kotlin.collections.ArrayList

class DigitalCircuitDesign : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital_circuit_design)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Assignment 1","https://drive.google.com/open?id=11bg9qt88sMYNteNGmbR4ORPgyt_UpCyZ"))
        files.add(filesDetailsModel("Tutorial Sheet 1","https://drive.google.com/open?id=1AeVkUOJa5Lj_RePmOuCmMp6_XsA1XJ6h"))
        files.add(filesDetailsModel("Tutorial Sheet 2","https://drive.google.com/open?id=1bykl6j5thvDzpWpkU31WCfDOINxzJXDK"))
        files.add(filesDetailsModel("Tutorial Sheet 3","https://drive.google.com/open?id=1AKiQApTNJtRcss3s8mKHWTvBRi6MlGPi"))
        files.add(filesDetailsModel("Tutorial Sheet 5","https://drive.google.com/open?id=1uBDANOjcSXbAnR38i60aJUH54JMvE_fO"))
        files.add(filesDetailsModel("Syllabus","https://drive.google.com/open?id=18PR_nikkX-PPfEVZwBcIP0wn-D9P3-mj"))

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
