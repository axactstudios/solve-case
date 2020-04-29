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
                    sleep(5000)

                    val intent= Intent(baseContext,SecondActivity   ::class.java)
                    startActivity(intent)
                } catch(e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
                val anim = AnimationUtils.loadAnimation(this,R.anim.anim)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2)
        logo.startAnimation(anim)
        textView3.startAnimation(anim2)
        textView2.startAnimation(anim2)







    }
}
