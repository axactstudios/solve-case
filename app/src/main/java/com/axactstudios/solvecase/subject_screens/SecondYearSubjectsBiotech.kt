package com.axactstudios.solvecase.subject_screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.axactstudios.solvecase.FileListScreen2
import com.axactstudios.solvecase.R
import kotlinx.android.synthetic.main.first_year_subjects.*

class SecondYearSubjectsBiotech : AppCompatActivity() {
    var year: String = "SecondYear"
    var subject: String = "microbio"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_year_subjects_biotech)
        val bundle: Bundle? = intent.extras
        year = bundle!!.getString("yearid").toString()
        choose_subject_1.setOnClickListener {
            val intent = Intent(this, FileListScreen2::class.java)
            intent.putExtra("subid", subject)
            intent.putExtra("yearid", year)
            startActivity(intent)
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.microbio ->
                    if (checked) {
                        subject = "microbio"
                    }
                R.id.gdb ->
                    if (checked) {
                        subject = "gdb"
                    }
                R.id.bioinfo ->
                    if (checked) {
                        subject = "bioinfo"
                    }
                R.id.microbio ->
                    if (checked) {
                        subject = "microbio"
                    }
                R.id.gdblab ->
                    if (checked) {
                        subject = "gdblab"
                    }
                R.id.bioinfolab ->
                    if (checked) {
                        subject = "bioinfolab"
                    }
                R.id.ls ->
                    if (checked) {
                        subject = "ls"
                    }

            }
        }
    }
}
