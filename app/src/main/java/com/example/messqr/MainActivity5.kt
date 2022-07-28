package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        //restrict the screenshot on this specific page
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
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
    }
}