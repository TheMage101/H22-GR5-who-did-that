package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.whodidthat.databinding.ActivityMainBinding

class MenuPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peep = Personne("a", "a")
        Personne.savePerson(peep)

        //le bouton change l'activité à MenuCommunication
        val communicationButton = findViewById<Button>(R.id.button1)
        communicationButton.setOnClickListener {
            val intent = Intent(this@MenuPrincipal, MenuCommunication::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuNotes
        val notesButton = findViewById<Button>(R.id.button2)
        notesButton.setOnClickListener {
            val intent = Intent(this@MenuPrincipal, MenuNotes::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuCalendrier
        val calendrierButton = findViewById<Button>(R.id.button3)
        calendrierButton.setOnClickListener {
            val intent = Intent(this@MenuPrincipal, MenuCalendrier::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuReglages
        val reglagesButton = findViewById<Button>(R.id.button4)
        notesButton.setOnClickListener {
            val intent = Intent(this@MenuPrincipal, MenuReglages::class.java)
            startActivity(intent)
        }

    }
}