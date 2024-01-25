package com.example.signuppage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class afterLoginIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login_in)

        val userID= intent.getStringExtra(SignInPage.KEY1)
        val Name =intent.getStringExtra(SignInPage.KEY2)


        val Welc= findViewById<TextView>(R.id.textView3)
        val userid= findViewById<TextView>(R.id.textV1)
        val name = findViewById<TextView>(R.id.textV2)

        Welc.text = "WELCOME $Name"
        userid.text = "Name : $userID"


    }
}