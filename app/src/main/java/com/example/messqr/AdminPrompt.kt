package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AdminPrompt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_prompt)

        val button:Button=findViewById(R.id.confirm_button)

        button.setOnClickListener {
            val password:EditText=findViewById(R.id.editTextPassword)
            val verifyPassword=password.text.toString()
            val string ="Admin"
            if (verifyPassword == string) {
                val intent = Intent(this, Admin_login::class.java)
                startActivity(intent)
            } else {
                if (verifyPassword != string && verifyPassword != "") {
                    Toast.makeText(this, "Invalid Password please try again", Toast.LENGTH_SHORT).show()
                    password.setText("")
                } else if (TextUtils.isEmpty(verifyPassword)) {
                    Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}
