package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MenuCreationPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_creation_personne)

        val nameText = findViewById<EditText>(R.id.editTextPersonName).text.toString()
        val ageText = findViewById<EditText>(R.id.editTextPersonAge).text.toString()
        val pronounText = findViewById<EditText>(R.id.editTextPersonPronounsa).text.toString()
        val titleText = findViewById<EditText>(R.id.editTextPersonOccupation).text.toString()



        //get la description EditText

        val personne = Personne(nameText, ageText, pronounText, titleText)
        val peopleList = Personne.savePerson(personne)

    }
}