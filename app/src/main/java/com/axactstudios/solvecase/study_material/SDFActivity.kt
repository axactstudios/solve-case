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
import kotlinx.android.synthetic.main.activity_s_d_f.*
import java.util.*
import kotlin.collections.ArrayList

class SDFActivity : AppCompatActivity(),onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_d_f)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Binary Tree - Questions","https://drive.google.com/open?id=1OXrhV-8VxPcXNWYYrMaivf1baEUoRzev"))
        files.add(filesDetailsModel("Binary tree","https://drive.google.com/open?id=1mCSYxMUvMmQyOAO9xypZlbljbzH9kHOv"))
        files.add(filesDetailsModel("Binary Trees","https://drive.google.com/open?id=12oOTLUKDK6v6zrDc1apms4O_XDZaE4Aa"))
        files.add(filesDetailsModel("C++ - Basics","https://drive.google.com/open?id=15nzpkRagehH1y1qsX-KuMXdF-gzbJax0"))
        files.add(filesDetailsModel("C++","https://drive.google.com/open?id=1466X3BS8ssqaqFDCxVIjVoV3apbh6IEp"))
        files.add(filesDetailsModel("Circular DeQueue","https://drive.google.com/open?id=1NtMMoG8nwMms-rCKpIymSBIP7aG6r5yd"))
        files.add(filesDetailsModel("Cicular Queue DeQueue","https://drive.google.com/open?id=1ze_DDKdy953z65BFUkGkQYa_vPuaNkZf"))
        files.add(filesDetailsModel("Dynamic Memory Allocation","https://drive.google.com/open?id=1aP6upsm_4t0uzFzMj23VI0qQlqkHVRS6"))
        files.add(filesDetailsModel("File Handling","https://drive.google.com/open?id=1Kr-jJ4rY5jlnunzTP-Rrx8DYi3fiseHm"))
        files.add(filesDetailsModel("Functions - Revision","https://drive.google.com/open?id=1chpGR0a_LjCu27xwFikRfUAtnX7GHqqi"))
        files.add(filesDetailsModel("Handling structure using pointers","https://drive.google.com/open?id=1P-qTBrYyjAZsUSiYpI1EnqupuCak2S1O"))
        files.add(filesDetailsModel("Infix Prefix Postfix","https://drive.google.com/open?id=1pZNEBKfAMEkG7Lm-l_ZtZtG9ZHDhozJB"))
        files.add(filesDetailsModel("Inheritance","https://drive.google.com/open?id=1yl6GL89pKq1gHAErTuEuvpC_M2o-7tCE"))
        files.add(filesDetailsModel("Inheritance (2)","https://drive.google.com/open?id=1Q3Rk3isH9RHDE8mHjG3oQ6NFuCixS-xm"))
        files.add(filesDetailsModel("Introduction to OOP","https://drive.google.com/open?id=1qSOkvWnGiCKiJilWba-oyT5EHwb8O69m"))
        files.add(filesDetailsModel("Linked List - Applications","https://drive.google.com/open?id=1OsAgBOPB3TYOsNVyrHX5UAsJZ3ONVF_C"))
        files.add(filesDetailsModel("Linked List - Creation, Insertion, Traversal","https://drive.google.com/open?id=1WN1HJ3fRZHycQmvndXXsPAUmRlhlWG64"))
        files.add(filesDetailsModel("Linked List - Its operation","https://drive.google.com/open?id=15pX1_FtCqV2wlp3f-XlJdvLPGLkZml7f"))
        files.add(filesDetailsModel("Linked List - Programs","https://drive.google.com/open?id=1VsdpRI7WaHOrdF5GI2NRll-lYBV3QN-5"))
        files.add(filesDetailsModel("Linked List - Searching, Deletion, Application","https://drive.google.com/open?id=13OVt9fxQeL_QKLq9kjd7jp3qUErXgpc8"))
        files.add(filesDetailsModel("Linked List - Searching, Deletion","https://drive.google.com/open?id=1K5XtKMjE7ysO5snBZwQ25y-CXp4wqCz3"))
        files.add(filesDetailsModel("Objects - Concept","https://drive.google.com/open?id=11sEImG7oyJCXybWh_Tn1uRq-dSZF7USK"))
        files.add(filesDetailsModel("OOP - 1 : Overview of OOP","https://drive.google.com/open?id=1VI6hhr96-QnDuU9g0WFxM3TKWbcnKUwN"))
        files.add(filesDetailsModel("OOP -2 : Classes and Objects","https://drive.google.com/open?id=1oIZ1do56VmgLkNd26CsAdtSpWoVWVExq"))
        files.add(filesDetailsModel("Passing array structure to a function","https://drive.google.com/open?id=1bxdjVyKM0uT8rIz957NEyrOHEd0TRQVz"))
        files.add(filesDetailsModel("Pointer basics and function","https://drive.google.com/open?id=1WcUtbgl-S5LOn902PBXc6Cr6ilEIVoZe"))
        files.add(filesDetailsModel("Pointers and array passing","https://drive.google.com/open?id=1iVG3RjXJ4MllTHWdgZ4eazCWMnSgSUFU"))
        files.add(filesDetailsModel("Questions on pointer arithmetics","https://drive.google.com/open?id=1P0wBWGffJySPYsPDjSEGH_g7Yx5wyahl"))
        files.add(filesDetailsModel("Queue (2)","https://drive.google.com/open?id=1_4tOZJjvVrxJEZvoSfWi32AMnWMpOD54"))
        files.add(filesDetailsModel("Queue Application","https://drive.google.com/open?id=1Vg3YBDVNeuGkqWatGBLCzBYEL9_ybULS"))
        files.add(filesDetailsModel("Queue Circular Queue DeQueue","https://drive.google.com/open?id=1v4O9KZTi7eCkWJawvVW69vylwvFv2yDP"))
        files.add(filesDetailsModel("Queue","https://drive.google.com/open?id=1KMH5VoUNfX3ur106JEl6aL-RXEbeO7-X"))
        files.add(filesDetailsModel("Searching","https://drive.google.com/open?id=1Bebh0Ax-IumkqlHiaeUVg7tYE737aOQR"))
        files.add(filesDetailsModel("Singly Linked List","https://drive.google.com/open?id=1aGhwxaz_xY-k4ZfT3pKZB4uF0dRW-bWV"))
        files.add(filesDetailsModel("Sorting","https://drive.google.com/open?id=1ZbwTEEqe2TzX6BadzzEebErnSqMDQOmd"))
        files.add(filesDetailsModel("Sparse Matrix (2)","https://drive.google.com/open?id=1C_wgTrD3xSIlLev5oAkJP2L-HPZIhxv3"))
        files.add(filesDetailsModel("Sparse Matrix","https://drive.google.com/open?id=1TrtY4mUcPiDgJDGqdIn71U85lKFuBcRu"))
        files.add(filesDetailsModel("Using Linked List","https://drive.google.com/open?id=1Ft3YYT82B95u_TLKVcCT4Yygd1mriP59"))

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
