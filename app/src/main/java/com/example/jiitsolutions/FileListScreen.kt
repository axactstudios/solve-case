package com.example.jiitsolutions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.multidex.MultiDex
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.file_list_screen.*
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.URL
//
//private const val REQUEST_EXTERNAL_STORAGE = 1
//
//private val PERMISSIONS_STORAGE = arrayOf(
//    Manifest.permission.READ_EXTERNAL_STORAGE,
//    Manifest.permission.WRITE_EXTERNAL_STORAGE
//)


class FileListScreen:AppCompatActivity() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.file_list_screen)
        val bundle: Bundle? = intent.extras
        val yearFolder = bundle!!.getString("yearid")
        val subjectFolder = bundle!!.getString("subid")
        val filenames = ArrayList<String>()

        val db = FirebaseFirestore.getInstance()
        val fileurls = ArrayList<String>()


        var str = ""
        db.collection("FirstYear").document(subjectFolder.toString()).collection("files")

            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    str = document.getString("fname").toString()
               //     Toast.makeText(this, str, Toast.LENGTH_LONG).show()
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
          //  Toast.makeText(this, "$fileurls[$itemIdAtPos]", Toast.LENGTH_SHORT).show()


            var storageRef = FirebaseStorage.getInstance().reference.child("file/FirstYear/$subjectFolder/").child(itemAtPos.toString())
            storageRef.downloadUrl.addOnSuccessListener { uri ->
                DownloadFileFromURL().execute(uri.toString(),itemAtPos.toString())
Toast.makeText(this,"Download started...",Toast.LENGTH_SHORT).show()
           //     Toast.makeText(this,storageRef.downloadUrl.toString(),Toast.LENGTH_LONG).show()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
            }

           // verifyStoragePermissions(FileListScreen)

        }
    }

//    fun verifyStoragePermissions(activity: Activity?) {
//        // Check if we have write permission
//        val permission = ActivityCompat.checkSelfPermission(
//            activity!!,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//        )
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                activity,
//                PERMISSIONS_STORAGE,
//                REQUEST_EXTERNAL_STORAGE
//            )
//        }
//    }

    inner class DownloadFileFromURL : AsyncTask<String?, String?, String?>() {

        override fun doInBackground(vararg p0: String?): String? {
            //file download path
            val downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

            //image download url
            val url = URL(p0[0])
            val filename=p0[1].toString()
            val conection = url.openConnection()
            conection.connect()

            // input stream to read file - with 8k buffer
            val input = BufferedInputStream(url.openStream(), 8192)

            // output stream to write file
            val output = FileOutputStream(downloadFolder + "/$filename")
            val data = ByteArray(1024)
            var total = 0L

            // writing data to file
            var count : Int
            while (input.read(data).also { count = it } != -1) {
                total += count.toLong()

                output.write(data, 0, count)
            }
            // flushing output
            output.flush()
            // closing streams
            output.close()
            input.close()

            return null
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(this@FileListScreen,"File Downloaded",Toast.LENGTH_LONG).show()
        }
    }

}


