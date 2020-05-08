package com.aasc.solvecase

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

class MathsActivity : AppCompatActivity(), onVideoItemClickListener  {

    var video = ArrayList<videoDetailsModel>()
    val displayList = ArrayList<videoDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        video.add(videoDetailsModel("Linear Higher Order Differential Equation | CF & PI |Lecture-I","tHqx1qxA8q4"))
        video.add(videoDetailsModel("Linear Higher Order Differential Equation | CF & PI |Lecture-II","EwsAq2zqyew"))
        video.add(videoDetailsModel("Homogeneous cauchy-euler Second Order Differential Equations","1HKn9IvYiEM"))
        video.add(videoDetailsModel("Second Order Exact Differential Equation with Variable Coefficient","UOYp8k_hHXQ"))
        video.add(videoDetailsModel("Solution of Second Order Differential Equation | Part of CF is Known","JsqGebEvxfQ"))
        video.add(videoDetailsModel("Second Order Differential Equation - Change of Dependent Variable Method","J7kxzE2vqwg"))
        video.add(videoDetailsModel("Second Order Differential Equation - Change of Independent Variable Method","K1LPzOCIwY8"))
        video.add(videoDetailsModel("Variation of Parameter Method - Second Order Differential Equation","jiQ2sX5wGwM"))
        video.add(videoDetailsModel("Series Solution of Differential Equation | Ordinary Point and Singular Point","nWqeWe79o0w"))
        video.add(videoDetailsModel("Series Solution of Differential Equation | Legendre Polynomial | Power Series Method","MGLgDlE_uaU"))
        video.add(videoDetailsModel("Series Solution of Differential Equation | Frobenius Method | Bessel's equation","GH7-eaZ5pXc"))
        video.add(videoDetailsModel("Infinite Series - Convergence Of Infinite Series | Basic Concepts","vfg1mmsSMMM"))
        video.add(videoDetailsModel("Infinite Series - Comparison Test For Convergence of Series | Calculus","S-qzRWJOlf8"))
        video.add(videoDetailsModel("Infinite Series - Cauchy's Integral Test For Convergence of Series","2SJ7vcJpTd8"))
        video.add(videoDetailsModel("Infinite Series - D'Alembert's Ratio Test For Convergence of Series","9sLsX9DV5Fs"))
        video.add(videoDetailsModel("Infinite Series -Cauchy Root Test For Convergence of Series | Calculus","tF4vDQ6X7Kg"))
        video.add(videoDetailsModel("Infinite Series -Raabe's Test For Convergence of Series | Calculus","99Hpoc1-uDo"))
        video.add(videoDetailsModel("Infinite Series - Logarithmic Test For Convergence of Series |Calculus","d78ceBDfYQE"))
        video.add(videoDetailsModel("Infinite Series- De Morgan & Bertrand's Test For Convergence of Series","7JSiSwQlTAE"))
        video.add(videoDetailsModel("Alternating Series | Leibniz Test | Convergence Of Infinite Series","AG5mvNsxlXo"))
        video.add(videoDetailsModel("Absolute Convergence | Conditionally Convergent | Infinite Series","EX6zkLpHIec"))
        video.add(videoDetailsModel("Conditionally Convergent Series | Alternating Series | Infinite Series","HVrFbxKbZ6I"))
        video.add(videoDetailsModel("Weiestrass M test for uniform convergence","v0eo3n9zFvY"))
        video.add(videoDetailsModel("Bessel's Function | Recurrence Relation of Bessel's Function | Proofs","zVbcglXP1NE"))
        video.add(videoDetailsModel("Bessel's Function | Recurrence Relation of Bessel's Function | Part-II","DERYR2M0JSA"))
        video.add(videoDetailsModel("Bessel's Function | Important Example Problem of Bessel's Function","VDD8Et_B_ck"))
        video.add(videoDetailsModel("Bessel's Function | Orthogonal Property of Bessel Function | Proof","SPdf2n0YJXk"))
        video.add(videoDetailsModel("Legendre Polynomial | Rodrigues Formula | Proof of Rodrigues Formula","fNYyJE4FEzc"))
        video.add(videoDetailsModel("Legendre Polynomials | Generating Function of Legendre Polynomial","cIymUA0hu4s"))
        video.add(videoDetailsModel("Legendre Polynomials | Recurrence Relation Of Legendre Polynomials","pUjt-D9Nh_Q"))
        video.add(videoDetailsModel("Legendre Polynomial | Orthogonal Properties of Legendre Polynomial","RDU7FTqgx7s"))
        video.add(videoDetailsModel("Fourier Series examples and solutions for Even and Odd Function","NdouX5-KD6Y"))
        video.add(videoDetailsModel("Half Range Fourier Sine and Cosine Series Example","Sq2FhCxcyI8"))
        video.add(videoDetailsModel("Harmonic Analysis 2018 in Fourier Series","X-z6e1zZw80"))
        video.add(videoDetailsModel("Classification of Partial Differential Equation of Second Order","aKUIwYXhGkI"))
        video.add(videoDetailsModel("Classification of Partial differential Equation in three Independent Variables of second order","WjEwyPua6tY"))
        video.add(videoDetailsModel("Characteristic Equation and Characteristic Curve of PDE | Cauchy's Second Order PDE","ADbhzrzLGFU"))
        video.add(videoDetailsModel("Canonical form of Second order Partial Differential Equation","U6F5seb8PwA"))
        video.add(videoDetailsModel(" Canonical form of one dimensional wave equation and its solution","ugqcCSmc8ZU"))
        video.add(videoDetailsModel("D'Alembert Solution of One Dimensional Wave Equation","exvvzbMMd6g"))
        video.add(videoDetailsModel("Canonical form of Second order Partial Differential Equation | Canonical form of PARABOLIC of PDE","JAKhwhELTOo"))
        video.add(videoDetailsModel("Canonical form of Elliptic of PDE","4qB2RUM0Xfs"))
        video.add(videoDetailsModel("Classification of second order partial differential equations | Classification of 2nd order PDE","euuQMr_wPpo"))
        video.add(videoDetailsModel("Solution of Laplace Equation using Method of separation of variables","9LOU1lGRUBQ"))
        video.add(videoDetailsModel("Complex Analysis | Analytic Function | Cauchy Riemann Equation","t9xW7UaZwZ0"))
        video.add(videoDetailsModel("Complex Analysis - Short Trick To Find Harmonic Conjugate","OQQqbV32b78"))
        video.add(videoDetailsModel("Complex Analysis - Analytic Function | Milne Thomson Method","ABNW9FcZ5zQ"))
        video.add(videoDetailsModel("Complex Analysis - Bilinear transformation | Conformal Mappings","xgnQTqMc6A4"))
        video.add(videoDetailsModel("Complex Analysis -Complex Integration Line Integral Example & Solution","ywQVarOaA60"))
        video.add(videoDetailsModel("Cauchy's Integral Formula For Analytic Function","fSoQxuVdKIs"))
        video.add(videoDetailsModel("Complex Analysis - Cauchy's Residue Theorem & Its Application","4yC4IXcMKJg"))
        video.add(videoDetailsModel("Complex Analysis- Contour Integration | Application of Residue Theorem","xaKTNENeJdA"))
        video.add(videoDetailsModel("Complex Analysis - Contour integration | Evaluation of Improper Integrals","enF9OuOC9MA"))
        video.add(videoDetailsModel("Complex Analysis - Taylor Series For Complex Variable","xls_5Ly7VA4"))
        video.add(videoDetailsModel("Complex Analysis -Laurent Series For Complex Number","gUmIrJRXDSs"))

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