package com.example.messqr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class sm_announce : AppCompatActivity() {

    // for saving announcement
    companion object {
        private const val TAG = "MainActivity"
        private const val heading_sm="heading"
        private const val date_sm="date"
        private const val detail_sm="detail"
        private const val price_sm="price"
    }

    private var sm_docref:DocumentReference=FirebaseFirestore.getInstance().document("announcement/sm_announcement")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sm_announce)
    }

    fun saveData(view: View){
        val headingView:EditText=findViewById(R.id.heading_edit_text)
        val dateView:EditText=findViewById(R.id.date_edit_text)
        val detailView:EditText=findViewById(R.id.details_edit_text)
        val priceView:EditText=findViewById(R.id.price_edit_text)

        val headingText:String= headingView.text.toString()
        val dateText:String=dateView.text.toString()
        val detailText:String=detailView.text.toString()
        val priceText:String=priceView.text.toString()

        if (headingText.isEmpty()||dateText.isEmpty()||detailText.isEmpty()||priceText.isEmpty())
        {
            return
        }

        val dataToSave= hashMapOf<String, String>()
        dataToSave[heading_sm]=headingText
        dataToSave[detail_sm]=detailText
        dataToSave[date_sm]=dateText
        dataToSave[price_sm]=priceText

        sm_docref.set(dataToSave).addOnSuccessListener {
            Log.d(TAG, "saveData: document is updated")
        }
            .addOnFailureListener{e->
                Log.e(TAG, e.toString() )

            }

    }
}