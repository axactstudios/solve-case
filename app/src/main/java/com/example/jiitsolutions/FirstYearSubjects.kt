package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.first_year_subjects.*

class FirstYearSubjects :AppCompatActivity() {
var year:String="FirstYear"
    var subject:String="sdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_year_subjects)


        val bundle: Bundle? = intent.extras
         year = bundle!!.getString("yearid").toString()


        choose_subject_1.setOnClickListener {

            val intent = Intent(this,FileListScreen::class.java)
            intent.putExtra("subid",subject)
            intent.putExtra("yearid",year)
           // Toast.makeText(this,"You are viewing $subject",Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }

    }


    fun onRadioButtonClicked(view: View){
        if(view is RadioButton) {
            val checked= view.isChecked

            when(view.getId()){
                R.id.sdf ->
                    if(checked){
                   subject="sdf"
                    }
                R.id.physics ->
                    if(checked){
                    subject="physics"
                    }
                R.id.maths ->
                    if(checked){
                      subject="maths"
                    }
                R.id.es ->
                    if(checked){
                      subject="es"
                    }
                R.id.pvlab ->
                    if(checked){
                     subject="pvlab"
                    }
                R.id.esvlab ->
                    if(checked){
                     subject="esvlab"
                    }
                R.id.edd ->
                    if(checked){
                       subject="edd"
                    }
                R.id.workshop ->
                    if(checked){
                     subject="workshop"
                    }
            }
        }
    }
}
    public fun fetchingFiles():String {
        var str = "Kuch nai"
        val storage = Firebase.storage
        val gsReference = storage.getReferenceFromUrl("gs://solve-case123.appspot.com/FirstYear/Physics/Tutorial_1-2.pdf")
 var fileRef : StorageReference? =gsReference
        val ONE_MEGABYTE = (1024 * 1024 * 100).toLong()
        if (fileRef != null) {
            fileRef.getBytes(ONE_MEGABYTE)
                .addOnSuccessListener { bytes ->
                    str = "H gya kaam bro"
                }
                .addOnFailureListener { exception ->
                    str = "Nai hua kuch bhi"
                }
        }
        else{
            str="Incorrect url"
        }
        return str

    }
