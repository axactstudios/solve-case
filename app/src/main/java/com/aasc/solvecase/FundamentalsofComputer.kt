package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FundamentalsofComputer : AppCompatActivity(), onVideoItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fundamentalsof_computer)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        var video = ArrayList<videoDetailsModel>()


        video.add(videoDetailsModel("Introduction to C Language - Part-1","si-KFFOW2gw"))
        video.add(videoDetailsModel("Introduction to C Language - Part 2","sB7YGSbAIvQ"))
        video.add(videoDetailsModel("Variables in C","rFnWoTnoC50"))
        video.add(videoDetailsModel("Functions in C","TxWKGhF9KdM"))
        video.add(videoDetailsModel("Data Types in C - Part 1","j1u3V6pzwEI"))
        video.add(videoDetailsModel("Data Types in C - Part 2","WnCjYZ5ANgg"))
        video.add(videoDetailsModel("Data Types - Part 3","gxbzpHYZNZU"))
        video.add(videoDetailsModel("Data Types - Part 4","OkD5xX-aW9o"))
        video.add(videoDetailsModel("Control Statements in C - If Block","ou2ZYkol4NI"))
        video.add(videoDetailsModel("Nested if block in C","rbVzQk6wu90"))
        video.add(videoDetailsModel("Control Statements in C - while loop","_2weEBxDTo8"))
        video.add(videoDetailsModel("Control Statements in C - Nested While","dUvjIbwr6ZA"))
        video.add(videoDetailsModel("Control Statements in C - for loop","_NZZ9Y-j_mw"))
        video.add(videoDetailsModel("Fibonacci Series Program in C","XH104T-Zeo0"))
        video.add(videoDetailsModel("Recursion in C Functions","SUfe1UX1m4M"))
        video.add(videoDetailsModel("C Array - Part 1","SPuS9UJF1lo"))
        video.add(videoDetailsModel("C Array - Part 2","e22OJ6YkTRY"))
        video.add(videoDetailsModel("C Array - Part 3","tCYlG065CxM"))
        video.add(videoDetailsModel("Strings in C","Zs6eQaqMsgk"))
        video.add(videoDetailsModel("Strings in C Programming | Part-1 ","AW3m7kdWvI8"))
        video.add(videoDetailsModel("Strings - Part 2","9633Qh2E9H8"))
        video.add(videoDetailsModel("Structures in C","Ranc3VvjI88"))
        video.add(videoDetailsModel("Array of Structures in C Part 1","3LQTxwKZAOY"))
        video.add(videoDetailsModel("Array of Structures in C Part 2","rhC523vMSXQ"))

        var adapter = recyclerViewAdapter(video,clickListener = this)

        recyclerView.setAdapter(adapter)
    }

    override fun onItemClick(item: videoDetailsModel, position: Int) {
        //Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        val intent = Intent(this,YouTubePlayerActivity::class.java)
        intent.putExtra("videoname",item.title)
        intent.putExtra("videokey",item.videokey)
        startActivity(intent)
    }

}

