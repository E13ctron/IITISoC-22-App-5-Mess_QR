package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Announcement_Section : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement_section)

        //handle click scanner Image button
        val scanImageButton: ImageButton =  findViewById(R.id.scan_Ibutton)
        scanImageButton.setOnClickListener {
            Intent(this,Main_QR_Scanning::class.java).also{
                startActivity(it)
            }
        }

        //handle click payment Image button
        val paymentImageButton: ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,Payment_Section::class.java).also{
                startActivity(it)
            }
        }

        //handle click history Image button
        val historyImageButton: ImageButton =  findViewById(R.id.history_Ibutton)
        historyImageButton.setOnClickListener {
            Intent(this,History_Table::class.java).also{
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
        val sm: TextView =findViewById(R.id.special_meal_back)
        sm.setOnClickListener {
            Intent(this,details_of_sm::class.java).also{
                startActivity(it)
            }
        }
        val mc: TextView =findViewById(R.id.menu_change_back)
        mc.setOnClickListener {
            Intent(this,details_of_mc::class.java).also{
                startActivity(it)
            }
        }
        val gm: TextView =findViewById(R.id.general_mail_back)
        gm.setOnClickListener {
            Intent(this,details_of_gm::class.java).also{
                startActivity(it)
            }
        }
    }


}