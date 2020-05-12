package com.axactstudios.solvecase

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.multidex.MultiDex
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.file_list_screen.*

class FileListScreen2 : AppCompatActivity() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_list_screen2)


        val bundle: Bundle? = intent.extras
        val yearFolder = bundle!!.getString("yearid")
        val subjectFolder = bundle.getString("subid")
        val filenames = ArrayList<String>()

        val db = FirebaseFirestore.getInstance()
        val fileurls = ArrayList<String>()


        var str = ""
        db.collection("SecondYear").document(subjectFolder.toString()).collection("files")

            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    str = document.getString("fname").toString()
                    fileurls.add(document.getString("furl").toString())
                    filenames.add(str)
                }
                val myListAdapter = MyListAdapter(this, filenames)
                listView.adapter = myListAdapter

            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Tumse na ho pai", Toast.LENGTH_LONG).show()
            }



        listView.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            var storageRef = FirebaseStorage.getInstance().reference.child("file/SecondYear/$subjectFolder/").child(itemAtPos.toString())
            storageRef.downloadUrl.addOnSuccessListener { uri ->
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()))
                startActivity(i)
                Toast.makeText(this,"Download started...", Toast.LENGTH_SHORT).show()

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    0)
            }

        }
    }
}
