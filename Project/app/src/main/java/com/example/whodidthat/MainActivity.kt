package com.example.whodidthat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peep = Personne("a", "a")
        peep.notes = "asdawdasdwasdwasdwasdwas"
        Personne.savePerson(peep)

        //le bouton change l'activité à MenuCommunication
        val communicationButton = findViewById<Button>(R.id.button1)
        communicationButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuCommunication::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuNotes
        val notesButton = findViewById<Button>(R.id.button2)
        notesButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuNotes::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuCalendrier
        val calendrierButton = findViewById<Button>(R.id.button3)
        calendrierButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuCalendrier::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuReglages
        val reglagesButton = findViewById<Button>(R.id.button4)
        reglagesButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuReglages::class.java)
            startActivity(intent)
        }
    }
}