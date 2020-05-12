package com.axactstudios.solvecase

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*
import kotlin.collections.ArrayList

class ESActivity : AppCompatActivity(), onVideoItemClickListener  {

    var video = ArrayList<videoDetailsModel>()
    val displayList = ArrayList<videoDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e_s)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        video.add(videoDetailsModel("Circuit terminology: Concept of loop, mesh, node and branch explained","zUGaU4kZpag"))
        video.add(videoDetailsModel("Voltage, current and power explained","eFPTBATfX70"))
        video.add(videoDetailsModel("Ohm's law","PV8CMZZKrB4"))
        video.add(videoDetailsModel("Classification of electrical network","4LgSLToLSCU"))
        video.add(videoDetailsModel("Capacitor work","R2QQ0yiqH_U"))
        video.add(videoDetailsModel("Source tranformation","FtEU5ZoO-fg"))
        video.add(videoDetailsModel("KCL","n__cezo9R1U"))
        video.add(videoDetailsModel("KVL","dlROTnDbULo"))
        video.add(videoDetailsModel("Independent and dependent source","SfKw8bHk7-o"))
        video.add(videoDetailsModel("Delta to star conversion","OV0qi7yzKAM"))
        video.add(videoDetailsModel("Star to delta","9b17eqCT4-g"))
        video.add(videoDetailsModel("Supernode Analysis Explained","iIswDPKSQT4"))
        video.add(videoDetailsModel("Supermesh Explained","iIswDPKSQT4"))
        video.add(videoDetailsModel("Superposition Theorem Explained","S0GsrzjVkd4"))
        video.add(videoDetailsModel("Thevenin's Theorem Explained","8udwPc5pCoA"))
        video.add(videoDetailsModel("Norton's Theorem Explained","DdLA8rntWEY"))
        video.add(videoDetailsModel("Maximum Power Transfer Theorem for DC Circuits","RbII8o49Hvs"))
        video.add(videoDetailsModel("RMS (Root Mean Square) Value and Average Value of AC Signals","qDHsokTcgck"))
        video.add(videoDetailsModel("Phasor and The Phasor Diagram in AC Circuits Explained","zlmwmvijn1Y"))
        video.add(videoDetailsModel("Phasor Diagram of RL, RC and RLC Circuits (with Examples)","HaFrY0qQ-NU"))
        video.add(videoDetailsModel("What is Power Factor?","iDYWfBGwT1w"))
        video.add(videoDetailsModel("Self Inductance and Mutual Inductance Explained","hoTInTKij0o"))
        video.add(videoDetailsModel("Dot Convention in Magnetically Coupled Circuits","sILgO4sQmRs"))
        video.add(videoDetailsModel("Mutually Coupled Inductors in Series","49OL_3L7BFA"))
        video.add(videoDetailsModel("Mutually Coupled Inductors in Parallel","NacczEJj_iI"))
        video.add(videoDetailsModel("Solved Problems on Magnetically Coupled Circuits","1tmdiGvvzzw"))
        video.add(videoDetailsModel("Maximum Power Transfer Theorem for AC Circuits","Z1dPepyz7Uk"))
        video.add(videoDetailsModel("Transient Analysis: Behaviour of Basic Circuit Elements","3YinmbkU0DE"))
        video.add(videoDetailsModel("Transient Analysis: First order R C and R L Circuits","KylJ2v1_c-o"))
        video.add(videoDetailsModel("Transient Analysis: Solved Examples on First order RC and RL Circuits","zDcXt9Vx34o"))
        video.add(videoDetailsModel("Transient Analysis of the RLC Circuit (with Examples)","B4TezoTORYA"))
        video.add(videoDetailsModel("Series Resonance in RLC Circuit","YLGrugmDvc0"))
        video.add(videoDetailsModel("Resonance in Parallel RLC Circuit Explained","mt3WwcQuJSE"))
        video.add(videoDetailsModel("Introduction to Two-Port Networks","ru2ItcD6unI"))
        video.add(videoDetailsModel("Z Parameters Explained | Condition for Reciprocity and Symmetry for Z- Parameters","AfszO1HZqzo"))
        video.add(videoDetailsModel("Solved Problems on Z - Parameters","UQyoUacFrfQ"))
        video.add(videoDetailsModel("Y- Parameters Explained | Condition of Reciprocity and Symmetry for Y- parameters","Ph0UlER9S08"))
        video.add(videoDetailsModel("h- parameters (Hybrid Parameters) Explained | Condition for Reciprocity and Symmetry","EC83XRahOSg"))
        video.add(videoDetailsModel("ABCD Parameters (Transmission Parameters) Explained","qnHaOwYfzgE"))

        displayList.addAll(video)

        var adapter = recyclerViewAdapter(displayList,clickListener = this)

        recyclerView.setAdapter(adapter)
    }

    override fun onItemClick(item: videoDetailsModel, position: Int) {
        //Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        val intent = Intent(this,YouTubePlayerActivity::class.java)
        intent.putExtra("videoname",item.title)
        intent.putExtra("videokey",item.videokey)
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
                        video.forEach {
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }

                        recyclerView.adapter!!.notifyDataSetChanged()

                    }

                    else {
                        displayList.clear()
                        displayList.addAll(video)
                        recyclerView.adapter!!.notifyDataSetChanged()
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