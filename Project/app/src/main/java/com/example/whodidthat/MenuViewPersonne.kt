package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MenuViewPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_personne)

        var user = Personne.getCurrentUser()

        var textOfName: TextView = findViewById(R.id.textPersonName)
        textOfName.text = (user.name)
        var textOfAge: TextView = findViewById(R.id.textPersonAge)
        textOfAge.text = (user.age)
        var textOfPronouns: TextView = findViewById(R.id.textPersonPronouns)
        textOfPronouns.text = (user.pronouns)
        var textOfOccupation: TextView = findViewById(R.id.textPersonOccupation)
        textOfOccupation.text = (user.Occupation)
        var textOfMoreInfo: TextView = findViewById(R.id.textMoreInfo)
        textOfMoreInfo.text = (user.description)

        val modifyButton = findViewById<Button>(R.id.modifyPersonButton)
        modifyButton.setOnClickListener {
            val intent = Intent(this@MenuViewPersonne, MenuCreationPersonne::class.java)
            startActivity(intent)
        }
        val finishedButton = findViewById<Button>(R.id.finishButton)
        finishedButton.setOnClickListener {
            val intent = Intent(this@MenuViewPersonne, MainActivity::class.java)
            startActivity(intent)
        }
    }
}