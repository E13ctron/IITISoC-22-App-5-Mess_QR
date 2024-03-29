package com.example.messqr

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class History_Table : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth



    companion object{
        const val TAG = "MainActivity10"

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_history_table)


        val B1_textView:TextView=findViewById(R.id.B1)
        val B2_textView:TextView=findViewById(R.id.B2)
        val B3_textView:TextView=findViewById(R.id.B3)
        val B4_textView:TextView=findViewById(R.id.B4)
        val B5_textView:TextView=findViewById(R.id.B5)
        val B6_textView:TextView=findViewById(R.id.B6)
        val B7_textView:TextView=findViewById(R.id.B7)
        val B8_textView:TextView=findViewById(R.id.B8)
        val B9_textView:TextView=findViewById(R.id.B9)
        val B10_textView:TextView=findViewById(R.id.B10)
        val B11_textView:TextView=findViewById(R.id.B11)
        val B12_textView:TextView=findViewById(R.id.B12)
        val B13_textView:TextView=findViewById(R.id.B13)
        val B14_textView:TextView=findViewById(R.id.B14)
        val B15_textView:TextView=findViewById(R.id.B15)
        val B16_textView:TextView=findViewById(R.id.B16)
        val B17_textView:TextView=findViewById(R.id.B17)
        val B18_textView:TextView=findViewById(R.id.B18)
        val B19_textView:TextView=findViewById(R.id.B19)
        val B20_textView:TextView=findViewById(R.id.B20)
        val B21_textView:TextView=findViewById(R.id.B21)
        val B22_textView:TextView=findViewById(R.id.B22)
        val B23_textView:TextView=findViewById(R.id.B23)
        val B24_textView:TextView=findViewById(R.id.B24)
        val B25_textView:TextView=findViewById(R.id.B25)
        val B26_textView:TextView=findViewById(R.id.B26)
        val B27_textView:TextView=findViewById(R.id.B27)
        val B28_textView:TextView=findViewById(R.id.B28)
        val B29_textView:TextView=findViewById(R.id.B29)
        val B30_textView:TextView=findViewById(R.id.B30)
        val B31_textView:TextView=findViewById(R.id.B31)

        val L1_textView:TextView=findViewById(R.id.L1)
        val L2_textView:TextView=findViewById(R.id.L2)
        val L3_textView:TextView=findViewById(R.id.L3)
        val L4_textView:TextView=findViewById(R.id.L4)
        val L5_textView:TextView=findViewById(R.id.L5)
        val L6_textView:TextView=findViewById(R.id.L6)
        val L7_textView:TextView=findViewById(R.id.L7)
        val L8_textView:TextView=findViewById(R.id.L8)
        val L9_textView:TextView=findViewById(R.id.L9)
        val L10_textView:TextView=findViewById(R.id.L10)
        val L11_textView:TextView=findViewById(R.id.L11)
        val L12_textView:TextView=findViewById(R.id.L12)
        val L13_textView:TextView=findViewById(R.id.L13)
        val L14_textView:TextView=findViewById(R.id.L14)
        val L15_textView:TextView=findViewById(R.id.L15)
        val L16_textView:TextView=findViewById(R.id.L16)
        val L17_textView:TextView=findViewById(R.id.L17)
        val L18_textView:TextView=findViewById(R.id.L18)
        val L19_textView:TextView=findViewById(R.id.L19)
        val L20_textView:TextView=findViewById(R.id.L20)
        val L21_textView:TextView=findViewById(R.id.L21)
        val L22_textView:TextView=findViewById(R.id.L22)
        val L23_textView:TextView=findViewById(R.id.L23)
        val L24_textView:TextView=findViewById(R.id.L24)
        val L25_textView:TextView=findViewById(R.id.L25)
        val L26_textView:TextView=findViewById(R.id.L26)
        val L27_textView:TextView=findViewById(R.id.L27)
        val L28_textView:TextView=findViewById(R.id.L28)
        val L29_textView:TextView=findViewById(R.id.L29)
        val L30_textView:TextView=findViewById(R.id.L30)
        val L31_textView:TextView=findViewById(R.id.L31)

        val D1_textView:TextView=findViewById(R.id.D1)
        val D2_textView:TextView=findViewById(R.id.D2)
        val D3_textView:TextView=findViewById(R.id.D3)
        val D4_textView:TextView=findViewById(R.id.D4)
        val D5_textView:TextView=findViewById(R.id.D5)
        val D6_textView:TextView=findViewById(R.id.D6)
        val D7_textView:TextView=findViewById(R.id.D7)
        val D8_textView:TextView=findViewById(R.id.D8)
        val D9_textView:TextView=findViewById(R.id.D9)
        val D10_textView:TextView=findViewById(R.id.D10)
        val D11_textView:TextView=findViewById(R.id.D11)
        val D12_textView:TextView=findViewById(R.id.D12)
        val D13_textView:TextView=findViewById(R.id.D13)
        val D14_textView:TextView=findViewById(R.id.D14)
        val D15_textView:TextView=findViewById(R.id.D15)
        val D16_textView:TextView=findViewById(R.id.D16)
        val D17_textView:TextView=findViewById(R.id.D17)
        val D18_textView:TextView=findViewById(R.id.D18)
        val D19_textView:TextView=findViewById(R.id.D19)
        val D20_textView:TextView=findViewById(R.id.D20)
        val D21_textView:TextView=findViewById(R.id.D21)
        val D22_textView:TextView=findViewById(R.id.D22)
        val D23_textView:TextView=findViewById(R.id.D23)
        val D24_textView:TextView=findViewById(R.id.D24)
        val D25_textView:TextView=findViewById(R.id.D25)
        val D26_textView:TextView=findViewById(R.id.D26)
        val D27_textView:TextView=findViewById(R.id.D27)
        val D28_textView:TextView=findViewById(R.id.D28)
        val D29_textView:TextView=findViewById(R.id.D29)
        val D30_textView:TextView=findViewById(R.id.D30)
        val D31_textView:TextView=findViewById(R.id.D31)

        //getting email variable
        firebaseAuth=FirebaseAuth.getInstance()

        val firebaseUser=firebaseAuth.currentUser
        val email= firebaseUser?.email


        //DOCUMENT REFERENCING

        val mdocref:DocumentReference=FirebaseFirestore.getInstance().document("History/${email}")


        // updating and fetching data

//        updateData(mdocref)
        fetchData(mdocref)


        //giving color to table

        if(B1_textView.text.toString()=="0"){
                B1_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
                B1_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B1_textView.text.toString()=="1"){
                B1_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
                B1_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B2_textView.text.toString()=="0"){
            B2_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B2_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B2_textView.text.toString()=="1"){
            B2_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B2_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B3_textView.text.toString()=="0"){
            B3_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B3_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B3_textView.text.toString()=="1"){
            B3_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B3_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B4_textView.text.toString()=="0"){
            B4_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B4_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B4_textView.text.toString()=="1"){
            B4_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B4_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B5_textView.text.toString()=="0"){
            B5_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B5_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B5_textView.text.toString()=="1"){
            B5_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B5_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B6_textView.text.toString()=="0"){
            B6_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B6_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B6_textView.text.toString()=="1"){
            B6_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B6_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B7_textView.text.toString()=="0"){
            B7_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B7_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B7_textView.text.toString()=="1"){
            B7_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B7_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B8_textView.text.toString()=="0"){
            B8_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B8_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B8_textView.text.toString()=="1"){
            B8_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B8_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B9_textView.text.toString()=="0"){
            B9_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B9_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B9_textView.text.toString()=="1"){
            B9_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B9_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B10_textView.text.toString()=="0"){
            B10_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B10_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B10_textView.text.toString()=="1"){
            B10_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B10_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B11_textView.text.toString()=="0"){
            B11_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B11_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B11_textView.text.toString()=="1"){
            B11_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B11_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B12_textView.text.toString()=="0"){
            B12_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B12_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B12_textView.text.toString()=="1"){
            B12_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B12_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B13_textView.text.toString()=="0"){
            B13_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B13_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B13_textView.text.toString()=="1"){
            B13_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B13_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B14_textView.text.toString()=="0"){
            B14_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B14_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B14_textView.text.toString()=="1"){
            B14_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B14_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B4_textView.text.toString()=="0"){
            B4_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B4_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B4_textView.text.toString()=="1"){
            B4_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B4_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B15_textView.text.toString()=="0"){
            B15_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B15_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B15_textView.text.toString()=="1"){
            B15_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B15_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B16_textView.text.toString()=="0"){
            B16_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B16_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B16_textView.text.toString()=="1"){
            B16_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B16_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B17_textView.text.toString()=="0"){
            B17_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B17_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B17_textView.text.toString()=="1"){
            B17_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B17_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B18_textView.text.toString()=="0"){
            B18_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B18_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B18_textView.text.toString()=="1"){
            B18_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B18_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B19_textView.text.toString()=="0"){
            B19_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B19_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B19_textView.text.toString()=="1"){
            B19_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B19_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B20_textView.text.toString()=="0"){
            B20_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B20_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B20_textView.text.toString()=="1") {
            B20_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B20_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B21_textView.text.toString()=="0"){
            B21_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B21_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B1_textView.text.toString()=="1"){
            B21_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B21_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B22_textView.text.toString()=="0"){
            B22_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B22_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B22_textView.text.toString()=="1"){
            B22_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B22_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B23_textView.text.toString()=="0"){
            B23_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B23_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B23_textView.text.toString()=="1"){
            B23_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B23_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B24_textView.text.toString()=="0"){
            B24_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B24_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B24_textView.text.toString()=="1"){
            B24_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B24_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B25_textView.text.toString()=="0"){
            B25_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B25_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B25_textView.text.toString()=="1"){
            B25_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B25_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B26_textView.text.toString()=="0"){
            B26_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B26_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B26_textView.text.toString()=="1"){
            B26_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B26_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B27_textView.text.toString()=="0"){
            B27_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B27_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B27_textView.text.toString()=="1"){
            B27_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B27_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B28_textView.text.toString()=="0"){
            B28_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B28_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B28_textView.text.toString()=="1"){
            B28_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B28_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B29_textView.text.toString()=="0"){
            B29_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B29_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B29_textView.text.toString()=="1"){
            B29_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B29_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B30_textView.text.toString()=="0"){
            B30_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B30_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B30_textView.text.toString()=="1"){
            B30_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B30_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(B31_textView.text.toString()=="0"){
            B31_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            B31_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(B31_textView.text.toString()=="1"){
            B31_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            B31_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L1_textView.text.toString()=="0"){
            L1_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L1_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L1_textView.text.toString()=="1"){
            L1_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L1_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L2_textView.text.toString()=="0"){
            L2_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L2_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L2_textView.text.toString()=="1"){
            L2_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L2_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L3_textView.text.toString()=="0"){
            L3_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L3_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L3_textView.text.toString()=="1"){
            L3_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L3_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L4_textView.text.toString()=="0"){
            L4_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L4_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L4_textView.text.toString()=="1"){
            L4_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L4_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L5_textView.text.toString()=="0"){
            L5_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L5_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L5_textView.text.toString()=="1"){
            L5_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L5_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L6_textView.text.toString()=="0"){
            L6_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L6_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L6_textView.text.toString()=="1"){
            L6_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L6_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L7_textView.text.toString()=="0"){
            L7_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L7_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L7_textView.text.toString()=="1"){
            L7_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L7_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L8_textView.text.toString()=="0"){
            L8_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L8_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L8_textView.text.toString()=="1"){
            L8_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L8_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L9_textView.text.toString()=="0"){
            L9_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L9_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L9_textView.text.toString()=="1"){
            L9_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L9_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L10_textView.text.toString()=="0"){
            L10_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L10_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L10_textView.text.toString()=="1"){
            L10_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L10_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L11_textView.text.toString()=="0"){
            L11_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L11_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L11_textView.text.toString()=="1"){
            L11_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L11_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L12_textView.text.toString()=="0"){
            L12_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L12_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L12_textView.text.toString()=="1"){
            L12_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L12_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L13_textView.text.toString()=="0"){
            L13_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L13_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L13_textView.text.toString()=="1"){
            L13_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L13_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L14_textView.text.toString()=="0"){
            L14_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L14_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L14_textView.text.toString()=="1"){
            L14_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L14_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L15_textView.text.toString()=="0"){
            L15_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L15_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L15_textView.text.toString()=="1"){
            L15_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L15_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L16_textView.text.toString()=="0"){
            L16_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L16_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L16_textView.text.toString()=="1"){
            L16_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L16_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L18_textView.text.toString()=="0"){
            L18_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L18_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L18_textView.text.toString()=="1"){
            L18_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L18_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L19_textView.text.toString()=="0"){
            L19_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L19_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L19_textView.text.toString()=="1") {
            L19_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L19_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L20_textView.text.toString()=="0"){
            L20_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L20_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L20_textView.text.toString()=="1"){
            L20_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L20_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L21_textView.text.toString()=="0"){
            L21_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L21_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L21_textView.text.toString()=="1"){
            L21_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L21_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L22_textView.text.toString()=="0"){
            L22_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L22_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L22_textView.text.toString()=="1"){
            L22_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L22_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L23_textView.text.toString()=="0"){
            L23_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L23_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L23_textView.text.toString()=="1"){
            L23_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L23_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L24_textView.text.toString()=="0"){
            L24_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L24_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L24_textView.text.toString()=="1"){
            L24_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L24_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L25_textView.text.toString()=="0"){
            L25_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L25_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L25_textView.text.toString()=="1"){
            L25_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L25_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L26_textView.text.toString()=="0"){
            L26_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L26_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L26_textView.text.toString()=="1"){
            L26_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L26_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L27_textView.text.toString()=="0"){
            L27_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L27_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L27_textView.text.toString()=="1"){
            L27_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L27_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L28_textView.text.toString()=="0"){
            L28_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L28_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L28_textView.text.toString()=="1"){
            L28_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L28_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L29_textView.text.toString()=="0"){
            L29_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L29_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L29_textView.text.toString()=="1"){
            L29_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L29_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L30_textView.text.toString()=="0"){
            L30_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L30_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L30_textView.text.toString()=="1"){
            L30_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L30_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(L31_textView.text.toString()=="0"){
            L31_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            L31_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(L31_textView.text.toString()=="1"){
            L31_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            L31_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D1_textView.text.toString()=="0"){
            D1_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D1_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D1_textView.text.toString()=="1"){
            D1_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D1_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D2_textView.text.toString()=="0"){
            D2_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D2_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D2_textView.text.toString()=="1"){
            D2_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D2_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D3_textView.text.toString()=="0"){
            D3_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D3_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D3_textView.text.toString()=="1"){
            D3_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D3_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D4_textView.text.toString()=="0"){
            D4_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D4_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D4_textView.text.toString()=="1"){
            D4_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D4_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D5_textView.text.toString()=="0"){
            D5_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D5_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D5_textView.text.toString()=="1"){
            D5_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D5_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D6_textView.text.toString()=="0"){
            D6_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D6_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D6_textView.text.toString()=="1"){
            D6_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D6_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D7_textView.text.toString()=="0"){
            D7_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D7_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D7_textView.text.toString()=="1"){
            D7_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D7_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D8_textView.text.toString()=="0"){
            D8_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D8_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D8_textView.text.toString()=="1"){
            D8_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D8_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D9_textView.text.toString()=="0"){
            D9_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D9_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D9_textView.text.toString()=="1"){
            D9_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D9_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D10_textView.text.toString()=="0"){
            D10_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D10_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D10_textView.text.toString()=="1"){
            D10_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D10_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D11_textView.text.toString()=="0"){
            D11_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D11_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D11_textView.text.toString()=="1"){
            D11_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D11_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D12_textView.text.toString()=="0"){
            D12_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D12_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D12_textView.text.toString()=="1"){
            D12_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D12_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D13_textView.text.toString()=="0"){
            D13_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D13_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D13_textView.text.toString()=="1"){
            D13_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D13_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D14_textView.text.toString()=="0"){
            D14_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D14_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D14_textView.text.toString()=="1"){
            D14_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D14_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D15_textView.text.toString()=="0"){
            D15_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D15_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D15_textView.text.toString()=="1"){
            D15_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D15_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D16_textView.text.toString()=="0"){
            D16_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D16_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D16_textView.text.toString()=="1"){
            D16_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D16_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D17_textView.text.toString()=="0"){
            D17_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D17_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D17_textView.text.toString()=="1"){
            D17_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D17_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D18_textView.text.toString()=="0"){
            D18_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D18_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D18_textView.text.toString()=="1"){
            D18_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D18_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D19_textView.text.toString()=="0"){
            D19_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D19_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D19_textView.text.toString()=="1"){
            D19_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D19_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D20_textView.text.toString()=="0"){
            D20_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D20_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D20_textView.text.toString()=="1"){
            D20_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D20_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D21_textView.text.toString()=="0"){
            D21_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D21_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D21_textView.text.toString()=="1"){
            D21_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D21_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D22_textView.text.toString()=="0"){
            D22_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D22_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D22_textView.text.toString()=="1"){
            D22_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D22_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D23_textView.text.toString()=="0"){
            D23_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D23_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D23_textView.text.toString()=="1"){
            D23_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D23_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D24_textView.text.toString()=="0"){
            D24_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D24_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D24_textView.text.toString()=="1"){
            D24_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D24_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D25_textView.text.toString()=="0"){
            D25_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D25_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D25_textView.text.toString()=="1"){
            D25_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D25_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D26_textView.text.toString()=="0"){
            D26_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D26_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D26_textView.text.toString()=="1"){
            D26_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D26_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D27_textView.text.toString()=="0"){
            D27_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D27_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D27_textView.text.toString()=="1"){
            D27_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D27_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D28_textView.text.toString()=="0"){
            D28_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D28_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D28_textView.text.toString()=="1"){
            D28_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D28_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D29_textView.text.toString()=="0"){
            D29_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D29_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D29_textView.text.toString()=="1"){
            D29_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D29_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D30_textView.text.toString()=="0"){
            D30_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D30_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D30_textView.text.toString()=="1"){
            D30_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D30_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }
        if(D31_textView.text.toString()=="0"){
            D31_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
            D31_textView.setTextColor(Color.parseColor("#E8E8E8"))

        }
        else if(D31_textView.text.toString()=="1"){
            D31_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
            D31_textView.setTextColor(Color.parseColor("#BDFFF9"))
        }


        //handle click announcement Image button
        val announceImageButtonButton: ImageButton =  findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this,Announcement_Section::class.java).also{
                startActivity(it)
            }
        }

        //handle click scanner Image button
        val scanImageButton: ImageButton =  findViewById(R.id.scan_Ibutton)
        scanImageButton.setOnClickListener {
            Intent(this,Main_QR_Scanning::class.java).also{
                startActivity(it)
            }
        }

        //handle click payment Image button
        val paymentImageButton: ImageButton =  findViewById(R.id.payment_Ibutton)
        paymentImageButton.setOnClickListener {
            Intent(this,Payment_Section::class.java).also{
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

    private fun checkCondition() {
        val B1_textView:TextView=findViewById(R.id.B1)
        val B2_textView:TextView=findViewById(R.id.B2)
        val B3_textView:TextView=findViewById(R.id.B3)
        val B4_textView:TextView=findViewById(R.id.B4)

        if(B1_textView.text.toString()=="0"){
                B1_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
                B1_textView.setTextColor(Color.parseColor("#E8E8E8"))

            }
            else if(B1_textView.text.toString()=="1"){
                B1_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
                B1_textView.setTextColor(Color.parseColor("#BDFFF9"))

            }
            if(B2_textView.text.toString()=="0"){
                B2_textView.setBackgroundColor(Color.parseColor("#E8E8E8"))
                B2_textView.setTextColor(Color.parseColor("#E8E8E8"))

            }
            else if(B2_textView.text.toString()=="1"){
                B2_textView.setBackgroundColor(Color.parseColor("#BDFFF9"))
                B2_textView.setTextColor(Color.parseColor("#BDFFF9"))

            }

    }



    private fun updateData(mdocref: DocumentReference) {
        if (scanid==""){return}

//       val enterTextData:EditText=findViewById(R.id.enterDataText)
       val string:String= scanid
       val dataText:String="1"

       val dataToSave= hashMapOf<String, String>()
       dataToSave[string]=dataText

       mdocref.update(dataToSave as Map<String, Any>).addOnSuccessListener {
           Log.d(TAG, "updateData: data is updated")
       }
           .addOnFailureListener{e->
               Log.e(TAG, e.toString() )
           }
    }

    private fun fetchData(mdocref: DocumentReference){

        mdocref.get().addOnSuccessListener {

//                val enterTextData:EditText=findViewById(R.id.enterDataText)
                val string:String= scanid

                val B1_string:String?=it.getString("B1")
                val B2_string:String?=it.getString("B2")
                val B3_string:String?=it.getString("B3")
                val B4_string:String?=it.getString("B4")
                val B5_string:String?=it.getString("B5")
                val B6_string:String?=it.getString("B6")
                val B7_string:String?=it.getString("B7")
                val B8_string:String?=it.getString("B8")
                val B9_string:String?=it.getString("B9")
                val B10_string:String?=it.getString("B10")
                val B11_string:String?=it.getString("B11")
                val B12_string:String?=it.getString("B12")
                val B13_string:String?=it.getString("B13")
                val B14_string:String?=it.getString("B14")
                val B15_string:String?=it.getString("B15")
                val B16_string:String?=it.getString("B16")
                val B17_string:String?=it.getString("B17")
                val B18_string:String?=it.getString("B18")
                val B19_string:String?=it.getString("B19")
                val B20_string:String?=it.getString("B20")
                val B21_string:String?=it.getString("B21")
                val B22_string:String?=it.getString("B22")
                val B23_string:String?=it.getString("B23")
                val B24_string:String?=it.getString("B24")
                val B25_string:String?=it.getString("B25")
                val B26_string:String?=it.getString("B26")
                val B27_string:String?=it.getString("B27")
                val B28_string:String?=it.getString("B28")
                val B29_string:String?=it.getString("B29")
                val B30_string:String?=it.getString("B30")
                val B31_string:String?=it.getString("B31")

            val L1_string:String?=it.getString("L1")
            val L2_string:String?=it.getString("L2")
            val L3_string:String?=it.getString("L3")
            val L4_string:String?=it.getString("L4")
            val L5_string:String?=it.getString("L5")
            val L6_string:String?=it.getString("L6")
            val L7_string:String?=it.getString("L7")
            val L8_string:String?=it.getString("L8")
            val L9_string:String?=it.getString("L9")
            val L10_string:String?=it.getString("L10")
            val L11_string:String?=it.getString("L11")
            val L12_string:String?=it.getString("L12")
            val L13_string:String?=it.getString("L13")
            val L14_string:String?=it.getString("L14")
            val L15_string:String?=it.getString("L15")
            val L16_string:String?=it.getString("L16")
            val L17_string:String?=it.getString("L17")
            val L18_string:String?=it.getString("L18")
            val L19_string:String?=it.getString("L19")
            val L20_string:String?=it.getString("L20")
            val L21_string:String?=it.getString("L21")
            val L22_string:String?=it.getString("L22")
            val L23_string:String?=it.getString("L23")
            val L24_string:String?=it.getString("L24")
            val L25_string:String?=it.getString("L25")
            val L26_string:String?=it.getString("L26")
            val L27_string:String?=it.getString("L27")
            val L28_string:String?=it.getString("L28")
            val L29_string:String?=it.getString("L29")
            val L30_string:String?=it.getString("L30")
            val L31_string:String?=it.getString("L31")

            val D1_string:String?=it.getString("D1")
            val D2_string:String?=it.getString("D2")
            val D3_string:String?=it.getString("D3")
            val D4_string:String?=it.getString("D4")
            val D5_string:String?=it.getString("D5")
            val D6_string:String?=it.getString("D6")
            val D7_string:String?=it.getString("D7")
            val D8_string:String?=it.getString("D8")
            val D9_string:String?=it.getString("D9")
            val D10_string:String?=it.getString("D10")
            val D11_string:String?=it.getString("D11")
            val D12_string:String?=it.getString("D12")
            val D13_string:String?=it.getString("D13")
            val D14_string:String?=it.getString("D14")
            val D15_string:String?=it.getString("D15")
            val D16_string:String?=it.getString("D16")
            val D17_string:String?=it.getString("D17")
            val D18_string:String?=it.getString("D18")
            val D19_string:String?=it.getString("D19")
            val D20_string:String?=it.getString("D20")
            val D21_string:String?=it.getString("D21")
            val D22_string:String?=it.getString("D22")
            val D23_string:String?=it.getString("D23")
            val D24_string:String?=it.getString("D24")
            val D25_string:String?=it.getString("D25")
            val D26_string:String?=it.getString("D26")
            val D27_string:String?=it.getString("D27")
            val D28_string:String?=it.getString("D28")
            val D29_string:String?=it.getString("D29")
            val D30_string:String?=it.getString("D30")
            val D31_string:String?=it.getString("D31")

            val B1_textView:TextView=findViewById(R.id.B1)
            val B2_textView:TextView=findViewById(R.id.B2)
            val B3_textView:TextView=findViewById(R.id.B3)
            val B4_textView:TextView=findViewById(R.id.B4)
            val B5_textView:TextView=findViewById(R.id.B5)
            val B6_textView:TextView=findViewById(R.id.B6)
            val B7_textView:TextView=findViewById(R.id.B7)
            val B8_textView:TextView=findViewById(R.id.B8)
            val B9_textView:TextView=findViewById(R.id.B9)
            val B10_textView:TextView=findViewById(R.id.B10)
            val B11_textView:TextView=findViewById(R.id.B11)
            val B12_textView:TextView=findViewById(R.id.B12)
            val B13_textView:TextView=findViewById(R.id.B13)
            val B14_textView:TextView=findViewById(R.id.B14)
            val B15_textView:TextView=findViewById(R.id.B15)
            val B16_textView:TextView=findViewById(R.id.B16)
            val B17_textView:TextView=findViewById(R.id.B17)
            val B18_textView:TextView=findViewById(R.id.B18)
            val B19_textView:TextView=findViewById(R.id.B19)
            val B20_textView:TextView=findViewById(R.id.B20)
            val B21_textView:TextView=findViewById(R.id.B21)
            val B22_textView:TextView=findViewById(R.id.B22)
            val B23_textView:TextView=findViewById(R.id.B23)
            val B24_textView:TextView=findViewById(R.id.B24)
            val B25_textView:TextView=findViewById(R.id.B25)
            val B26_textView:TextView=findViewById(R.id.B26)
            val B27_textView:TextView=findViewById(R.id.B27)
            val B28_textView:TextView=findViewById(R.id.B28)
            val B29_textView:TextView=findViewById(R.id.B29)
            val B30_textView:TextView=findViewById(R.id.B30)
            val B31_textView:TextView=findViewById(R.id.B31)

            val L1_textView:TextView=findViewById(R.id.L1)
            val L2_textView:TextView=findViewById(R.id.L2)
            val L3_textView:TextView=findViewById(R.id.L3)
            val L4_textView:TextView=findViewById(R.id.L4)
            val L5_textView:TextView=findViewById(R.id.L5)
            val L6_textView:TextView=findViewById(R.id.L6)
            val L7_textView:TextView=findViewById(R.id.L7)
            val L8_textView:TextView=findViewById(R.id.L8)
            val L9_textView:TextView=findViewById(R.id.L9)
            val L10_textView:TextView=findViewById(R.id.L10)
            val L11_textView:TextView=findViewById(R.id.L11)
            val L12_textView:TextView=findViewById(R.id.L12)
            val L13_textView:TextView=findViewById(R.id.L13)
            val L14_textView:TextView=findViewById(R.id.L14)
            val L15_textView:TextView=findViewById(R.id.L15)
            val L16_textView:TextView=findViewById(R.id.L16)
            val L17_textView:TextView=findViewById(R.id.L17)
            val L18_textView:TextView=findViewById(R.id.L18)
            val L19_textView:TextView=findViewById(R.id.L19)
            val L20_textView:TextView=findViewById(R.id.L20)
            val L21_textView:TextView=findViewById(R.id.L21)
            val L22_textView:TextView=findViewById(R.id.L22)
            val L23_textView:TextView=findViewById(R.id.L23)
            val L24_textView:TextView=findViewById(R.id.L24)
            val L25_textView:TextView=findViewById(R.id.L25)
            val L26_textView:TextView=findViewById(R.id.L26)
            val L27_textView:TextView=findViewById(R.id.L27)
            val L28_textView:TextView=findViewById(R.id.L28)
            val L29_textView:TextView=findViewById(R.id.L29)
            val L30_textView:TextView=findViewById(R.id.L30)
            val L31_textView:TextView=findViewById(R.id.L31)

            val D1_textView:TextView=findViewById(R.id.D1)
            val D2_textView:TextView=findViewById(R.id.D2)
            val D3_textView:TextView=findViewById(R.id.D3)
            val D4_textView:TextView=findViewById(R.id.D4)
            val D5_textView:TextView=findViewById(R.id.D5)
            val D6_textView:TextView=findViewById(R.id.D6)
            val D7_textView:TextView=findViewById(R.id.D7)
            val D8_textView:TextView=findViewById(R.id.D8)
            val D9_textView:TextView=findViewById(R.id.D9)
            val D10_textView:TextView=findViewById(R.id.D10)
            val D11_textView:TextView=findViewById(R.id.D11)
            val D12_textView:TextView=findViewById(R.id.D12)
            val D13_textView:TextView=findViewById(R.id.D13)
            val D14_textView:TextView=findViewById(R.id.D14)
            val D15_textView:TextView=findViewById(R.id.D15)
            val D16_textView:TextView=findViewById(R.id.D16)
            val D17_textView:TextView=findViewById(R.id.D17)
            val D18_textView:TextView=findViewById(R.id.D18)
            val D19_textView:TextView=findViewById(R.id.D19)
            val D20_textView:TextView=findViewById(R.id.D20)
            val D21_textView:TextView=findViewById(R.id.D21)
            val D22_textView:TextView=findViewById(R.id.D22)
            val D23_textView:TextView=findViewById(R.id.D23)
            val D24_textView:TextView=findViewById(R.id.D24)
            val D25_textView:TextView=findViewById(R.id.D25)
            val D26_textView:TextView=findViewById(R.id.D26)
            val D27_textView:TextView=findViewById(R.id.D27)
            val D28_textView:TextView=findViewById(R.id.D28)
            val D29_textView:TextView=findViewById(R.id.D29)
            val D30_textView:TextView=findViewById(R.id.D30)
            val D31_textView:TextView=findViewById(R.id.D31)


                B1_textView.text=B1_string
                B2_textView.text=B2_string
                B3_textView.text=B3_string
                B4_textView.text=B4_string
                B5_textView.text=B5_string
                B6_textView.text=B6_string
                B7_textView.text=B7_string
                B8_textView.text=B8_string
                B9_textView.text=B9_string
                B10_textView.text=B10_string
                B11_textView.text=B11_string
                B12_textView.text=B12_string
                B13_textView.text=B13_string
                B14_textView.text=B14_string
                B15_textView.text=B15_string
                B16_textView.text=B16_string
                B17_textView.text=B17_string
                B18_textView.text=B18_string
                B19_textView.text=B19_string
                B20_textView.text=B20_string
                B21_textView.text=B21_string
                B22_textView.text=B22_string
                B23_textView.text=B23_string
                B24_textView.text=B24_string
                B25_textView.text=B25_string
                B26_textView.text=B26_string
                B27_textView.text=B27_string
                B28_textView.text=B28_string
                B29_textView.text=B29_string
                B30_textView.text=B30_string
                B31_textView.text=B31_string

            L1_textView.text=L1_string
            L2_textView.text=L2_string
            L3_textView.text=L3_string
            L4_textView.text=L4_string
            L5_textView.text=L5_string
            L6_textView.text=L6_string
            L7_textView.text=L7_string
            L8_textView.text=L8_string
            L9_textView.text=L9_string
            L10_textView.text=L10_string
            L11_textView.text=L11_string
            L12_textView.text=L12_string
            L13_textView.text=L13_string
            L14_textView.text=L14_string
            L15_textView.text=L15_string
            L16_textView.text=L16_string
            L17_textView.text=L17_string
            L18_textView.text=L18_string
            L19_textView.text=L19_string
            L20_textView.text=L20_string
            L21_textView.text=L21_string
            L22_textView.text=L22_string
            L23_textView.text=L23_string
            L24_textView.text=L24_string
            L25_textView.text=L25_string
            L26_textView.text=L26_string
            L27_textView.text=L27_string
            L28_textView.text=L28_string
            L29_textView.text=L29_string
            L30_textView.text=L30_string
            L31_textView.text=L31_string

            D1_textView.text=D1_string
            D2_textView.text=D2_string
            D3_textView.text=D3_string
            D4_textView.text=D4_string
            D5_textView.text=D5_string
            D6_textView.text=D6_string
            D7_textView.text=D7_string
            D8_textView.text=D8_string
            D9_textView.text=D9_string
            D10_textView.text=D10_string
            D11_textView.text=D11_string
            D12_textView.text=D12_string
            D13_textView.text=D13_string
            D14_textView.text=D14_string
            D15_textView.text=D15_string
            D16_textView.text=D16_string
            D17_textView.text=D17_string
            D18_textView.text=D18_string
            D19_textView.text=D19_string
            D20_textView.text=D20_string
            D21_textView.text=D21_string
            D22_textView.text=D22_string
            D23_textView.text=D23_string
            D24_textView.text=D24_string
            D25_textView.text=D25_string
            D26_textView.text=D26_string
            D27_textView.text=D27_string
            D28_textView.text=D28_string
            D29_textView.text=D29_string
            D30_textView.text=D30_string
            D31_textView.text=D31_string


        }
            .addOnFailureListener { e->
                Log.e(TAG, e.toString() )
            }
    }
}