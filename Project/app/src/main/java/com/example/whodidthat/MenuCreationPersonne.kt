package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MenuCreationPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_creation_personne)

        val nameText = findViewById<EditText>(R.id.editTextPersonName).toString()
        val ageText = findViewById<EditText>(R.id.editTextPersonAge).toString()
        val pronounText = findViewById<EditText>(R.id.editTextPersonPronounsa).toString()
        val titleText = findViewById<EditText>(R.id.editTextTextPersonName4).toString()
        //get la description EditText

        val personne = Personne(nameText, ageText)

    }
}