package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_options_screen.*

class OptionsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_screen)

        download.setOnClickListener {
            var intent = Intent(this, StreamSelector::class.java)
            startActivity(intent)
        }
        download_1.setOnClickListener {
            var intent = Intent(this, StreamSelector::class.java)
            startActivity(intent)
        }
        study_material.setOnClickListener {
            val intent = Intent(this,YearActivity::class.java)
            startActivity(intent)
        }
        study_material_1.setOnClickListener {
            val intent = Intent(this,YearActivity::class.java)
            startActivity(intent)
        }
        lectures.setOnClickListener {
            val intent = Intent(this, VideoLecturesActivity::class.java)
            startActivity(intent)
        }
        lectures_1.setOnClickListener {
            val intent = Intent(this, VideoLecturesActivity::class.java)
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
        invite.setOnClickListener {
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hey I started using this awesome app solve-case, It is a complete package for us, it contains all the study material and assignment solutions. Moreover it also has lecture videos from the best teachers on all the topics of our course. Download the app now from playstore :: https://play.google.com/store/apps/details?id=com.aasc.solvecase")
            intent.type= "text/plain"
            startActivity(Intent.createChooser(intent, "Share on:"))
        }
        invite_1.setOnClickListener {
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hey I started using this awesome app solve-case, It is a complete package for us, it contains all the study material and assignment solutions. Moreover it also has lecture videos from the best teachers on all the topics of our course. Download the app now from playstore :: https://play.google.com/store/apps/details?id=com.aasc.solvecase")
            intent.type= "text/plain"
            startActivity(Intent.createChooser(intent, "Share on:"))
        }
    }

}