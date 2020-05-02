package com.example.jiitsolutions

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.file_list_screen.*

class FileListScreen:AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.file_list_screen)
            val bundle: Bundle? = intent.extras
            val yearFolder = bundle!!.getString("yearid")
            val subjectFolder=bundle!!.getString("subid")
            val filenames=ArrayList<String>()
            // var filenames: MutableList<String> = mutableListOf<String>()

            var str="Default"

            val ref= FirebaseDatabase.getInstance().getReference("/files/FirstYear/workshop")
            ref.addListenerForSingleValueEvent(object :ValueEventListener{
                    override fun onCancelled(p0: DatabaseError) {
                            Toast.makeText(this@FileListScreen,"Kuch ni hua bro",Toast.LENGTH_LONG).show()

                    }

                    override fun onDataChange(p0: DataSnapshot) {
                    if(p0!!.exists()){

                            for (f in p0.children)
                            {
                                    val file=f.getValue(File::class.java)
                                   // var fileNameToAddToList=file!!.fname
                                    //filenames.add(fileNameToAddToList)
                                    //Log.d("YearList",file.fname)
                                    if (file != null) {
                                            str=file.fname
                                    }
                                    else{
                                            str="Bakaiti"
                                    }
                                    Toast.makeText(this@FileListScreen,file!!.fname,Toast.LENGTH_LONG).show()
                            }
                    }

                    }
            })

            filenames.add("hbcsyuc")
            filenames.add(str)
            filenames.add("hbcsyuc")
            filenames.add("hbcsyuc")
            filenames.add("hbcsyuc")
            filenames.add("hbcsyuc")

            val myListAdapter = MyListAdapter(this,filenames)
            listView.adapter = myListAdapter

            listView.setOnItemClickListener(){adapterView, view, position, id ->
                    val itemAtPos = adapterView.getItemAtPosition(position)
                    val itemIdAtPos = adapterView.getItemIdAtPosition(position)
                    Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
            }




    }

        }
class File()
{
        val fname="null"
        val fileURL="null"
}
