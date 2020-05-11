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
import kotlinx.android.synthetic.main.activity_algorithms_and_problem_solving.*
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*

class AlgorithmsAndProblemSolving : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithms_and_problem_solving)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Backtracking","https://drive.google.com/open?id=1E4YiowEx5u4wFik3__nQfU97COJ-kWD8"))
        files.add(filesDetailsModel("Dynamic Programming","https://drive.google.com/open?id=1E4YiowEx5u4wFik3__nQfU97COJ-kWD8"))
        files.add(filesDetailsModel("Greedy Algorithms","https://drive.google.com/open?id=1BGdWESpgGiYi-5EtcG9Tv1gnt1kBgEgF"))
        files.add(filesDetailsModel("Interval Tree","https://drive.google.com/open?id=1zHuPf509nxtcis2--_9xVX1QsktRFumE"))
        files.add(filesDetailsModel("Network Flow Problem","https://drive.google.com/open?id=1c46uHug4sS8GVBOCh6G-I9QkjxgRFT3M"))
        files.add(filesDetailsModel("Practice Questions","https://drive.google.com/open?id=1iaB3fRMiM-VxGUlpJ1o1AykI0109gsSR"))
        files.add(filesDetailsModel("Problem Solving By Search","https://drive.google.com/open?id=1QGnrU5ULptUj9tZ-nYgvMMt8NhHRrhcd"))
        files.add(filesDetailsModel("Segment Tree","https://drive.google.com/open?id=1EYb8ct3BtxiQXEDTf6OA7aYZHU_jNNgH"))
        files.add(filesDetailsModel("Strassen's Matrix Multiplication","https://drive.google.com/open?id=1WrsQmueAuvMAcJg_ymLUDQkUXMuAp6NP"))
        files.add(filesDetailsModel("Strassen's Matrix Multiplication - 2","https://drive.google.com/open?id=1FJkxbZ2976UyZPKuzkP2vMsEx0o5M0Gv"))
        files.add(filesDetailsModel("String Algorithms","https://drive.google.com/open?id=1-Q5pXuhSYIFSazAbN34ygamUN8nbicD4"))

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
