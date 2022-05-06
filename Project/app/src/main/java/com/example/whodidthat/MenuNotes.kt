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

        //recupere les notes de l'utilisateur si il en a
        if (personne.notes.isNotEmpty()) {
            notesText.setText(personne.notes)
        }

    }


    /**
     * sauvegarde les notes de l'utilisateur avant de retourner au menu principal
     */
    override fun onBackPressed() {
        Personne.saveNotes(findViewById<EditText>(R.id.notesText).text.toString())
        finish()
    }
}

