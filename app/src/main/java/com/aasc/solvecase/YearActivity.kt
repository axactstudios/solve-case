package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.aasc.solvecase.study_material.FirstYearStudyMaterial
import com.aasc.solvecase.study_material.SecondYearStudyMaterial
import kotlinx.android.synthetic.main.activity_year.*

class YearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_year)
        rb_fy.setOnClickListener {
            val intent = Intent(this, FirstYearStudyMaterial::class.java)
            startActivity(intent)
        }
        rb_fy2.setOnClickListener {
            val intent = Intent(this, FirstYearStudyMaterial::class.java)
            startActivity(intent)
        }
        rb_fy3.setOnClickListener {
            val intent = Intent(this, FirstYearStudyMaterial::class.java)
            startActivity(intent)
        }
        rb_sy.setOnClickListener {
            val intent = Intent(this, SecondYearStudyMaterial::class.java)
            startActivity(intent)
        }
        rb_sy2.setOnClickListener {
            val intent = Intent(this, SecondYearStudyMaterial::class.java)
            startActivity(intent)
        }
        rb_sy3.setOnClickListener {
            val intent = Intent(this, SecondYearStudyMaterial::class.java)
            startActivity(intent)
        }

    }

//    fun onRadioButtonClicked (view: View) {
//        if (view is RadioButton) {
//            val checked = view.isChecked

//            when (view.getId()) {
//                R.id.rb_fy ->
//                    if (checked) {
//                        val intent = Intent(this, FirstYearStudyMaterial::class.java)
//                        Toast.makeText(this, "You selected First Year", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//                R.id.rb_sy ->
//                    if (checked) {
//                        val intent = Intent(this, SecondYearStudyMaterial::class.java)
//                        Toast.makeText(this, "You selected Second Year", Toast.LENGTH_SHORT).show()
//                        startActivity(intent)
//                    }
//            }
//        }
//    }
}
