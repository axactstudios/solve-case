package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_year_subjects.*
import kotlinx.android.synthetic.main.second_year_subjects.*

class SecondYearSubjects :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_year_subjects)

        val bundle: Bundle? = intent.extras
        val year = bundle!!.getString("yearid")

        Toast.makeText(this,year,Toast.LENGTH_SHORT).show()

      }

    fun onRadioButtonClicked(view: View){
        if(view is RadioButton){
            val checked = view.isChecked

            when(view.getId()){
                R.id.ds ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","ds")
                        Toast.makeText(this,"You have selected Digital Systems",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.coa ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","coa")
                        Toast.makeText(this,"You have selected COA",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.es ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","es")
                        Toast.makeText(this,"You have selected Environmental Science",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.prp ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","prp")
                        Toast.makeText(this,"You have selected PRP",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.coaLab ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","coaLab")
                        Toast.makeText(this,"You have selected COA Lab",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.ls ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","ls")
                        Toast.makeText(this,"You have selected Life Skills",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
            }
        }
    }
}