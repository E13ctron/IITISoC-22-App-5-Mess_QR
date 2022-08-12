package com.example.messqr

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.PixelCopy.request
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class Main_QR_Scanning : AppCompatActivity() {
    companion object {
        private const val TAG = "Main_QR_Scanning"
    }

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_qr_scanning)

        //init firebase auth
        firebaseAuth=FirebaseAuth.getInstance()
        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email
        val mdocref:DocumentReference=FirebaseFirestore.getInstance().document("History/${email}")

        //restrict the screenshot on this specific page
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }



        val currentTime: Date = Calendar.getInstance().time
        val hours: Int = currentTime.hours
        val scanResult: TextView = findViewById(R.id.scan_result)
        val tick: ImageView = findViewById(R.id.tick_icon)
        if (scanid != "") {
            var value :String=""
            mdocref.get().addOnSuccessListener {

                    value= it.getString(scanid).toString()

            }
                .addOnFailureListener {e->
                    Log.e(TAG, e.toString())
                }

            Log.v(String(), value)

//            if (value == "0")
//            {
                tick.setImageResource(R.drawable.ic_green_circle_200)
                scanResult.text = "The QR Code was Scanned Successfully "
                scanResult.textSize = resources.getDimension(R.dimen.font_10)
                a=1
                updateData(mdocref)
//            }
//            else if(value=="1")
//            {
//                tick.setImageResource(R.drawable.ic_qrcode_default_200)
//                scanResult.text = "Already Scanned "
//                Toast.makeText(this, "Do not scan more than one time", Toast.LENGTH_SHORT)
//                    .show()
//            }

        } else {
            tick.setImageResource(R.drawable.ic_qrcode_default_200)
            scanResult.text = "Please Scan"
        }

        //handle click special meal button
        val button4: Button = findViewById(R.id.special_meal_button)
        button4.setOnClickListener {
            Intent(this, SpecialMeal_QR_Scanning::class.java).also {
                startActivity(it)
            }
        }
//       if(hours in 20..22 ) {
//            button4.setOnClickListener {
//                Intent(this,MainActivity8::class.java).also{
//                    startActivity(it)
//                }
//            }
//        }
//        else{
//            button4.setOnClickListener {
//                Toast.makeText(this, "Special menu only available during dinner", Toast.LENGTH_SHORT).show()
//            }
//        }

        //handle click announcement Image button
        val announceImageButtonButton: ImageButton = findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this, Announcement_Section::class.java).also {
                startActivity(it)
            }
        }

        //handle click payment Image button
        val paymentImageButton: ImageButton = findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this, Payment_Section::class.java).also {
                startActivity(it)
            }
        }

        //handle click history Image button
        val historyImageButton: ImageButton = findViewById(R.id.history_Ibutton)
        historyImageButton.setOnClickListener {
            Intent(this, History_Table::class.java).also {
                startActivity(it)
            }
        }

        //handle click profile button
        val profileImageButton: ImageButton = findViewById(R.id.profile_Ibutton)
        profileImageButton.setOnClickListener {
            Intent(this, ProfileScreen::class.java).also {
                startActivity(it)
            }
        }

        //handle click scan button
        val scanButton: Button = findViewById(R.id.scan_button)
        val available: TextView = findViewById(R.id.available_text)
        if (hours in 1..9 || hours in 10..14 || hours in 16..22) {
            when (hours) {
                in 1..9 -> {
                    available.text = "Breakfast Available"
                }
                in 10..14 -> {
                    available.text = "Lunch Available"
                }
                in 16..22 -> {
                    available.text = "Dinner Available"
                }
            }
                scanButton.setOnClickListener {
//                    var string :String?=""
//                    mdocref.get().addOnSuccessListener {
//                     if(it.exists()){
//                    string=it.getString(scanid)
//                                       }
//                          }
//                .addOnFailureListener {
//                    Log.e(TAG, "onCreate: ", )
//                }
                    if(scanid=="") {
                        Intent(this, QR_Scanner::class.java).also {
                            startActivity(it)
                        }
                    }
                    else{
                        Toast.makeText(this, "You have already Scanned", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        } else {
            scanButton.setOnClickListener {
                tick.setImageResource(R.drawable.ic_qrcode_default_200)
                scanResult.text = "Scan the QR"
                a=0
                scanid=""
                Toast.makeText(this, "Please scan at the correct meal timing", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
    private fun updateData(mdocref: DocumentReference) {
        if (scanid==""){return}

//       val enterTextData:EditText=findViewById(R.id.enterDataText)
        val string:String= scanid
        val dataText:String="1"

        val dataToSave= hashMapOf<String, String>()
        dataToSave[string]=dataText

        mdocref.update(dataToSave as Map<String, Any>).addOnSuccessListener {
            Log.d(History_Table.TAG, "updateData: data is updated")
        }
            .addOnFailureListener{e->
                Log.e(History_Table.TAG, e.toString() )
            }
    }
    override fun onBackPressed() {
        Toast.makeText(applicationContext, "Disabled Back Press for this Screen", Toast.LENGTH_SHORT).show()
    }
}




