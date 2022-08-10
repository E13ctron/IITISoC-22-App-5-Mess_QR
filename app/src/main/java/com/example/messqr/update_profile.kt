package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class update_profile : AppCompatActivity() {
    companion object{
        private const val TAG = "update_profile"
        private const val name="name"
        private const val age="age"
        private const val department="department"
        private const val mobile_no="mobile_no"

    }
    private lateinit var firebaseAuth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        //getting email as profile key

        firebaseAuth=FirebaseAuth.getInstance()

        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email


        //document referencing
        val mdocref:DocumentReference=FirebaseFirestore.getInstance().document("profile/${email}")

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

        //handle click payment Image button
        val paymentImageButton: ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,MainActivity5::class.java).also{
                startActivity(it)
            }
        }

        //handle save button
        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            saveData(mdocref)
        }
    }

    fun saveData(mdocref: DocumentReference) {
        val nameView:EditText=findViewById(R.id.name_text)
        val ageView:EditText=findViewById(R.id.age_text)
        val departmentView:EditText=findViewById(R.id.department_text)
        val mobile_numberView:EditText=findViewById(R.id.mobile_no_text)

        val nameText:String=nameView.text.toString()
        val ageText:String=ageView.text.toString()
        val departmentText:String=departmentView.text.toString()
        val mobile_numberText:String=mobile_numberView.text.toString()

        val dataToSave= hashMapOf<String, String>()
        dataToSave[name]=nameText
        dataToSave[age]=ageText
        dataToSave[department]=departmentText
        dataToSave[mobile_no]=mobile_numberText

        if (nameText.isEmpty()||ageText.isEmpty()||departmentText.isEmpty()||mobile_numberText.isEmpty())
        {
            mdocref.update(dataToSave as Map<String, Any>).addOnSuccessListener {
                Log.d(TAG, "saveData: data updated")
            }
                .addOnFailureListener { e->
                    Log.e(TAG, e.toString() )
                }
        }
        else
        {
            mdocref.set(dataToSave).addOnSuccessListener {
                Log.d(TAG, "saveData: data updated")
            }
                .addOnFailureListener { e->
                    Log.e(TAG, e.toString() )
                }
        }


    }
}