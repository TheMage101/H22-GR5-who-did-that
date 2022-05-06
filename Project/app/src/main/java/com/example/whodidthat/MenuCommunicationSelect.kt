package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuCommunicationSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication_select)

        val recyclerView = findViewById<RecyclerView>(R.id.contactList)
        val errorText = findViewById<TextView>(R.id.noOneMessage)


        val adapter = MessageSelectAdapter(Personne.)
    }
}