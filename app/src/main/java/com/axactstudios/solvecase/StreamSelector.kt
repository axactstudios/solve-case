package com.axactstudios.solvecase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.axactstudios.solvecase.subject_screens.*
import kotlinx.android.synthetic.main.test.*

class StreamSelector :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        firstYearButton.setOnClickListener {
            val intent = Intent(this, FirstYearSubjects::class.java)
            intent.putExtra("yearcode", "FirstYear")
            //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        secondYearButton_cse.setOnClickListener {
//            val intent = Intent(this, SecondYearSubjects::class.java)
//            intent.putExtra("yearcode", "SecondYear")
//            //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
//            startActivity(intent)

            Toast.makeText(this,"Will be available soon", Toast.LENGTH_SHORT).show()
        }
        firstYearBiotech.setOnClickListener {
            val intent=Intent(this,
                FirstYearBiotechSubjects::class.java)
            intent.putExtra("yearcode","FirstYear")
            startActivity(intent)
        }
        secondYearButton_ece.setOnClickListener {
//            val intent=Intent(this,
//                SecondYearSubjectsECE::class.java)
//            intent.putExtra("yearcode","SecondYear")
//            startActivity(intent)
            Toast.makeText(this,"Will be available soon", Toast.LENGTH_SHORT).show()
        }
        secondYearButton_biotech.setOnClickListener {
//            val intent=Intent(this,
//                SecondYearSubjectsBiotech::class.java)
//            intent.putExtra("yearcode","SecondYear")
//            startActivity(intent)
            Toast.makeText(this,"Will be available soon", Toast.LENGTH_SHORT).show()
        }

    }
}