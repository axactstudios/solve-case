package com.example.jiitsolutions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.file_list_screen.*

class FileListScreen:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.file_list_screen)


        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager

        val adapter=FileAdapter(this,fileList.Files)
        recyclerView.adapter=adapter
        }

        public fun fetchingFiles(){
// Create a storage reference from our app
            var storageRef = storage.reference
            val storage = Firebase.storage
            val listRef = storage.reference.child("gs://solve-case123.appspot.com/FirstYear/Physics")

            listRef.listAll()
                .addOnSuccessListener { listResult ->
                    listResult.prefixes.forEach { prefix ->
                    prefix.
                    }

                    listResult.items.forEach { item ->
                        // All the items under listRef.
                    }
                }
                .addOnFailureListener {
                    // Uh-oh, an error occurred!
                }


        }
}