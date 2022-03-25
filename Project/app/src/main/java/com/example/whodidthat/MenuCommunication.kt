package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView

class MenuCommunication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication)
        val messages = findViewById<RecyclerView>(R.id.messages)

        

    }
}