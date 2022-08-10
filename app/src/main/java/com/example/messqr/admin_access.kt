package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class admin_access : AppCompatActivity() {

    companion object{
        private const val TAG = "update_profile"
        private const val name="name"
        private const val age="age"
        private const val department="department"
        private const val mobile_no="mobile_no"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_access)




        val fetch_btn:Button=findViewById(R.id.button4)
        fetch_btn.setOnClickListener {
            val email:EditText=findViewById(R.id.textView4)
            val email_data:String=email.text.toString()
            val mdocref:DocumentReference=FirebaseFirestore.getInstance().document("profile/${email_data}")
            fetchData(mdocref)
        }

        //handle qr code generator btn
        val codeGeneratorbBtn:ImageButton=findViewById(R.id.generate_button)
        codeGeneratorbBtn.setOnClickListener {
            Intent(this, QR_code_generator2::class.java).also{
                startActivity(it)
            }

        }

        val mailButton: ImageButton =findViewById(R.id.announce_Ibutton)

        mailButton.setOnClickListener {
            Intent(this, Admin_Announcement::class.java).also{
                startActivity(it)
            }
        }



    }

    private fun fetchData(mdocref: DocumentReference) {
        val usernameView: TextView =findViewById(R.id.textView7)
        val ageView: TextView =findViewById(R.id.textView9)
        val departmentView: TextView =findViewById(R.id.textView11)
        val mobileView: TextView =findViewById(R.id.textView25)

        mdocref.get().addOnSuccessListener {
            if(it.exists()){
                val nameText:String?=it.getString(name)
                val ageText:String?=it.getString(age)
                val departmentText:String?=it.getString(department)
                val mobileText:String?=it.getString(mobile_no)

                usernameView.text= nameText
                ageView.text=ageText
                departmentView.text=departmentText
                mobileView.text=mobileText
            }
        }
            .addOnFailureListener { e->
                Log.e(TAG, e.toString() )
            }
    }
}