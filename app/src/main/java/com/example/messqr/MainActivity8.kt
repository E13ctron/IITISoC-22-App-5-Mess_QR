package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8main)

        //handle click announcement Image button
        val announceImageButtonButton: ImageButton =  findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this,MainActivity9::class.java).also{
                startActivity(it)
            }
        }

        //handle click payment Image button
        val paymentImageButton: ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,MainActivity5::class.java).also{
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

        //handle click profile button
        val profileImageButton: ImageButton=findViewById(R.id.profile_Ibutton)
        profileImageButton.setOnClickListener {
            Intent(this, ProfileScreen::class.java).also {
                startActivity(it)
            }
        }
    }
}