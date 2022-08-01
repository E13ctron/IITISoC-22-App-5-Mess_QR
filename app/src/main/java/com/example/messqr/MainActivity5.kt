package com.example.messqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONException
import org.json.JSONObject

class MainActivity5 : AppCompatActivity(), PaymentResultListener {

    lateinit var fullMonthPay: ImageButton
    lateinit var dailyPay: ImageButton
    lateinit var specialMealPay: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        //restrict the screenshot on this specific page
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            );
        }

        //handle click announcement Image button
        val announceImageButtonButton: ImageButton = findViewById(R.id.announce_Ibutton)
        announceImageButtonButton.setOnClickListener {
            Intent(this, MainActivity9::class.java).also {
                startActivity(it)
            }
        }

        //handle click scanner Image button
        val scanImageButton: ImageButton = findViewById(R.id.scan_Ibutton)
        scanImageButton.setOnClickListener {
            Intent(this, MainActivity4::class.java).also {
                startActivity(it)
            }
        }

        //handle click history Image button
        val historyImageButton: ImageButton = findViewById(R.id.history_Ibutton)
        historyImageButton.setOnClickListener {
            Intent(this, MainActivity10::class.java).also {
                startActivity(it)
            }
        }

        //handle click profile button
        val profileImageButton: ImageButton = findViewById(R.id.profile_Ibutton)
        profileImageButton.setOnClickListener {
            Intent(this, ProfileScreen::class.java).also {
                startActivity(it)
            }
        }

        fullMonthPay = findViewById(R.id.imageButton)
        dailyPay = findViewById(R.id.imageButton2)
        specialMealPay = findViewById(R.id.imageButton3)

        fullMonthPay.setOnClickListener {

            //confirming amount(actual amount*100=amount)
            val amount: Int = 385000

            // on below line we are
            // initializing razorpay account
            val checkout = Checkout()

            // on the below line we have to see our id.
            checkout.setKeyID("rzp_test_eEXmO7yN5daB5T")

            // set image
            //checkout.setImage(R.drawable.android)

            // initialize json object
            val obj = JSONObject()
            try {
                // to put name
                obj.put("name", "Mess QR System")

                // put description
                obj.put("description", "Complete Month Mess coupon Payment ")

                // to set theme color
                obj.put("theme.color", "")

                // put the currency
                obj.put("currency", "INR")

                // put amount
                obj.put("amount", amount)

                // put mobile number
                obj.put("prefill.contact", "9971260556")

                // put email
                obj.put("prefill.email", "ishaanmittal123@gmail.com")

                // open razorpay to checkout activity
                checkout.open(this@MainActivity5, obj)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        dailyPay.setOnClickListener {

            //confirming amount(actual amount*100=amount)
            val amount: Int = 15500


            // on below line we are
            // initializing razorpay account
            val checkout = Checkout()

            // on the below line we have to see our id.
            checkout.setKeyID("rzp_test_eEXmO7yN5daB5T")

            // set image
            //checkout.setImage(R.drawable.android)

            // initialize json object
            val obj = JSONObject()
            try {
                // to put name
                obj.put("name", "Mess QR system")

                // put description
                obj.put("description", "Daily Mess coupon payment")

                // to set theme color
                obj.put("theme.color", "")

                // put the currency
                obj.put("currency", "INR")

                // put amount
                obj.put("amount", amount)

                // put mobile number
                obj.put("prefill.contact", "9971260556")

                // put email
                obj.put("prefill.email", "ishaanmittal123@gmail.com")

                // open razorpay to checkout activity
                checkout.open(this@MainActivity5, obj)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        specialMealPay.setOnClickListener {

            // on below line getting amount from edit text
            //val amt = amtEdt.text.toString()

            // rounding off the amount.
            //val amount = Math.round(amt.toFloat() * 100).toInt()
            val amount: Int = 5000


            // on below line we are
            // initializing razorpay account
            val checkout = Checkout()

            // on the below line we have to see our id.
            checkout.setKeyID("rzp_test_eEXmO7yN5daB5T")

            // set image
            //checkout.setImage(R.drawable.android)

            // initialize json object
            val obj = JSONObject()
            try {
                // to put name
                obj.put("name", "Mess QR system")

                // put description
                obj.put("description", "Special Meal payment")

                // to set theme color
                obj.put("theme.color", "")

                // put the currency
                obj.put("currency", "INR")

                // put amount
                obj.put("amount", amount)

                // put mobile number
                obj.put("prefill.contact", "9971260556")

                // put email
                obj.put("prefill.email", "ishaanmittal123@gmail.com")

                // open razorpay to checkout activity
                checkout.open(this@MainActivity5, obj)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }

    override fun onPaymentSuccess(s: String?) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    override fun onPaymentError(p0: Int, s: String?) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}