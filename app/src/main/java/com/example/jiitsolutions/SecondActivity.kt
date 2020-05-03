package com.example.jiitsolutions

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {
    var yearCode="1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)
//choose_subject.setBackgroundColor(Color.rgb(137,205,171))

        knw_btn.setOnClickListener {
            val intent = Intent(this, KnowDevelopers::class.java)
            startActivity(intent)
        }
        btn_contact.setOnClickListener {
            val intent = Intent(this, ContactPage::class.java)
            startActivity(intent)
        }
        choose_subject.setOnClickListener {
            if(yearCode=="1") {
                val intent = Intent(this, FirstYearSubjects::class.java)
                intent.putExtra("yearcode", "FirstYear")
             //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else{
                val intent = Intent(this, SecondYearSubjects::class.java)
                intent.putExtra("yearcode", "SecondYear")
                Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.firstYear ->
                    if (checked) {
                        yearCode="1"
                    }
                R.id.secondYear ->
                    if (checked) {
                        yearCode="2"
                    }
            }
        }

    }
}