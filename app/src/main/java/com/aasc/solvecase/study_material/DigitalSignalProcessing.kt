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
import kotlinx.android.synthetic.main.activity_digital_signal_processing.*
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*

class DigitalSignalProcessing : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital_signal_processing)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Lecture - 0","https://drive.google.com/open?id=1mfT3U2XFoIU3m-8V6dcBpfzZynpWwwV1"))
        files.add(filesDetailsModel("Lecture - 1","https://drive.google.com/open?id=1yxtNt-GFaJtmKaX-Z8_u7oQYr6wKGCow"))
        files.add(filesDetailsModel("Lecture - 2","https://drive.google.com/open?id=1MAOHZjJXhpyt6fOfrULyWXpqK2XeYY0u"))
        files.add(filesDetailsModel("Lecture - 3","https://drive.google.com/open?id=1ff4LUYqZyXQJPAQPwq9Nz4YOcP6_zM5C"))
        files.add(filesDetailsModel("Lecture - 4","https://drive.google.com/open?id=18I02gtbnMpiv_ej9j6FyyLKihThRoHr0"))

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
