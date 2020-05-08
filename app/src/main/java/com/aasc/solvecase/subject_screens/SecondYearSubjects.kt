package com.aasc.solvecase.subject_screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.aasc.solvecase.FileListScreen2
import com.aasc.solvecase.R
import kotlinx.android.synthetic.main.first_year_subjects.*

class SecondYearSubjects :AppCompatActivity(){
    var year:String="SecondYear"
    var subject:String="prp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_year_subjects)

        val bundle: Bundle? = intent.extras
        year = bundle!!.getString("yearid").toString()


        choose_subject_1.setOnClickListener {

            val intent = Intent(this, FileListScreen2::class.java)
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
                R.id.prp ->
                    if(checked){
                        subject="prp"
                    }
                R.id.ds ->
                    if(checked){
                        subject="ds"
                    }
                R.id.coa ->
                    if(checked){
                        subject="coa"
                    }
                R.id.es ->
                    if(checked){
                        subject="es"
                    }
                R.id.dslab ->
                    if(checked){
                        subject="dslab"
                    }
                R.id.coalab ->
                    if(checked){
                        subject="coalab"
                    }
                R.id.ls ->
                    if(checked){
                        subject="ls"
                    }

            }
        }
    }
}