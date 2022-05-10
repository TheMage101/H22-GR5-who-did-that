package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MenuCreationPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_creation_personne)

        val nameTextInput = findViewById<EditText>(R.id.editTextPersonName)
        val ageTextInput = findViewById<EditText>(R.id.editTextPersonAge)
        val pronounTextInput = findViewById<EditText>(R.id.editTextPersonPronounsa)
        val titleTextInput = findViewById<EditText>(R.id.editTextPersonOccupation)
        val descriptionTextInput = findViewById<EditText>(R.id.editTextTextMultiLine2)

        val saveButton = findViewById<Button>(R.id.savePersonButton)

        saveButton.setOnClickListener{
            val nameText = nameTextInput.text
            val ageText = ageTextInput.text
            val pronounText = pronounTextInput.text
            val titleText = titleTextInput.text
            val descriptionText = descriptionTextInput.text

            if (nameText.isEmpty() || nameText.isBlank()) {
                var errorName = Snackbar.make(it, "Name can't be empty! Please enter a name.", Snackbar.LENGTH_LONG)
                errorName.show()
            }
            else if (ageText.isEmpty() || ageText.isBlank()) {
                var errorAge = Snackbar.make(it, "Age can't be empty! Please enter an age.", Snackbar.LENGTH_LONG)
                errorAge.show()
            }
            else if (pronounText.isEmpty() || pronounText.isBlank()) {
                var errorPronoun = Snackbar.make(it, "Pronouns can't be empty! Please enter pronouns.", Snackbar.LENGTH_LONG)
                errorPronoun.show()
            }
            else if (titleText.isEmpty() || titleText.isBlank()) {
                var errorTitle = Snackbar.make(it, "Occupation can't be empty! Please enter an occupation.", Snackbar.LENGTH_LONG)
                errorTitle.show()
            } else {
                val newPerson = Personne(nameText.toString(), ageText.toString(), pronounText.toString(), titleText.toString())
                newPerson.description = descriptionText.toString()
                Personne.saveUser(newPerson)
                val intent = Intent(this@MenuCreationPersonne, MenuViewPersonne::class.java)
                startActivity(intent)
            }
        }
    }
}