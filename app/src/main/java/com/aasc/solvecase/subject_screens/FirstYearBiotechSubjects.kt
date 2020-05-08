package com.aasc.solvecase.subject_screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.aasc.solvecase.FileListScreen
import com.aasc.solvecase.R
import kotlinx.android.synthetic.main.first_year_subjects.*

class FirstYearBiotechSubjects : AppCompatActivity() {
    var year:String="FirstYear"
    var subject:String="basicmaths"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year_biotech_subjects)


        val bundle: Bundle? = intent.extras
        year = bundle!!.getString("yearid").toString()


        choose_subject_1.setOnClickListener {

            val intent = Intent(this, FileListScreen::class.java)
            intent.putExtra("subid",subject)
            intent.putExtra("yearid",year)
            // Toast.makeText(this,"You are viewing $subject",Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
    }


    fun onRadioButtonClicked(view: View){
        if(view is RadioButton) {
            val checked= view.isChecked

            when(view.getId()){
                R.id.basicmaths ->
                    if(checked){
                        subject="basicmaths"
                    }
                R.id.biotech ->
                    if(checked){
                        subject="biotech"
                    }
                R.id.fcp ->
                    if(checked){
                        subject="fcp"
                    }
                R.id.es ->
                    if(checked){
                        subject="es"
                    }
                R.id.basicbiolab ->
                    if(checked){
                        subject="basicbiolab"
                    }
                R.id.eslab ->
                    if(checked){
                        subject="esvlab"
                    }
                R.id.edd ->
                    if(checked){
                        subject="edd"
                    }
                R.id.cpl ->
                    if(checked){
                        subject="cpl"
                    }
            }
        }
    }
}
