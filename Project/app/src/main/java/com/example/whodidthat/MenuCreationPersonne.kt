package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MenuCreationPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_creation_personne)

        val nameText = findViewById<EditText>(R.id.editTextPersonName)
        val ageText = findViewById<EditText>(R.id.editTextPersonAge)
        val pronounText = findViewById<EditText>(R.id.editTextPersonPronounsa)
        val titleText = findViewById<EditText>(R.id.editTextTextPersonName4)
        //get la description EditText


    }
}