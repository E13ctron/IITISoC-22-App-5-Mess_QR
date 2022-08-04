package com.example.messqr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class details_of_mc : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val heading_mc="heading"
        private const val date_mc="date"
        private const val detail_mc="detail"
        private const val price_mc="price"
    }

    private var mcdocref: DocumentReference = FirebaseFirestore.getInstance().document("announcement/mc_announcement")

    private lateinit var headingData: TextView
    private lateinit var dateData: TextView
    private lateinit var detailData: TextView
    private lateinit var priceData: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_mc)

        headingData=findViewById(R.id.heading_text)
        dateData=findViewById(R.id.date_text)
        detailData=findViewById(R.id.details_text)
        priceData=findViewById(R.id.price_text_value)
    }

    fun fetchData(view: View)
    {
        mcdocref.get().addOnSuccessListener {
            if (it.exists()){
                val headingText:String?=it.getString(heading_mc)
                val dateText:String?=it.getString(date_mc)
                val detailText:String?=it.getString(detail_mc)
                val priceText:String?=it.getString(price_mc)

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