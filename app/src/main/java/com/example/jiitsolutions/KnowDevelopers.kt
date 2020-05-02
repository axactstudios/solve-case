package com.example.jiitsolutions

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_know_developers.*

class KnowDevelopers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_developers)
        btn_aviral.setOnClickListener {
            val intent = Intent()
            intent.action= Intent.ACTION_VIEW

            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+917060222315"))
            startActivity(intent)
        }
        btn_shubh.setOnClickListener {
            val intent = Intent()
            intent.action= Intent.ACTION_VIEW

            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+919027553376"))
            startActivity(intent)
        }
        btn_chitransh.setOnClickListener {
            val intent = Intent()
            intent.action= Intent.ACTION_VIEW

            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+918171907780"))
            startActivity(intent)
        }
        btn_akash.setOnClickListener {
            val intent = Intent()
            intent.action= Intent.ACTION_VIEW

            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+917895833794"))
            startActivity(intent)
        }
    }
}
