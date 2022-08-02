package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Admin_Announcement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_announcement)



        val mc: TextView =findViewById(R.id.textView37)
        mc.setOnClickListener {
            Intent(this,mc_announce::class.java).also{
                startActivity(it)
            }
        }
        val gm: TextView =findViewById(R.id.textView40)
        gm.setOnClickListener {
            Intent(this,gm_announce::class.java).also{
                startActivity(it)
            }
        }
        val sm: TextView =findViewById(R.id.textView34)
        sm.setOnClickListener {
            Intent(this,sm_announce::class.java).also{
                startActivity(it)
            }
        }
    }
}