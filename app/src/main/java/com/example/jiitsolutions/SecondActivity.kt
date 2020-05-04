package com.example.jiitsolutions

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*
import java.util.jar.Manifest

private val PERMISSION_REQUEST=10

class SecondActivity : AppCompatActivity() {
    var yearCode="1"

    private var permissions= arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)
//choose_subject.setBackgroundColor(Color.rgb(137,205,171))
        context=this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if(checkPermission(context,permissions))
        {
            Toast.makeText(this,"Permissions are already provided",Toast.LENGTH_LONG).show()
        }
        else{

                requestPermissions(permissions, PERMISSION_REQUEST)

            }
        }
        else{
            Toast.makeText(this,"Permissions are already provided",Toast.LENGTH_LONG).show()

        }
        knw_btn.setOnClickListener {
            val intent = Intent(this, KnowDevelopers::class.java)
            startActivity(intent)
        }
        btn_contact.setOnClickListener {
            val intent = Intent(this, ContactPage::class.java)
            startActivity(intent)
        }
        choose_subject.setOnClickListener {
            if(yearCode=="1") {
                val intent = Intent(this, FirstYearSubjects::class.java)
                intent.putExtra("yearcode", "FirstYear")
             //   Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else{
                val intent = Intent(this, SecondYearSubjects::class.java)
                intent.putExtra("yearcode", "SecondYear")
                Toast.makeText(this, "You have selected $yearCode year", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.firstYear ->
                    if (checked) {
                        yearCode="1"
                    }
                R.id.secondYear ->
                    if (checked) {
                        yearCode="2"
                    }
            }
        }

    }

    fun checkPermission(context: Context,permissioArray: Array<String>):Boolean{
var allSuccess=true
        for(i in permissioArray.indices){
            if(checkCallingOrSelfPermission(permissioArray[i])==PackageManager.PERMISSION_DENIED){
                allSuccess=false
            }
        }
return allSuccess
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== PERMISSION_REQUEST){
            var allSuccess=true
            for (i in permissions.indices){
                if(grantResults[i]==PackageManager.PERMISSION_DENIED){
                    allSuccess=false
                    var requestAgain=Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if(requestAgain)
                    {
                        Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(this,"Go to settings to enable permission",Toast.LENGTH_LONG).show()

                    }
                }
            }
            if (allSuccess){
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show()

            }
        }
    }
}