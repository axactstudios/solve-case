package com.aasc.solvecase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_phone.*
import java.util.concurrent.TimeUnit

class PhoneActivity : AppCompatActivity() {

    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var mAuth : FirebaseAuth
    var verificationId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        mAuth = FirebaseAuth.getInstance()

        btn_sendcode.setOnClickListener {
                view : View -> verify()
        }

        btn_verify.setOnClickListener {
                view : View -> authenticate()
        }
    }

    private fun authenticate() {
        val verNo = et_code.text.toString()
        val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(verificationId,verNo)
        signIn(credential)
    }

    private fun verificationCallbacks() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                signIn(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                startActivity(Intent(this@PhoneActivity,PhoneActivity::class.java))
            }

            override fun onCodeSent(verification: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(verification, p1)
                verificationId = verification.toString()
            }
        }
    }

    private fun signIn(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener {
                    task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Logged in", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,OptionsScreen::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun verify() {

        verificationCallbacks()

        val phnNo = et_phone.text.toString()

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phnNo,
            60,
            TimeUnit.SECONDS,
            this,
            mCallbacks
        )

    }

}
