package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_options_screen.*

class OptionsScreen : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_screen)

        mAuth = FirebaseAuth.getInstance()

        download.setOnClickListener {
            var intent=Intent(this,Test::class.java)
            startActivity(intent)
        }
        download_1.setOnClickListener {
            var intent=Intent(this,Test::class.java)
            startActivity(intent)
        }
        lectures.setOnClickListener {
            val intent = Intent(this,VideoLecturesActivity::class.java)
            startActivity(intent)
        }
        lectures_1.setOnClickListener {
            val intent = Intent(this,VideoLecturesActivity::class.java)
            startActivity(intent)
        }
        developed_by.setOnClickListener {
            val intent = Intent(this, KnowDevelopers::class.java)
            startActivity(intent)
        }
        developed_by_1.setOnClickListener {
            val intent = Intent(this, KnowDevelopers::class.java)
            startActivity(intent)
        }
        contact_us.setOnClickListener {
            val intent = Intent(this, ContactPage::class.java)
            startActivity(intent)
        }
        contact_us_1.setOnClickListener {
            val intent = Intent(this, ContactPage::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        if (mAuth.currentUser == null) {
            Toast.makeText(this,"Please login first", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,PhoneActivity::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this,"Logged in", Toast.LENGTH_SHORT).show()
        }
    }
}
