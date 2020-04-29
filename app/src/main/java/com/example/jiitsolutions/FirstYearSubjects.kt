package com.example.jiitsolutions

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
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

        result = fetchingFiles()
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()

        choose_subject_1.setOnClickListener {
            val intent = Intent(this, FileListScreen::class.java)
            startActivity(intent)
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
