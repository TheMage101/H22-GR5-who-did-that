package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuChoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_person_choosing)


        val addPersonButton = findViewById<Button>(R.id.ButtonAddPerson)
        addPersonButton.setOnClickListener {
            val intent = Intent(this@MenuChoose, MenuCreationPersonne::class.java)
            startActivity(intent)
        }

        val person1bouton = findViewById<Button>(R.id.person1Button)
        person1bouton.setOnClickListener {
            val intent = Intent(this@MenuChoose, MainActivity::class.java)
            startActivity(intent)
        }

        val person2bouton = findViewById<Button>(R.id.person2Button)
        person2bouton.setOnClickListener {
            val intent = Intent(this@MenuChoose, MainActivity::class.java)
            startActivity(intent)
        }
    }
}