package com.example.jiitsolutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        val btnSignUp: Button? = findViewById<Button>(R.id.btn_sign_up)
        btnSignUp!!.setOnClickListener {
            Log.i("MainActivity", "Hello was clicked!")
            startActivity(Intent(this,SignupActivity::class.java))
            finish()

        }
        btn_log_in.setOnClickListener {
            doLogin()
            Log.i("MainActivity", "Button was clicked!")
        }

    }
    private fun doLogin() {
        if (tv_username.text.toString().isEmpty()) {
            tv_username.error = "Please enter email"
            tv_username.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(tv_username.text.toString()).matches()) {
            tv_username.error = "Please enter valid email"
            tv_username.requestFocus()
            return
        }

        if (tv_password.text.toString().isEmpty()) {
            tv_password.error = "Please enter password"
            tv_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(tv_username.text.toString(), tv_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                }
            }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    private fun updateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {

                startActivity(Intent(this, SecondActivity::class.java))
                finish()
        }


         else {
            Toast.makeText(
                baseContext, "Login failed. Please log in again.",
                Toast.LENGTH_SHORT
            ).show()
            Log.i("MainActivity", "Button was clicked!")
        }
    }


}

