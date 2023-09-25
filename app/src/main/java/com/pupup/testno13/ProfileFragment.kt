package com.pupup.testno13

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ProfileFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        val localStorage =activity?.getSharedPreferences("user", Context.MODE_PRIVATE)

        val username = localStorage?.getString("username","Username Not Found")
        val phone = localStorage?.getString("phone","Phone Not Found")
        val password = localStorage?.getString("password","Password Not Found")

        val get_username : TextView = view.findViewById(R.id.get_username)
        get_username.text = username.toString()
        val get_phone : TextView = view.findViewById(R.id.get_phone)
        get_phone.text = phone.toString()
        val get_pass : TextView = view.findViewById(R.id.get_pass)
        get_pass.text = password.toString()
        return view
    }




}