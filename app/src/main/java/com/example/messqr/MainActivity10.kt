package com.example.messqr

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity10 : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth



    companion object{
        private const val TAG = "MainActivity10"

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        val B1_textView:TextView=findViewById(R.id.B1)
        val B2_textView:TextView=findViewById(R.id.B2)
        val B3_textView:TextView=findViewById(R.id.B3)
        val B4_textView:TextView=findViewById(R.id.B4)
        //getting email variable
        firebaseAuth=FirebaseAuth.getInstance()

        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email


        //DOCUMENT REFERENCING

        var mdocref:DocumentReference=FirebaseFirestore.getInstance().document("History/${email}")


        val enterBtn:Button=findViewById(R.id.savingData)


        enterBtn.setOnClickListener {
            val string:String= scanid
                    updateData(mdocref)
                    fetchData(mdocref)
            if(B1_textView.text.toString()=="0"){
                B1_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
                B1_textView.setTextColor(Color.parseColor("#E8E8E8"))

            }
            else if(B1_textView.text.toString()=="1"){
                B1_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
                B1_textView.setTextColor(Color.parseColor("#BDFFF9"))

            }
        }

        val resetBtn:Button=findViewById(R.id.initializeDataBtn)
        resetBtn.setOnClickListener {
            resetData(mdocref)
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

        //handle click payment Image button
        val paymentImageButton: ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,MainActivity5::class.java).also{
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



    }

    private fun resetData(mdocref: DocumentReference) {
        val dataToSave= hashMapOf<String, String>()
        dataToSave["B1"]="0"
        dataToSave["B2"]="0"
        dataToSave["B3"]="0"
        dataToSave["B4"]="0"

        mdocref.set(dataToSave).addOnSuccessListener {
            Log.d(TAG, "resetData: ")

        }
            .addOnFailureListener { e->
                Log.e(TAG, e.toString() )
            }
    }

    fun updateData(mdocref: DocumentReference) {

//       val enterTextData:EditText=findViewById(R.id.enterDataText)
       val string:String= scanid
       val dataText:String="1"

       val dataToSave= hashMapOf<String, String>()
       dataToSave[string]=dataText

       mdocref.update(dataToSave as Map<String, Any>).addOnSuccessListener {
           Log.d(TAG, "saveData: document added")
       }
           .addOnFailureListener{e->
               Log.e(TAG, e.toString() )
           }
    }

    fun fetchData(mdocref: DocumentReference){

        mdocref.get().addOnSuccessListener {

//                val enterTextData:EditText=findViewById(R.id.enterDataText)
                val string:String= scanid

                val B1_string:String?=it.getString("B1")
                val B2_string:String?=it.getString("B2")
                val B3_string:String?=it.getString("B3")
                val B4_string:String?=it.getString("B4")


                val B1_textView:TextView=findViewById(R.id.B1)
                val B2_textView:TextView=findViewById(R.id.B2)
                val B3_textView:TextView=findViewById(R.id.B3)
                val B4_textView:TextView=findViewById(R.id.B4)


                B1_textView.text=B1_string
                B2_textView.text=B2_string
                B3_textView.text=B3_string
                B4_textView.text=B4_string



        }
            .addOnFailureListener { e->
                Log.e(TAG, e.toString() )
            }
    }
}