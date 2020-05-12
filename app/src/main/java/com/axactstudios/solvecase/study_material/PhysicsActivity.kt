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
import kotlinx.android.synthetic.main.activity_physics2.*
import java.util.*
import kotlin.collections.ArrayList

class PhysicsActivity : AppCompatActivity(),onFilesClickListenerListener {

    var files = ArrayList<filesDetailsModel>()
    var displayList = ArrayList<filesDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics2)


        var recyclerView : RecyclerView = findViewById(R.id.studymatrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        files.add(filesDetailsModel("Atomic and Molecular Spectroscopic Techniques","https://drive.google.com/open?id=16kLj535z0UTC8ziFBX2oSZjQF0NyKPNY"))
        files.add(filesDetailsModel("Binding In Solids","https://drive.google.com/open?id=1FdS5ccBqjWj9__7ak3MT56dOJXFERgty"))
        files.add(filesDetailsModel("Coordinate System","https://drive.google.com/open?id=1Vl1O0CF3U_HEy5D3kyZxSw2dH2bC6xlo"))
        files.add(filesDetailsModel("Coordinate System (2)","https://drive.google.com/open?id=102f16lfX04tzzF6_OzqCH2wG42IpWq4B"))
        files.add(filesDetailsModel("Crystal Geometry","https://drive.google.com/open?id=1aGgukB-BtycxijorHAI_6n5pWJTVhrk-"))
        files.add(filesDetailsModel("Crystal Structure","https://drive.google.com/open?id=1aN3i1lCwvub7P4jHgv9PP0g15pCLsEEP"))
        files.add(filesDetailsModel("Discharge Tube","https://drive.google.com/open?id=1HlAKrEITcVoqbIBNkzGCGmX92OWrWQMC"))
        files.add(filesDetailsModel("Electronic Spectroscopy Of Atoms","https://drive.google.com/open?id=1P-iZKTjS-UI4n9QkSX5yXm8Dp9OiHQNw"))
        files.add(filesDetailsModel("Electrostatics - 1","https://drive.google.com/open?id=1lYqIzuHivPEPYpW3T8k_b5m0EUNzHSJU"))
        files.add(filesDetailsModel("Electrostatics -2","https://drive.google.com/open?id=1LjxJEiV4Jd7KmVVSSudV2F9vh0287lxl"))
        files.add(filesDetailsModel("Fiber Optics","https://drive.google.com/open?id=1nbest-tKQ0iNc_Yh_o7dI7lml1STr6Wp"))
        files.add(filesDetailsModel("Free electron theory and band theory","https://drive.google.com/open?id=1lobhb4A_3S0pW3oecuNrl-x7CqZbh_JC"))
        files.add(filesDetailsModel("Gauss law and its application","https://drive.google.com/open?id=133864pZLPXJWhqZYkWgchvOZS5ETHFD6"))
        files.add(filesDetailsModel("Gradient divergence curl","https://drive.google.com/open?id=1METXk76FNFlcKexWeZXTpLSVI2bDY-ys"))
        files.add(filesDetailsModel("Interaction of X-rays with materials","https://drive.google.com/open?id=1EECUVrVO1Hefo190Q6A86cwGnBluob8g"))
        files.add(filesDetailsModel("Laser","https://drive.google.com/open?id=15dKcG6E-OyMcTfzdQ4OlHRQLZNiUmjQc"))
        files.add(filesDetailsModel("Microstructure analysis","https://drive.google.com/open?id=1srwXkbh01p4lJ_jS3yKeJU6PSuzP8Hu7"))
        files.add(filesDetailsModel("Oblique Incidence","https://drive.google.com/open?id=1zISOpoiIC5c9AOBZ0zbtAqMlSkuBnqoZ"))
        files.add(filesDetailsModel("Problem solving by Laplace - Poisson's equation","https://drive.google.com/open?id=1vNg6t7lw8wujXeC9Mz0zcb9WTzaQtYpc"))
        files.add(filesDetailsModel("Scanning probe Microscopy","https://drive.google.com/open?id=1AT0cwF2oImyNwFy_alCd5lTjBO30hXPS"))
        files.add(filesDetailsModel("Scattering by X-rays","https://drive.google.com/open?id=1RS3-hDdOZ4KOZ4JPJZqomT_tta3C2TKn"))
        files.add(filesDetailsModel("Statistical mechanics","https://drive.google.com/open?id=1HvuNs-hJhAcsf7W9Ok8niCirpnrRkRou"))
        files.add(filesDetailsModel("TEM","https://drive.google.com/open?id=1gIuha3RgCo5wJn9WMoKAO-Y8uA5tFWwe"))
        files.add(filesDetailsModel("Thermal Analysis","https://drive.google.com/open?id=1qPh_rQFSDrmmHEFX3jlK1FHl35Uk_fa1"))
        files.add(filesDetailsModel("X-rays generation","https://drive.google.com/open?id=16Ma3zxYZ5SCiFi2EM6F9gKNLT4NewiaD"))

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
