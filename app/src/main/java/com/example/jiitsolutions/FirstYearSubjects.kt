package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.first_year_subjects.*

class FirstYearSubjects :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_year_subjects)
        var result = ""

        val bundle: Bundle? = intent.extras
        val year = bundle!!.getString("yearid")
        Toast.makeText(this,year,Toast.LENGTH_SHORT).show()

        result = fetchingFiles()
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()

        choose_subject_1.setOnClickListener {
            val intent = Intent(this, FileListScreen::class.java)
            startActivity(intent)
        }
    }

    fun onRadioButtonClicked(view: View){
        if(view is RadioButton) {
            val checked= view.isChecked

            when(view.getId()){
                R.id.sdf ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","sdf")
                        Toast.makeText(this,"You are viewing SDF",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.physics ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","physics")
                        Toast.makeText(this,"You are viewing Physics",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.maths ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","maths")
                        Toast.makeText(this,"You are viewing Maths",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.es ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","es")
                        Toast.makeText(this,"You are viewing Electrical Science",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.sdflab ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","sdflab")
                        Toast.makeText(this,"You are viewing SDF Lab",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.pvlab ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","pvlab")
                        Toast.makeText(this,"You are viewing Physics VLab",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.esvlab ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","esvlab")
                        Toast.makeText(this,"You are viewing ES VLab",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.edd ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","edd")
                        Toast.makeText(this,"You are viewing EDD",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                R.id.workshop ->
                    if(checked){
                        val intent = Intent(this,FileListScreen::class.java)
                        intent.putExtra("subid","workshop")
                        Toast.makeText(this,"You are viewing Workshop",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
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
