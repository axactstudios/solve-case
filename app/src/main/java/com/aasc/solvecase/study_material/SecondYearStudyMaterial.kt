package com.aasc.solvecase.study_material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.aasc.solvecase.R

class SecondYearStudyMaterial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_year_study_material)
    }
    fun onRadioButtonClicked (view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rb_prob ->
                    if (checked) {
                        val intent = Intent(this, Probability::class.java)
                        Toast.makeText(this, "You selected Probability", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_os ->
                    if (checked) {
                        val intent = Intent(this, OperatingSystem::class.java)
                        Toast.makeText(this, "You selected Operating System", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_dsp ->
                    if (checked) {
                        val intent = Intent(this, DigitalSignalProcessing::class.java)
                        Toast.makeText(this, "You selected Digital Signal Processing", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_ds ->
                    if (checked) {
                        val intent = Intent(this, DigitalSystem::class.java)
                        Toast.makeText(this, "You selected Digital System", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_adc ->
                    if (checked) {
                        val intent = Intent(this, AnalogAndDigitalCommunication::class.java)
                        Toast.makeText(this, "You selected Analog and Digital Communication", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_dcd ->
                    if (checked) {
                        val intent = Intent(this, DigitalCircuitDesign::class.java)
                        Toast.makeText(this, "You selected Digital Circuit Design", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.rb_algo ->
                    if (checked) {
                        val intent = Intent(this, AlgorithmsAndProblemSolving::class.java)
                        Toast.makeText(this, "You selected Algorithms and Problem Solving", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
            }
        }
    }
}
