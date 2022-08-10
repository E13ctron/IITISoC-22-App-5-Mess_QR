package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Admin_Announcement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_announcement)

        //handle  mail buttom
        val mail_btn:ImageButton=findViewById(R.id.mail_btn)
        mail_btn.setOnClickListener {
            Intent(this, admin_access::class.java).also{
                startActivity(it)
            }

        }

        //handle qr code generator btn
        val codeGeneratorbBtn:ImageButton=findViewById(R.id.qr_generate_Ibutton)
        codeGeneratorbBtn.setOnClickListener {
            Intent(this, QR_code_generator2::class.java).also{
                startActivity(it)
            }

        }

        //meal change
        val mc: TextView =findViewById(R.id.menu_change_back)
        mc.setOnClickListener {
            Intent(this,mc_announce::class.java).also{
                startActivity(it)
            }
        }

        //general mail
        val gm: TextView =findViewById(R.id.general_mail_back)
        gm.setOnClickListener {
            Intent(this,gm_announce::class.java).also{
                startActivity(it)
            }
        }

        //special meal
        val sm: TextView =findViewById(R.id.special_meal_back)
        sm.setOnClickListener {
            Intent(this,sm_announce::class.java).also{
                startActivity(it)
            }
        }
    }
}