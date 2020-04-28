package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_year_subjects.*

class FirstYearSubjects :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_year_subjects)
        choose_subject_1.setOnClickListener {
            val intent= Intent(this,FileListScreen::class.java)
            startActivity(intent)
        }
    }
    }
