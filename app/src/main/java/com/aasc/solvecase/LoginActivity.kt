@file:Suppress("DEPRECATION")

package com.aasc.solvecase

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {

    companion object {
        private val PERMISSION_CODE = 2304;
    }

    lateinit var mGooogleApiClient : GoogleApiClient
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var alertDialog: AlertDialog

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PERMISSION_CODE)
        {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if(result!!.isSuccess)
            {
                val account = result!!.signInAccount
                val idToken = account!!.idToken
                val credential = GoogleAuthProvider.getCredential(idToken,null)
                firebaseAuthWithGoogle(credential)
            }
            else
            {
                Log.d("ERROR","Login Failed")
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(credential: AuthCredential) {
        firebaseAuth!!.signInWithCredential(credential)
            .addOnSuccessListener {authResult ->
                val logged_email = authResult.user!!.email
                val logged_activity = Intent(this@LoginActivity,SecondActivity::class.java)
                startActivity(logged_activity)
            }
            .addOnFailureListener {
                    e-> Toast.makeText(this,""+e.message,Toast.LENGTH_SHORT).show()
            }
    }

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val btnSignUp: Button? = findViewById<Button>(R.id.btn_sign_up)
        btnSignUp?.let{
            btnSignUp.setOnClickListener {
//making folder
//                val rootPath = Environment.getExternalStorageDirectory()
//                    .absolutePath + "/SolveCase"
//                val root = File(rootPath)
//                if (!root.exists()) {
//                    root.mkdirs()
//                    Toast.makeText(this,"Folder Created",Toast.LENGTH_LONG).show()
//                }
//                else{
//                    Toast.makeText(this,"Folder hi ni bana",Toast.LENGTH_LONG).show()
//
//                }
                Log.i("MainActivity", "Hello was clicked!")
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }

        }

        btn_log_in.setOnClickListener {
            //making folder

//            val rootPath = Environment.getExternalStorageDirectory()
//                .absolutePath + "/SolveCase"
//            val root = File(rootPath)
//            if (!root.exists()) {
//                root.mkdirs()
//                Toast.makeText(this,"Folder Created",Toast.LENGTH_LONG).show()
//            }
//            else{
//                Toast.makeText(this,"Folder hi ni bana",Toast.LENGTH_LONG).show()
//
//            }

            doLogin()
            Log.i("MainActivity", "Button was clicked!")
        }

        configureGoogleClient()

        firebaseAuth = FirebaseAuth.getInstance()

        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Please wait")
            .setCancelable(false)
            .build()

        btn_google_signin.setOnClickListener {
           //making folder

//            val rootPath = Environment.getExternalStorageDirectory()
//                .absolutePath + "/SolveCase"
//            val root = File(rootPath)
//            if (!root.exists()) {
//                root.mkdirs()
//                Toast.makeText(this,"Folder Created",Toast.LENGTH_LONG).show()
//            }
//            else{
//                Toast.makeText(this,"Folder hi ni bana",Toast.LENGTH_LONG).show()
//
//            }

            signIn()
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
//            val dir = File(
//                Environment.getExternalStorageDirectory().toString() + "/Download/SolveCase/"
//            )
//            dir.mkdirs() // creates needed dirs

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

    private fun signIn() {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGooogleApiClient)
        startActivityForResult(intent, LoginActivity.PERMISSION_CODE)
    }

    private fun configureGoogleClient() {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGooogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this,this)
            .addApi(Auth.GOOGLE_SIGN_IN_API,options)
            .build()
        mGooogleApiClient.connect()
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Toast.makeText(this,""+p0.errorMessage,Toast.LENGTH_SHORT).show()
    }

}

