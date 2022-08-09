package com.example.messqr

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {

    companion object
    {
        private const val TAG = "SignUpActivity"
    }
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
        binding.createButton.setOnClickListener {
            //validate data
            validateData()
        }
    }

    private fun validateData() {
        //get data
        email=binding.editTextUserName.text.toString()
        password=binding.editTextPassword.text.toString()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.editTextUserName.error="invalid email format"
        }
        else if (TextUtils.isEmpty(password))
        {
            binding.editTextPassword.error="please enter a password"
        }
        else if (password.length<5)
        {
            binding.editTextPassword.error="password must be at least 5 characters long"
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
                val mdocref: DocumentReference = FirebaseFirestore.getInstance().document("History/${email}")

                Toast.makeText(this, "created account with email as $email", Toast.LENGTH_SHORT).show()
                initializeData(mdocref)
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

    private fun initializeData(mdocref: DocumentReference) {
        val dataToSave= hashMapOf<String, String>()
        dataToSave["B1"]="0"
        dataToSave["B2"]="0"
        dataToSave["B3"]="0"
        dataToSave["B4"]="0"
        dataToSave["B5"]="0"
        dataToSave["B6"]="0"
        dataToSave["B7"]="0"
        dataToSave["B8"]="0"
        dataToSave["B9"]="0"
        dataToSave["B10"]="0"
        dataToSave["B11"]="0"
        dataToSave["B12"]="0"
        dataToSave["B13"]="0"
        dataToSave["B14"]="0"
        dataToSave["B15"]="0"
        dataToSave["B16"]="0"
        dataToSave["B17"]="0"
        dataToSave["B18"]="0"
        dataToSave["B19"]="0"
        dataToSave["B20"]="0"
        dataToSave["B21"]="0"
        dataToSave["B22"]="0"
        dataToSave["B23"]="0"
        dataToSave["B24"]="0"
        dataToSave["B25"]="0"
        dataToSave["B26"]="0"
        dataToSave["B27"]="0"
        dataToSave["B28"]="0"
        dataToSave["B29"]="0"
        dataToSave["B30"]="0"
        dataToSave["B31"]="0"

        dataToSave["L1"]="0"
        dataToSave["L2"]="0"
        dataToSave["L3"]="0"
        dataToSave["L4"]="0"
        dataToSave["L5"]="0"
        dataToSave["L6"]="0"
        dataToSave["L7"]="0"
        dataToSave["L8"]="0"
        dataToSave["L9"]="0"
        dataToSave["L10"]="0"
        dataToSave["L11"]="0"
        dataToSave["L12"]="0"
        dataToSave["L13"]="0"
        dataToSave["L14"]="0"
        dataToSave["L15"]="0"
        dataToSave["L16"]="0"
        dataToSave["L17"]="0"
        dataToSave["L18"]="0"
        dataToSave["L19"]="0"
        dataToSave["L20"]="0"
        dataToSave["L21"]="0"
        dataToSave["L22"]="0"
        dataToSave["L23"]="0"
        dataToSave["L24"]="0"
        dataToSave["L25"]="0"
        dataToSave["L26"]="0"
        dataToSave["L27"]="0"
        dataToSave["L28"]="0"
        dataToSave["L29"]="0"
        dataToSave["L30"]="0"
        dataToSave["L31"]="0"

        dataToSave["D1"]="0"
        dataToSave["D2"]="0"
        dataToSave["D3"]="0"
        dataToSave["D4"]="0"
        dataToSave["D5"]="0"
        dataToSave["D6"]="0"
        dataToSave["D7"]="0"
        dataToSave["D8"]="0"
        dataToSave["D9"]="0"
        dataToSave["D10"]="0"
        dataToSave["D11"]="0"
        dataToSave["D12"]="0"
        dataToSave["D13"]="0"
        dataToSave["D14"]="0"
        dataToSave["D15"]="0"
        dataToSave["D16"]="0"
        dataToSave["D17"]="0"
        dataToSave["D18"]="0"
        dataToSave["D19"]="0"
        dataToSave["D20"]="0"
        dataToSave["D21"]="0"
        dataToSave["D22"]="0"
        dataToSave["D23"]="0"
        dataToSave["D24"]="0"
        dataToSave["D25"]="0"
        dataToSave["D26"]="0"
        dataToSave["D27"]="0"
        dataToSave["D28"]="0"
        dataToSave["D29"]="0"
        dataToSave["D30"]="0"
        dataToSave["D31"]="0"

       mdocref.set(dataToSave).addOnSuccessListener {
           Log.d(TAG, "initializeData: data initialized")
       }
           .addOnFailureListener {e->
               Log.e(TAG, e.toString() )

           }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()//go back to previous button when back button of action bar is clicked
        return super.onSupportNavigateUp()
    }
}