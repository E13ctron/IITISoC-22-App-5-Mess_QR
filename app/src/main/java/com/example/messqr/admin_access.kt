package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.messqr.databinding.ActivityAdminAccessBinding
import com.example.messqr.databinding.ActivityProfileScreenBinding
import com.google.firebase.auth.FirebaseAuth
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

    //view binding
    private lateinit var binding: ActivityAdminAccessBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAdminAccessBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //configure action bar
        actionBar=supportActionBar!!
        actionBar.title="Profile"

        //init firebase auth
        firebaseAuth=FirebaseAuth.getInstance()
        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email
        checkUser()

        //handle click logout
        binding.logoutbtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

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
    private fun checkUser() {
        //check whether user is logged in or not
        val firebaseUser=firebaseAuth.currentUser
        if (firebaseUser!=null)
        {
            //user not null logged in get user info
            val email=firebaseUser.email

        }
        else
        {
            //user is null user not logged in go to login window
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }
}