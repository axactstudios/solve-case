package com.example.jiitsolutions

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.file_list_screen.*

class FileListScreen:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
Toast.makeText(this,"Trial",Toast.LENGTH_LONG).show()
        setContentView(R.layout.file_list_screen)
        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager

        val adapter=FileAdapter(this,fileList.Files)
        recyclerView.adapter=adapter
        }


        }
