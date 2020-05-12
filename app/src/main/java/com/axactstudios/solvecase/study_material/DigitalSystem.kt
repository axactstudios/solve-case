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
import kotlinx.android.synthetic.main.activity_digital_system.*
import java.util.*
import kotlin.collections.ArrayList

class DigitalSystem : AppCompatActivity(), onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital_system)

        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Arithmetic Circuits","https://drive.google.com/open?id=18aaHQqjI6qLkEvlYhGVdMr9beGgUAeas"))
        files.add(filesDetailsModel("Binary to Gray Code Conversion","https://drive.google.com/open?id=1wCM0EFx3NT_wE0LM08q4FqYyR89A9mh8"))
        files.add(filesDetailsModel("Boolean Functions","https://drive.google.com/open?id=1hSteJVpFWiea69Zu97_801gpPU-YIWpn"))
        files.add(filesDetailsModel("Boolean Lecture","https://drive.google.com/open?id=1arqZyQtDp_5ir_CulyPn5uzwJAwZaETX"))
        files.add(filesDetailsModel("Code Converter","https://drive.google.com/open?id=1tKcqDoOSwERWC8rWsPtWV7eH4rX96N-H"))
        files.add(filesDetailsModel("Combination Circuits","https://drive.google.com/open?id=13U0KaJgDGcJVmsY6pnWidsYG9Z0FLhYM"))
        files.add(filesDetailsModel("Complements","https://drive.google.com/open?id=1eT0aBJp7XhZXDMgMPmGhnFF-KCHj8kgv"))
        files.add(filesDetailsModel("Decoders","https://drive.google.com/open?id=1vT3LS3mAtsHIWl-A2OgfMTlUYUR7x_PF"))
        files.add(filesDetailsModel("Encoder","https://drive.google.com/open?id=1lycIvQuTY9-4-_XxU5vstzMevULtrL-z"))
        files.add(filesDetailsModel("Flip Flops","https://drive.google.com/open?id=1-jc8dqQq6KEtxwTZvH239jL9ldKoFLXD"))
        files.add(filesDetailsModel("IDS : Lecture - 1","https://drive.google.com/open?id=1-I1ke8PefwbwOWGYWXWN_N0bs1bJaW--"))
        files.add(filesDetailsModel("IDS : Lecture - 2, 3","https://drive.google.com/open?id=1pcWXoKf3CB6C6L4HvTTLpSbsuwaa-PgU"))
        files.add(filesDetailsModel("IDS : Lecture - 4","https://drive.google.com/open?id=1d5v5B_W3ou61FwtJvmLyqzWRhxDRk6eo"))
        files.add(filesDetailsModel("IDS : Lecture - 5, 6","https://drive.google.com/open?id=1bcvXTUTNVTzRuxaNtElElOuFHwNPJGVJ"))
        files.add(filesDetailsModel("IDS : Lecture - 7, 8, 9","https://drive.google.com/open?id=1p9Ymn6UEoGEhxTLJjzQHVoo9SrFlR4nU"))
        files.add(filesDetailsModel("K Map","https://drive.google.com/open?id=16bvvjD328DUTDDxLXF-aKCMLrspgnj7u"))
        files.add(filesDetailsModel("K Map - 2","https://drive.google.com/open?id=1H2DyNc98WR1LoL0CcNG0pTBGiO4OKGL0"))
        files.add(filesDetailsModel("Logic Gates","https://drive.google.com/open?id=1hcvnh93Wxga3m2BzCriKU7kGNH1TKCkK"))
        files.add(filesDetailsModel("QM Technique","https://drive.google.com/open?id=1lKXLe5eZ2rb37tyVv00R9W7t7ZMkrxfa"))
        files.add(filesDetailsModel("Simplification of incompletely specified functions using QM Technique","https://drive.google.com/open?id=1bMmhocMHkjhc2QYR9_LSmutZxPNmkv3H"))
        files.add(filesDetailsModel("Special K Map","https://drive.google.com/open?id=1t2uE7U9sdydieVXlyXyXUdrpNDpJMQkZ"))


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
