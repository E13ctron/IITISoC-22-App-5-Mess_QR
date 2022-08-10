package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivityProfileScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class ProfileScreen : AppCompatActivity() {

    companion object{
        private const val TAG = "update_profile"
        private const val name="name"
        private const val age="age"
        private const val department="department"
        private const val mobile_no="mobile_no"

    }

    //view binding
    private lateinit var binding: ActivityProfileScreenBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure action bar
        actionBar=supportActionBar!!
        actionBar.title="Profile"

        //init firebase auth
        firebaseAuth=FirebaseAuth.getInstance()
        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email
        checkUser()
        //document referencing
        val mdocref: DocumentReference = FirebaseFirestore.getInstance().document("profile/${email}")

        //fetching data
        fetchData(mdocref)

        //handle click logout
        binding.logOutButton.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        //handle edit button
        val editButton:Button=findViewById(R.id.edit_button)
        editButton.setOnClickListener{
            Intent(this,update_profile::class.java).also{
                startActivity(it)
            }
        }

        //handle click announcement Image button
        val announceImageButtonButton: ImageButton =  findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this,MainActivity9::class.java).also{
                startActivity(it)
            }
        }

        //handle click scanner Image button
        val scanImageButton: ImageButton =  findViewById(R.id.scan_Ibutton)
        scanImageButton.setOnClickListener {
            Intent(this,MainActivity4::class.java).also{
                startActivity(it)
            }
        }

        //handle click history Image button
        val historyImageButton: ImageButton =  findViewById(R.id.history_Ibutton)
        historyImageButton.setOnClickListener {
            Intent(this,MainActivity10::class.java).also{
                startActivity(it)
            }
        }

        //handle click payment Image button
        val paymentImageButton:ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,MainActivity5::class.java).also{
                startActivity(it)
            }
        }

    }

    private fun fetchData(mdocref: DocumentReference) {
        val usernameView:TextView=findViewById(R.id.username)
        val ageView:TextView=findViewById(R.id.age_text)
        val departmentView:TextView=findViewById(R.id.department_text)
        val mobileView:TextView=findViewById(R.id.mobile_no_text)

        mdocref.get().addOnSuccessListener {
            if (it.exists())
            {
                val nameText:String?=it.getString(name)
                val ageText:String?=it.getString(age)
                val departmentText:String?=it.getString(department)
                val mobileText:String?=it.getString(mobile_no)

                usernameView.text= nameText
                ageView.text=ageText
                departmentView.text=departmentText
                mobileView.text=mobileText
            }
        }
            .addOnFailureListener { e->
                Log.e(TAG, e.toString() )
            }


    }

    private fun checkUser() {
        //check whether user is logged in or not
        val firebaseUser=firebaseAuth.currentUser
        if (firebaseUser!=null)
        {
            //user not null logged in get user info
            val email=firebaseUser.email
            //set to text view
            binding.emailText.text=email
        }
        else
        {
            //user is null user not logged in go to login window
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }
}