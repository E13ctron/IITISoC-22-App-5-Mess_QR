package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class gm_announce : AppCompatActivity() {

    // for saving announcement
    companion object {
        private const val TAG = "MainActivity"
        private const val heading_gm="heading"
        private const val date_gm="date"
        private const val detail_gm="detail"
        private const val price_gm="price"
    }

    private var gm_docref: DocumentReference = FirebaseFirestore.getInstance().document("announcement/gm_announcement")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gm_announce)

        //handle  mail buttom
        val mail_btn: ImageButton =findViewById(R.id.mail_btn)
        mail_btn.setOnClickListener {
            Intent(this, admin_access::class.java).also{
                startActivity(it)
            }

        }

        //handle qr code generator btn
        val codeGeneratorbBtn: ImageButton =findViewById(R.id.qr_generate_Ibutton)
        codeGeneratorbBtn.setOnClickListener {
            Intent(this, QR_code_generator2::class.java).also{
                startActivity(it)
            }

        }

        //handle announce generator btn
        val announceButton: ImageButton =findViewById(R.id.announce_Ibutton)
        announceButton.setOnClickListener {
            Intent(this, Admin_Announcement::class.java).also{
                startActivity(it)
            }
        }
    }
    fun saveData(view: View){
        val headingView: EditText =findViewById(R.id.heading_edit_text)
        val dateView: EditText =findViewById(R.id.date_edit_text)
        val detailView: EditText =findViewById(R.id.details_edit_text)
        val priceView: EditText =findViewById(R.id.price_edit_text)

        val headingText:String= headingView.text.toString()
        val dateText:String=dateView.text.toString()
        val detailText:String=detailView.text.toString()
        val priceText:String=priceView.text.toString()

        if (headingText.isEmpty()||dateText.isEmpty()||detailText.isEmpty()||priceText.isEmpty())
        {
            return
        }

        val dataToSave= hashMapOf<String, String>()
        dataToSave[heading_gm]=headingText
        dataToSave[detail_gm]=detailText
        dataToSave[date_gm]=dateText
        dataToSave[price_gm]=priceText

        gm_docref.set(dataToSave).addOnSuccessListener {
            Log.d(TAG, "savData: document is updated")
        }
            .addOnFailureListener{e->
                Log.e(TAG, e.toString() )

            }

    }
}