package com.pupup.testno13

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)
        val login = localStorage.getBoolean("login",false)
        Handler().postDelayed({
            if(login == true){
                startActivity(Intent(this@SplashActivity,SecondActivity::class.java))
            }
            else{
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            }
            finish()
        },1500)
    }
}