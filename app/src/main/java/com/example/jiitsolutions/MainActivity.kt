package com.example.jiitsolutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val background = object : Thread(){
            override fun run() {
                try{
                    sleep(4000)

                    val intent= Intent(baseContext,SecondActivity   ::class.java)
                    startActivity(intent)
                } catch(e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
                val anim = AnimationUtils.loadAnimation(this,R.anim.top)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.bottom)
        logo1.startAnimation(anim)
        developer.startAnimation(anim2)








    }
}
