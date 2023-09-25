package com.pupup.testno13

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username : EditText = findViewById(R.id.username)
        val phone : EditText = findViewById(R.id.phone)
        val password : EditText = findViewById(R.id.password)
        val register_btn : Button = findViewById(R.id.register_btn)


        val localStorage = getSharedPreferences("user",Context.MODE_PRIVATE)

        register_btn.setOnClickListener {
            val editPref = localStorage.edit()
            editPref.putBoolean("login",true)
            editPref.putString("username",username.text.toString())
            editPref.putString("phone",phone.text.toString())
            editPref.putString("password",password.text.toString()).apply()
            startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            finish()
        }

    }
}