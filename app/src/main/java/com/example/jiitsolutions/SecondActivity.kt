package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)
        choose_subject.setOnClickListener {
            val id=yearGroup.checkedRadioButtonId
            val radioButton=findViewById<RadioButton>(id)
            Toast.makeText(this,"You Selected"+radioButton.text,Toast.LENGTH_SHORT).show()
            if(radioButton.text=="1")
            {
                val intent= Intent(this,FirstYearSubjects::class.java)
                startActivity(intent)
            }
            else if(radioButton.text=="2"){
                val intent= Intent(this,SecondYearSubjects::class.java)
                startActivity(intent)
            }
        }

        }
    }
