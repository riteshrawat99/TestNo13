package com.pupup.testno13

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.Toolbar

class OptionMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)



//   val tool_bar :androidx.appcompat.widget.Toolbar= findViewById(R.id.tool_bar)
//        setSupportActionBar(tool_bar)

        val show_popup : Button = findViewById(R.id.popup_menu_btn)
        show_popup.setOnClickListener {
            val popUp = PopupMenu(this@OptionMenuActivity,show_popup)
            popUp.menuInflater.inflate(R.menu.popup_menu,popUp.menu)
            popUp.show()

            popUp.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.sunday -> Toast.makeText(this@OptionMenuActivity, "${it.title}", Toast.LENGTH_SHORT).show()
                    R.id.monday -> Toast.makeText(this@OptionMenuActivity, "${it.title}", Toast.LENGTH_SHORT).show()
                    R.id.tuesday -> Toast.makeText(this@OptionMenuActivity, "${it.title}", Toast.LENGTH_SHORT).show()
                    R.id.wednesday -> Toast.makeText(this@OptionMenuActivity, "${it.title}", Toast.LENGTH_SHORT).show()
                }
                true
            }
        }

        val listView : ListView = findViewById(R.id.listView)
        val dayList = arrayOf("Sunday","Monday","Tuesday","Wendnesday")
        listView.adapter = ArrayAdapter(this@OptionMenuActivity,android.R.layout.simple_list_item_1,dayList)

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Selecte Below Item")
        menu.add(0,v!!.id,0,"Sunday")
        menu.add(0,v!!.id,0,"Monday")
        menu.add(0,v!!.id,0,"Tuesday")
        menu.add(0,v!!.id,0,"Wednesday")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(item.title == "Sunday")
        {
            Toast.makeText(this@OptionMenuActivity, "${item.title}", Toast.LENGTH_SHORT).show()
        }else if(item.title == "Monday")
        {
            Toast.makeText(this@OptionMenuActivity, "${item.title}", Toast.LENGTH_SHORT).show()
        } else if(item.title == "Tuesday")
        {
            Toast.makeText(this@OptionMenuActivity, "${item.title}", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@OptionMenuActivity, "${item.title}", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}