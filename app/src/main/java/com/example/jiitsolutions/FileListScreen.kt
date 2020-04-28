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

//        fetchingFiles()
        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager

        val adapter=FileAdapter(this,fileList.Files)
        recyclerView.adapter=adapter
        }

        public fun fetchingFiles(){
        val ref= FirebaseDatabase.getInstance().getReference("file")

        }
}