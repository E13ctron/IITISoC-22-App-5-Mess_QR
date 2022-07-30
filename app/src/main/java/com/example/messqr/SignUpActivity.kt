package com.example.messqr

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivitySignUpBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //progress dialog
    private lateinit var progressDialog: ProgressDialog
    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    private var email=""
    private var password=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure action bar //add back button
        actionBar=supportActionBar!!
        actionBar.title="Sign up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //configure progress dialog
        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("please wait")
        progressDialog.setMessage("creating account in..")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAuth=FirebaseAuth.getInstance()

        //handle click create account button
        binding.button3.setOnClickListener {
            //validate data
            validateData()
        }
    }

    private fun validateData() {
        //get data
        email=binding.editTextTextPersonName.text.toString()
        password=binding.editTextTextPassword2.text.toString()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.editTextTextPersonName.error="invalid email format"
        }
        else if (TextUtils.isEmpty(password))
        {
            binding.editTextTextPassword2.error="please enter a password"
        }
        else if (password.length<5)
        {
            binding.editTextTextPassword2.error="password must be at least 5 characters long"
        }
        else
        {
            fireBaseSignUp()
        }
    }

    private fun fireBaseSignUp() {
        //show progress dialog
        progressDialog.show()

        //create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()
                //get current user
                val firebaseUser= firebaseAuth.currentUser
                val email=firebaseUser!!.email
                Toast.makeText(this, "created account with email as $email", Toast.LENGTH_SHORT).show()

                //open login
                startActivity(Intent(this,MainActivity3::class.java))
                finish()
            }
            .addOnFailureListener{e->
                //sign up failed
                progressDialog.dismiss()
                Toast.makeText(this, "sign up failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()//go back to previous button when back button of action bar is clicked
        return super.onSupportNavigateUp()
    }
}