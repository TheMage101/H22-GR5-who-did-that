package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = Personne.getCurrentUser();

        var textOfWelcome: TextView = findViewById(R.id.viewNameCurrentUser)
        textOfWelcome.text = (user.name)

        //le bouton change l'activité à MenuCommunication
        val communicationButton = findViewById<Button>(R.id.button1)
        communicationButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuCommunicationSelect::class.java)
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

        //le bouton change l'activité à MenuVote
        val voteButton = findViewById<Button>(R.id.button5)
        voteButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuVote::class.java)
            startActivity(intent)
        }

        //le bouton change l'activité à MenuContactUs
        val contactUsButton = findViewById<Button>(R.id.button6)
        contactUsButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuContactUs::class.java)
            startActivity(intent)
        }

        val switchingButton = findViewById<Button>(R.id.switchButton)
        switchingButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuChoose::class.java)
            startActivity(intent)
        }

        val viewPersonButton = findViewById<Button>(R.id.viewProfileButton)
        viewPersonButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuViewPersonne::class.java)
            startActivity(intent)
        }
    }


}
