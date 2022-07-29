package com.example.messqr

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity4 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //restrict the screenshot on this specific page
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }

        val currentTime: Date = Calendar.getInstance().time
        var hours: Int= currentTime.hours
        var scanResult:TextView=findViewById(R.id.scan_result)
        var tick:ImageView=findViewById(R.id.tick_icon)
        var stopWatch:Chronometer=findViewById(R.id.stopwatch)

        if(scanid!=""){
            tick.setImageResource(R.drawable.ic_green_circle_200)
            scanResult.text="The QR Code was Scanned Successfully : "
            scanResult.textSize=resources.getDimension(R.dimen.font_10)
            stopWatch.start()

        }
        else {
            tick.setImageResource(R.drawable.ic_qrcode_default_200)
            scanResult.text="Please Scan"
        }

        //handle click special meal button
        val button4:Button=findViewById(R.id.button4)
        button4.setOnClickListener {
            Intent(this,MainActivity8::class.java).also{
                startActivity(it)
            }
        }


        //handle click announcement Image button
        val announceImageButtonButton:ImageButton =  findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this,MainActivity9::class.java).also{
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

        //handle click history Image button
        val historyImageButton:ImageButton =  findViewById(R.id.history_Ibutton)
        historyImageButton.setOnClickListener {
            Intent(this,MainActivity10::class.java).also{
                startActivity(it)
            }
        }

        //handle click special meal button
        val button6: Button = findViewById(R.id.button6)
        if(hours in 8..10 || hours in 12..14 || hours in 20..22 ) {
            button6.setOnClickListener {
                Intent(this, QR_Scanner::class.java).also {
                    startActivity(it)
                }
            }
        }
        else{
            button6.setOnClickListener {
                Toast.makeText(this, "Please scan at the correct meal timing", Toast.LENGTH_SHORT).show()
            }
        }
        //this is only for reference that how it will work
//        val button6:Button=findViewById(R.id.button6)
//        button6.setOnClickListener {
//            val intent2=Intent(this, MainActivity10::class.java)
//            startActivity(intent2)
//        }

        //rupee navigate button
//        val rupeeBtn:ImageButton=findViewById(R.id.imageButton9)
//        rupeeBtn.setOnClickListener {
//            val intent3=Intent(this, MainActivity5::class.java)
//            startActivity(intent3)
//        }

    }
}