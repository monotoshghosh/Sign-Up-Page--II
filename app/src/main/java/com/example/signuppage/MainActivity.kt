package com.example.signuppage


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database:DatabaseReference    // lateinit -> means to Initialize it Later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userid = findViewById<EditText>(R.id.useridT)
        val name = findViewById<EditText>(R.id.nameT)
        val password = findViewById<TextInputLayout>(R.id.passT)
        val signupbtn = findViewById<Button>(R.id.btnSignUp)
        val ifReg = findViewById<TextView>(R.id.ifReg)

        signupbtn.setOnClickListener {
            val nameTemp = name.text.toString()
            val useridTemp = userid.text.toString()
            val passTemp = password.editText.toString()

            val user = User(useridTemp,nameTemp,passTemp)
            database = FirebaseDatabase.getInstance().getReference("User23")

            database.child(useridTemp).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "Registeration Success", Toast.LENGTH_SHORT).show()
                userid.text.clear()
            }.
            addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        ifReg.setOnClickListener {
            intent = Intent(this,SignInPage::class.java)
            finish()
            startActivity(intent)
        }

    }
}