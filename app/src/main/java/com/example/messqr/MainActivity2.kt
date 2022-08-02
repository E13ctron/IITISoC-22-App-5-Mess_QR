package com.example.messqr

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setupPermissions()
        val signUp: TextView = findViewById(R.id.signUp)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val button: Button = findViewById(R.id.studentButton)
        button.setOnClickListener {
            val intent2 = Intent(this, MainActivity3::class.java)
            startActivity(intent2)
        }
        val button2: Button = findViewById(R.id.adminButton)
        button2.setOnClickListener {
            val intent3 = Intent(this, AdminPrompt::class.java)
            startActivity(intent3)
        }
    }
        private fun setupPermissions() {
            val permission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            )

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission to Camera denied")
                makeRequest()
            }
        }

        private fun makeRequest() {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                RECORD_REQUEST_CODE
            )
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>, grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when (requestCode) {
                RECORD_REQUEST_CODE -> {

                    if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                        Log.i(ContentValues.TAG, "Permission has been denied by user")
                    } else {
                        Log.i(ContentValues.TAG, "Permission has been granted by user")
                    }
                }
            }
        }
    }