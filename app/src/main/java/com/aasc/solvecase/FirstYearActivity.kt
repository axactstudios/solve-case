package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first_year.*

class FirstYearActivity : AppCompatActivity() {
    var check="maths"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year)


        search_videos.setOnClickListener {
if(check=="maths") {
    val intent = Intent(this, MathsActivity::class.java)
    startActivity(intent)
}
            else if(check=="es")
{
    val intent = Intent(this, ESActivity::class.java)
    startActivity(intent)
}
else if(check=="physics")
{
    val intent = Intent(this, PhysicsActivity::class.java)
    startActivity(intent)
}
else if(check=="sdf")
{
    val intent = Intent(this, SdfActivity::class.java)
    startActivity(intent)
}
else if(check=="bmaths")
{
    val intent = Intent(this, BasicMathsActivity::class.java)
    startActivity(intent)
}
else if(check=="focp")
{
    val intent = Intent(this, FundamentalsofComputer::class.java)
    startActivity(intent)
}
        }


    }
    fun onRadioButtonClicked (view: View){
        if (view is RadioButton) {
            val checked = view.isChecked

            when(view.getId()){
                R.id.rb_maths ->
                    if(checked){
                       check="maths"
                    }
                R.id.rb_es ->
                    if(checked){
                        check="es"
                    }
                R.id.rb_physics ->
                    if(checked){
                        check="physics"
                    }
                R.id.rb_sdf ->
                    if(checked){
                        check="sdf"
                    }
                R.id.rb_basicmaths ->
                    if(checked){
                        check="bmaths"
                    }
                R.id.rb_focp ->
                    if(checked){
                        check="focp"
                    }
            }
        }
    }
}
