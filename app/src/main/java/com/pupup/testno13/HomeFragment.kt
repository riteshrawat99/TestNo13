package com.pupup.testno13

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val menu_btn : Button = view.findViewById(R.id.menu_btn)
        menu_btn.setOnClickListener {
            startActivity(Intent(requireActivity(),OptionMenuActivity::class.java))
        }

        val localStorge = activity?.getSharedPreferences("user",Context.MODE_PRIVATE)

        val drawer_menu_click : ImageView = view.findViewById(R.id.drawer_menu_click)
        val drawerLayout  : DrawerLayout = view.findViewById(R.id.drawer_layout)
        drawer_menu_click.setOnClickListener {
            drawerLayout.open()
        }

        val navigation_view : NavigationView = view.findViewById(R.id.navigation_view)
        navigation_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(requireContext(), "${it.title}", Toast.LENGTH_SHORT).show()
                R.id.logout ->{
                    localStorge?.edit()?.clear()?.apply()
                    startActivity(Intent(requireContext(),MainActivity::class.java))
                    Toast.makeText(requireContext(), "Logout Successfully!!", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        return view
    }

}