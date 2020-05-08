package com.aasc.solvecase.subject_screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.aasc.solvecase.FileListScreen2
import com.aasc.solvecase.R
import kotlinx.android.synthetic.main.first_year_subjects.*

class SecondYearSubjectsECE : AppCompatActivity() {
    var year: String = "SecondYear"
    var subject: String = "dcd"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_year_subjects_ece)

        val bundle: Bundle? = intent.extras
        year = bundle!!.getString("yearid").toString()


        choose_subject_1.setOnClickListener {

            val intent = Intent(this, FileListScreen2::class.java)
            intent.putExtra("subid", subject)
            intent.putExtra("yearid", year)
            // Toast.makeText(this,"You are viewing $subject",Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
    }
        fun onRadioButtonClicked(view: View) {
            if (view is RadioButton) {
                val checked = view.isChecked

                when (view.getId()) {
                    R.id.dcd ->
                        if (checked) {
                            subject = "dcd"
                        }
                    R.id.adc ->
                        if (checked) {
                            subject = "adc"
                        }
                    R.id.dsp ->
                        if (checked) {
                            subject = "dsp"
                        }
                    R.id.dcdlab ->
                        if (checked) {
                            subject = "dcdlab"
                        }
                    R.id.adclab ->
                        if (checked) {
                            subject = "adclab"
                        }
                    R.id.dsplab ->
                        if (checked) {
                            subject = "dsplab"
                        }
                    R.id.ls ->
                        if (checked) {
                            subject = "ls"
                        }

                }
            }
        }
    }

