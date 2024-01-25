package com.example.signuppage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInPage : AppCompatActivity() {
    
    lateinit var db: DatabaseReference   // Same as PART - I

    companion object{
        const val KEY1 ="key1"
        const val KEY2 = "key2"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_page)
        
        val userid =findViewById<EditText>(R.id.useridT2) 
        val SignIn = findViewById<Button>(R.id.btnSignIn)
        
        SignIn.setOnClickListener {
            val userID =userid.text.toString()

            if(userID.isNotEmpty()){     // Checking if the Field is EMPTY
                readData(userID)         // User-Defined Function
            }else{
                Toast.makeText(this, "Please Enter Your User ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(UserID:String){
        db=FirebaseDatabase.getInstance().getReference("User23")
        db.child(UserID).get().addOnSuccessListener {
            if(it.exists()){
                Toast.makeText(this, "WORKING", Toast.LENGTH_SHORT).show()
                val name =it.child("name").value
                val userId = it.child("userId").value

                val myIntent = Intent(this,afterLoginIn::class.java)
                myIntent.putExtra(KEY1,name.toString())
                myIntent.putExtra(KEY2,userId.toString())
                startActivity(myIntent)
            }else{
                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}