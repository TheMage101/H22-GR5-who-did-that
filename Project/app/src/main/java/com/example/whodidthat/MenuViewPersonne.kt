package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MenuViewPersonne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_personne)

        var user = Personne.getCurrentUser();

        var textOfVewPersonne = findViewById<TextView>(R.id.textPersonName)
        textOfVewPersonne.setText("indnind")

        var textFromCreation = findViewById<EditText>(R.id.editTextPersonName)




    }
}