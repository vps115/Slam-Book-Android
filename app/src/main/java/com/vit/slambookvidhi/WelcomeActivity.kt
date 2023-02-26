package com.vit.slambookvidhi


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = findViewById<AppCompatEditText>(R.id.edtname)
        val dob = findViewById<AppCompatEditText>(R.id.edtdob)
        val phone = findViewById<AppCompatEditText>(R.id.edtnumber)
        val hobby = findViewById<AppCompatEditText>(R.id.edthobby)

        val submitButton = findViewById<AppCompatButton>(R.id.btnsave)
        val btnFriendsList = findViewById<AppCompatButton>(R.id.btnFriendList)

        submitButton.setOnClickListener {
            //Log.d("WelcomeActivity", name.text.toString())
            val dbHelper = DBHelper(this, null)

            dbHelper.addFriendToSlamBook(
                name.text.toString(),
                dob.text.toString(),
                phone.text.toString(),
                hobby.text.toString())

            Toast.makeText(this@WelcomeActivity, "Friend Added Successfully", Toast.LENGTH_LONG).show()

            name.text?.clear()
            dob.text?.clear()
            phone.text?.clear()
            hobby.text?.clear()
        }

        btnFriendsList.setOnClickListener {
            val intent = Intent(this, FriendsListActivity::class.java)
            startActivity(intent)
        }

    }
}