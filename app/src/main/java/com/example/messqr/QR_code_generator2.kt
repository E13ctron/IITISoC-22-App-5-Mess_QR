package com.example.messqr

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.messqr.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.encoder.QRCode

class QR_code_generator2 : AppCompatActivity() {
    private lateinit var ivQRcode: ImageView
    private lateinit var etData: EditText
    private lateinit var btnGenerateQRcode: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_generator2)

        ivQRcode=findViewById(R.id.ivQRCode)
        etData=findViewById(R.id.etData)
        btnGenerateQRcode=findViewById(R.id.btnGenerateQRcode)
        val mailButton: ImageButton=findViewById(R.id.announce_Ibutton)

        mailButton.setOnClickListener {
            Intent(this, Admin_Announcement::class.java).also{
                startActivity(it)
            }
        }

        val mail_btn:ImageButton=findViewById(R.id.mail_btn)
        mail_btn.setOnClickListener {
            Intent(this, admin_access::class.java).also{
                startActivity(it)
            }

        }


        btnGenerateQRcode.setOnClickListener {
            val data=etData.text.toString().trim()

            if (data.isEmpty())
            {
                Toast.makeText(this, "enter some data", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val writer = QRCodeWriter()
                try {
                    val bitMatrix=writer.encode(data, BarcodeFormat.QR_CODE,512,512)
                    val width=bitMatrix.width
                    val height=bitMatrix.height
                    val bmp= Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565)
                    for (x in 0 until width)
                    {
                        for (y in 0 until height)
                        {
                            bmp.setPixel(x,y, if (bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    ivQRcode.setImageBitmap(bmp)
                }
                catch (e: WriterException)
                {
                    e.printStackTrace()
                }
            }
        }
    }
}