package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.firstYear ->
                    if (checked) {
                        val intent = Intent(this, FirstYearSubjects::class.java)
                        intent.putExtra("yearid", "firstYear")
                        Toast.makeText(this, "You have selected first year", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.secondYear ->
                    if (checked) {
                        val intent = Intent(this, SecondYearSubjects::class.java)
                        intent.putExtra("yearid", "secondYear")
                        Toast.makeText(this, "You have selected second year", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                }
            }

    }
}
