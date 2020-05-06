package com.example.jiitsolutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class FirstYearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year)
    }
    fun onRadioButtonClicked (view: View){
        if (view is RadioButton) {
            val checked = view.isChecked

            when(view.getId()){
                R.id.rb_maths ->
                    if(checked){
                        val intent = Intent(this, MathsActivity::class.java)
                        Toast.makeText(this,"You are viewing Maths", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_es ->
                    if(checked){
                        val intent = Intent(this, ESActivity::class.java)
                        Toast.makeText(this,"You are viewing Electrical Science", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_physics ->
                    if(checked){
                        val intent = Intent(this, PhysicsActivity::class.java)
                        Toast.makeText(this,"You are viewing Physics", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_sdf ->
                    if(checked){
                        val intent = Intent(this, SdfActivity::class.java)
                        Toast.makeText(this,"You are viewing Software Development Fundamentals",
                            Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_basicmaths ->
                    if(checked){
                        val intent = Intent(this, BasicMathsActivity::class.java)
                        Toast.makeText(this,"You are viewing Basic Maths", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_focp ->
                    if(checked){
                        val intent = Intent(this, FundamentalsofComputer::class.java)
                        Toast.makeText(this,"You are viewing Fundamentals of Computer & Programming",
                            Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
            }
        }
    }
}
