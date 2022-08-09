package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class details_of_gm : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val heading_gm="heading"
        private const val date_gm="date"
        private const val detail_gm="detail"
        private const val price_gm="price"
    }

    private var gmdocref: DocumentReference = FirebaseFirestore.getInstance().document("announcement/gm_announcement")

    private lateinit var headingData: TextView
    private lateinit var dateData: TextView
    private lateinit var detailData: TextView
    private lateinit var priceData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_gm)

        headingData=findViewById(R.id.heading_text)
        dateData=findViewById(R.id.date_text)
        detailData=findViewById(R.id.details_text)
        priceData=findViewById(R.id.price_text_value)

        fetchData()

        //handle click scanner Image button
        val scanImageButton: ImageButton =  findViewById(R.id.scan_Ibutton)
        scanImageButton.setOnClickListener {
            Intent(this,MainActivity4::class.java).also{
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
        val profileImageButton: ImageButton =findViewById(R.id.profile_Ibutton)
        profileImageButton.setOnClickListener {
            Intent(this, ProfileScreen::class.java).also {
                startActivity(it)
            }
        }

    }
    private fun fetchData()
    {
        gmdocref.get().addOnSuccessListener {
            if (it.exists()){
                val headingText:String?=it.getString(heading_gm)
                val dateText:String?=it.getString(date_gm)
                val detailText:String?=it.getString(detail_gm)
                val priceText:String?=it.getString(price_gm)

                headingData.text=headingText
                dateData.text=dateText
                detailData.text=detailText
                priceData.text=priceText

            }
        }
            .addOnFailureListener{e->
                Log.e(TAG,e.toString() )

            }
    }

}