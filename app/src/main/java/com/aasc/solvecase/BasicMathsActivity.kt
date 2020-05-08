package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*
import kotlin.collections.ArrayList

class BasicMathsActivity : AppCompatActivity(), onVideoItemClickListener {

    var video = ArrayList<videoDetailsModel>()
    val displayList = ArrayList<videoDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_maths)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        video.add(videoDetailsModel("What is the Cartesian Coordinate System?","mgx0kT5UbKk"))
        video.add(videoDetailsModel("Distance Between Two Points","0IOEPcAHgi4"))
        video.add(videoDetailsModel("Various Forms of Equation of Line","Qc73OPDgcvU"))
        video.add(videoDetailsModel("Different Form of Equation of Circle","-9UYc8Tk30A"))
        video.add(videoDetailsModel("Different Equations of Parabola","w_D9NW_rgA4"))
        video.add(videoDetailsModel("Equations of Ellipses","emShn_sWhCo"))
        video.add(videoDetailsModel("Equation of a Tangent to a Curve","N_FM6aON2z8"))
        video.add(videoDetailsModel("Area of triangles","oIkBUw9MCeI"))
        video.add(videoDetailsModel("Vector & 3D L-1 Part - 1","I_TAegehtRU"))
        video.add(videoDetailsModel("Vector & 3D L-1 Part - 2","acgHwgjDWkk"))
        video.add(videoDetailsModel("Vector & 3D L- 2 Part - 1","H0ItmJKamIk"))
        video.add(videoDetailsModel("Vector & 3D L- 2 Part - 2","V1_reINL-f4"))
        video.add(videoDetailsModel("Vector & 3D L-03 Part-01","aKLZA7U74vo"))
        video.add(videoDetailsModel("Vector & 3D L-03 Part-02","Nogse-U4hGk"))
        video.add(videoDetailsModel("Vector & 3D L-03 Part-03","XY_FjymAoZw"))
        video.add(videoDetailsModel("Vector & 3D L-04 P-01","6AEQlvUx5Hk"))
        video.add(videoDetailsModel("Vector & 3D L-04 P-02","6aTgCtWCOQg"))
        video.add(videoDetailsModel("Vector & 3D L-04 P-03","gNThgmln2_w"))
        video.add(videoDetailsModel("Vector & 3D L-05 P-1","mbPaqOel4AM"))
        video.add(videoDetailsModel("Vector & 3D L-05 P-2","5a8k6ONk3Sw"))
        video.add(videoDetailsModel("Vector & 3D L-05 P-3","UGkLolM9b70"))
        video.add(videoDetailsModel("Vector & 3D L-06 P-1","sCzdpyjm4Zo"))
        video.add(videoDetailsModel("Vector & 3D L-06 P-2","4qfGnx_h8Qs"))
        video.add(videoDetailsModel("Vector & 3D L-06 P-3","-I7PpY46WUk"))
        video.add(videoDetailsModel("Vector & 3D L-07 P-1","MFWbY8tGSis"))
        video.add(videoDetailsModel("Vector & 3D L-07 P-2","phiB0eMDyz4"))
        video.add(videoDetailsModel("Vector & 3D L-07 P-3","Wl2NHd3eiDQ"))
        video.add(videoDetailsModel("Partial Differentiation Example And Solution","eTp5wq-cSXY"))
        video.add(videoDetailsModel("Taylor Series | Taylor Theorem | Proof & Series Expansion","LEspaisjDFE"))
        video.add(videoDetailsModel("Concept of Vector Point Function & Vector Differentiation","FfJtVvQtqTM"))
        video.add(videoDetailsModel("Gradient of a Scalar Field & Directional Derivative","9CHfHuFBTw8"))
        video.add(videoDetailsModel("Introduction to differential equations","bes1qqJIsOQ"))
        video.add(videoDetailsModel("Order and degree of differential equations","1FVvKOyD9AM"))
        video.add(videoDetailsModel("Linear & nonlinear differential equations","CrkLReHuR50"))
        video.add(videoDetailsModel("Differential equation solution separable variables","HgSv7be1dy0"))
        video.add(videoDetailsModel("Solution of differential equations by separating","G6h4YCFits8"))
        video.add(videoDetailsModel("Separable form of a differential equations","kTQBZlkA3oM"))
        video.add(videoDetailsModel("Differential equation reducible to separable form","2oVOs36wNPI"))
        video.add(videoDetailsModel("Differntial equation general solutions by separating variable","x_PGHuzg140"))
        video.add(videoDetailsModel("Homogeneous differential equations","Qu-sJQ1QNYw"))
        video.add(videoDetailsModel("Homogeneous differential equations problem 1","CkygOJHScDg"))
        video.add(videoDetailsModel("Exact differential equations introduction","kYkUrQjrTj0"))
        video.add(videoDetailsModel("Differential equation first order differential equation","AjfHzYWOosI"))
        video.add(videoDetailsModel("First order differential equation introduction","5Tg8tPm6NhQ"))
        video.add(videoDetailsModel("First order differential equation integrating factor","V_Of_XIIK7c"))
        video.add(videoDetailsModel("Bisection Method | Numerical Methods","3j0c_FhOt5U"))
        video.add(videoDetailsModel("Newton Raphson Method | Numerical Methods","7eHuQXMCOvA"))

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
