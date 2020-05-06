package com.example.jiitsolutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class VideoLecturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_lectures)
    }

    fun onRadioButtonClicked (view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rb_fy ->
                    if (checked) {
                        val intent = Intent(this, FirstYearActivity::class.java)
                        Toast.makeText(this, "You selected First Year", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_sy ->
                    if (checked) {
                        val intent = Intent(this, SecondYearActivity::class.java)
                        Toast.makeText(this, "You selected Second Year", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
            }
        }
    }
}
