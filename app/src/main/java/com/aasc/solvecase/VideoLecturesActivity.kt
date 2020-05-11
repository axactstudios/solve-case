package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_video_lectures.*

class VideoLecturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_lectures)


            firstYearVideos.setOnClickListener {
                val intent = Intent(this, FirstYearActivity::class.java)
                startActivity(intent)
            }

            firstYearVideos2.setOnClickListener {
                val intent = Intent(this, FirstYearActivity::class.java)
                startActivity(intent)
            }
            firstYearVideos3.setOnClickListener {
                val intent = Intent(this, FirstYearActivity::class.java)
                startActivity(intent)
            }
            secondYearVideos.setOnClickListener {
//                val intent = Intent(this, SecondYearActivity::class.java)
//                startActivity(intent)
                Toast.makeText(this,"Playlist will be released soon",Toast.LENGTH_SHORT).show()
            }
            secondYearVideos2.setOnClickListener {
//                val intent = Intent(this, SecondYearActivity::class.java)
//                startActivity(intent)
                Toast.makeText(this,"Playlist will be released soon",Toast.LENGTH_SHORT).show()

            }
            secondYearVideos3.setOnClickListener {
//                 val intent = Intent(this, SecondYearActivity::class.java)
//                 startActivity(intent)
                Toast.makeText(this,"Playlist will be released soon",Toast.LENGTH_SHORT).show()

            }


        }

}
