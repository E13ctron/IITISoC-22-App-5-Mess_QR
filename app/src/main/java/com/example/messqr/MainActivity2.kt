package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val signUp:TextView=findViewById(R.id.signUp)
        signUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            val intent2=Intent(this, MainActivity3::class.java)
            startActivity(intent2)
        }
        val button2:Button=findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent3=Intent(this, AdminPrompt::class.java)
            startActivity(intent3)
        }

    }
}