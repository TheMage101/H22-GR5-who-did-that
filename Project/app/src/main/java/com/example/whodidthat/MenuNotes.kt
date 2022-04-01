package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MenuNotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_notes)

        val notesText = findViewById<EditText>(R.id.notesText)

        var personne = Personne.getCurrentUser()

        if (personne.notes.isNotEmpty()) {
            notesText.setText(personne.notes)
        }

    }



    override fun onBackPressed() {
        Personne.saveNotes(findViewById<EditText>(R.id.notesText).text.toString())
        finish()
    }
}

