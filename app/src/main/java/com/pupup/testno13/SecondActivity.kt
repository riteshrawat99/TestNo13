package com.pupup.testno13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bottom_navigation : BottomNavigationView = findViewById(R.id.bottom_navigation)
        loadFragment(HomeFragment())
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    Toast.makeText(this@SecondActivity, "Home", Toast.LENGTH_SHORT).show()
                    loadFragment(HomeFragment())
                }
                R.id.profile->{
                    Toast.makeText(this@SecondActivity, "Profile", Toast.LENGTH_SHORT).show()
                    loadFragment(ProfileFragment())
                } R.id.cart->{
                    Toast.makeText(this@SecondActivity, "Card", Toast.LENGTH_SHORT).show()
                    loadFragment(CardFragment())
                }


            }
            true
        }
    }
    fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,fragment).commit()
    }
}