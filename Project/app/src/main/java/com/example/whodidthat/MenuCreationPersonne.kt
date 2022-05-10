package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MenuCreationPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_creation_personne)

        val nameText = findViewById<EditText>(R.id.editTextPersonName).text.toString()
        val ageText = findViewById<EditText>(R.id.editTextPersonAge).text.toString()
        val pronounText = findViewById<EditText>(R.id.editTextPersonPronounsa).text.toString()
        val titleText = findViewById<EditText>(R.id.editTextPersonOccupation).text.toString()

        val saveButton = findViewById<Button>(R.id.savePersonButton)

        saveButton.setOnClickListener{
            if (nameText.isEmpty() || nameText.isBlank()) {
                var errorName = Snackbar.make(it, "Name can't be empty! Please enter a name.", Snackbar.LENGTH_LONG)
                errorName.show()
            }
            if (ageText.isEmpty() || ageText.isBlank()) {
                var errorAge = Snackbar.make(it, "Age can't be empty! Please enter an age.", Snackbar.LENGTH_LONG)
                errorAge.show()
            }
            if (pronounText.isEmpty() || pronounText.isBlank()) {
                var errorPronoun = Snackbar.make(it, "Pronouns can't be empty! Please enter pronouns.", Snackbar.LENGTH_LONG)
                errorPronoun.show()
            }
            if (titleText.isEmpty() || titleText.isBlank()) {
                var errorTitle = Snackbar.make(it, "Occupation can't be empty! Please enter an occupation.", Snackbar.LENGTH_LONG)
                errorTitle.show()
            }
        }



        //get la description EditText

        val personne = Personne(nameText, ageText, pronounText, titleText)
        val peopleList = Personne.savePerson(personne)

    }
}