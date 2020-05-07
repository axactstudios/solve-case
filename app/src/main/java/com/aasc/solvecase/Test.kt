package com.aasc.solvecase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.test.*

class Test :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        firstYearButton.setOnClickListener {
            val intent = Intent(this, FirstYearSubjects::class.java)
            intent.putExtra("yearcode", "FirstYear")
            //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        secondYearButton.setOnClickListener {
            val intent = Intent(this, SecondYearSubjects::class.java)
            intent.putExtra("yearcode", "FirstYear")
            //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}