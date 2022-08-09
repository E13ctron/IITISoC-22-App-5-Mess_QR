package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivityProfileScreenBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileScreen : AppCompatActivity() {

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
        checkUser()

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