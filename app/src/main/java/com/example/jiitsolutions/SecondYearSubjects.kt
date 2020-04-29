package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_year_subjects.*
import kotlinx.android.synthetic.main.second_year_subjects.*

class SecondYearSubjects :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_year_subjects)

        val bundle: Bundle? = intent.extras
        val year = bundle!!.getString("yearid")

        Toast.makeText(this,year,Toast.LENGTH_SHORT).show()

      choose_subject_2.setOnClickListener {
          val intent= Intent(this,FileListScreen::class.java)
          startActivity(intent)
      }
    }
}