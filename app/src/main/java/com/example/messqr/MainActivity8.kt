package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8main)
        val currentTime: Date = Calendar.getInstance().time
        var hours: Int = currentTime.hours
        var scanResult: TextView = findViewById(R.id.scan_result)
        var tick: ImageView = findViewById(R.id.tick_icon)
        var stopWatch: Chronometer = findViewById(R.id.stopwatch)
        if(scanid!=""){
            tick.setImageResource(R.drawable.ic_green_circle_200)
            scanResult.text = "The QR Code was Scanned Successfully : "
            scanResult.textSize = resources.getDimension(R.dimen.font_10)
            stopWatch.start()
        }
        else {
            tick.setImageResource(R.drawable.ic_qrcode_default_200)
            scanResult.text = "Please Scan"
        }

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
        val qrScannerSM: Button =findViewById(R.id.scan_button)

        if ( hours in 18..22) {
            qrScannerSM.setOnClickListener {
                Intent(this, QR_Scanner::class.java).also {
                    startActivity(it)
                }
            }
        } else {
            qrScannerSM.setOnClickListener {
                tick.setImageResource(R.drawable.ic_qrcode_default_200)
                scanResult.text = "Scan the QR"
                Toast.makeText(this, "Please scan at the correct meal timing", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}