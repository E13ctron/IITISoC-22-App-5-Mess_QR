package com.example.messqr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

    }
    fun fetchData(view: View)
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