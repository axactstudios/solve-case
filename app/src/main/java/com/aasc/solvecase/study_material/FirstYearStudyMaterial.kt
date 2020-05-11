package com.aasc.solvecase.study_material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.aasc.solvecase.FirstYearActivity
import com.aasc.solvecase.R
import com.aasc.solvecase.SecondYearActivity
import kotlinx.android.synthetic.main.activity_first_year_study_material.*

class FirstYearStudyMaterial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year_study_material)

        rb_sdf.setOnClickListener {
            val intent = Intent(this, SDFActivity::class.java)
            startActivity(intent)
        }
        rb_mat.setOnClickListener {
            val intent = Intent(this, MathsActivity::class.java)
            startActivity(intent)
        }
        rb_phy.setOnClickListener {
            val intent = Intent(this, PhysicsActivity::class.java)
            startActivity(intent)
        }
        rb_es.setOnClickListener {
            val intent = Intent(this, EsActivity::class.java)
            startActivity(intent)
        }
    }

//    fun onRadioButtonClicked (view: View) {
//        if (view is RadioButton) {
//            val checked = view.isChecked
//
//            when (view.getId()) {
//                R.id.rb_sdf ->
//                    if (checked) {
//                        val intent = Intent(this, SDFActivity::class.java)
//                        Toast.makeText(this, "You selected SDF - II", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//                R.id.rb_mat ->
//                    if (checked) {
//                        val intent = Intent(this, MathsActivity::class.java)
//                        Toast.makeText(this, "You selected Maths - II", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//                R.id.rb_phy ->
//                    if (checked) {
//                        val intent = Intent(this, PhysicsActivity::class.java)
//                        Toast.makeText(this, "You selected Physics - II", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//                R.id.rb_es ->
//                    if (checked) {
//                        val intent = Intent(this, EsActivity::class.java)
//                        Toast.makeText(this, "You selected Electrical Science - II", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//            }
//        }
//    }
}
