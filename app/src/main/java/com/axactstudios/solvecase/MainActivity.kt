package com.axactstudios.solvecase

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val background = object : Thread(){
            override fun run() {
                try{
                    sleep(2000)

                    val intent= Intent(baseContext,OptionsScreen::class.java)
                    startActivity(intent)
                    finish()
                } catch(e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
                val anim = AnimationUtils.loadAnimation(this,R.anim.top)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.bottom)
        logo1.startAnimation(anim)

       // developer.startAnimation(anim2)








    }
}
