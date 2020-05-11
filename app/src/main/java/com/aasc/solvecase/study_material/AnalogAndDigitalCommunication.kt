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
import kotlinx.android.synthetic.main.activity_analog_and_digital_communication.*
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*
import kotlin.collections.ArrayList

class AnalogAndDigitalCommunication : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analog_and_digital_communication)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("9 - 10","https://drive.google.com/open?id=1UomEDsKIpZKIw_zIV-4sp2WifXbBcdyE"))
        files.add(filesDetailsModel("11 - 12","https://drive.google.com/open?id=1XASJlZ7ZO0BGgG5XvxH7MHUUecmdvwW1"))
        files.add(filesDetailsModel("13 - 14","https://drive.google.com/open?id=1mbAzEFx2lhyiD2Ny9IC0gimtjsrHFkjq"))
        files.add(filesDetailsModel("15 - 16","https://drive.google.com/open?id=1BEGXta6BI1sKfWnNb3bKz6GWYdVS9sV9"))
        files.add(filesDetailsModel("19 - 20","https://drive.google.com/open?id=1HQVAojVL1EXq40_JzGM7qwoOIOM59PV3"))
        files.add(filesDetailsModel("26","https://drive.google.com/open?id=1N7CZq6mqyshB2rxSIhRbU1vLvm7iLbLP"))
        files.add(filesDetailsModel("AM","https://drive.google.com/open?id=1NiPAEkt6ZMExeMCcOzJvfzyl08S2Uzsz"))
        files.add(filesDetailsModel("FM","https://drive.google.com/open?id=1qsWkxrkxUHoBFZ09niCWoWxSTLCJHPw8"))


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

