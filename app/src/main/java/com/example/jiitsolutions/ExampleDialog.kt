package com.example.jiitsolutions

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment

class ExampleDialog : AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        if (builder != null) {
            builder.setTitle("Title")
        }

        if (builder != null) {
            builder.setMessage("dialogMessage")
        }
        builder!!.setPositiveButton("Contact page"){dialogInterface, which ->
            val intent = Intent(context, ContactPage::class.java)
            startActivity(intent)


        }
        builder.setNeutralButton("Cancel"){dialogInterface , which ->
            Toast.makeText(context,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
        }
        return builder.create()
        //aa





    }
}

