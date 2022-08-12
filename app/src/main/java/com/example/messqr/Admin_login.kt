package com.example.messqr

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivityAdminLoginBinding
//import com.example.messqr.databinding.ActivityMain3Binding
import com.google.firebase.auth.FirebaseAuth

class Admin_login : AppCompatActivity() {
    //viewBinding
    private lateinit var binding: ActivityAdminLoginBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //progress bar
    private lateinit var progressDialog: ProgressDialog
    //firebase auth
    private lateinit var firebaseAdmin: FirebaseAuth

    private var email=""
    private var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAdminLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure action bar
        actionBar=supportActionBar!!
        actionBar.title="login"

        //configure progress dialog box
        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("please wait")
        progressDialog.setMessage("logging in")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAdmin= FirebaseAuth.getInstance()

        //handle click login
        binding.button3.setOnClickListener {
            //validate data
            validateData()
        }
    }

    private fun validateData() {
        //get data
        email = binding.editTextUserName.text.toString()
        password = binding.editTextPassword.text.toString()

        ////validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //invalid email format
            binding.editTextUserName.error = "invalid email format"
        } else if (TextUtils.isEmpty(password)) {
            //empty password
            binding.editTextPassword.error = "please enter a password"
        } else {
            //valid data start login
            fireBaseLogin()
        }
    }
    private fun fireBaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAdmin.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //login successful
                progressDialog.dismiss()
                //get user info
                val firebaseUser=firebaseAdmin.currentUser
                val email=firebaseUser!!.email
                Toast.makeText(this, "Logged in as ${email}", Toast.LENGTH_SHORT).show()

                //open profile activity
                startActivity(Intent(this, QR_code_generator2::class.java))
                finish()
            }
            .addOnFailureListener{e->
                //login failed
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()

            }
    }
}