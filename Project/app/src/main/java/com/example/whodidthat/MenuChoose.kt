package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuChoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_person_choosing)


        val addPersonButton = findViewById<Button>(R.id.ButtonAddPerson)
        addPersonButton.setOnClickListener {
            val e = Personne("e", "1", "a", "yes")
            val a = Personne("a", "2", "e", "no")
            Personne.saveUser(e)
            Personne.saveUser(a)
            println(Personne.getUser(0).name)
            println(Personne.getUser(1).name)
        }


        val createPerson = findViewById<Button>(R.id.buttonCreate)
        createPerson.setOnClickListener {
            val intent = Intent(this@MenuChoose, MenuCreationPersonne::class.java)
            startActivity(intent)
        }

        val mAdapter = MessageSelectAdapter(Personne.getUserList()) { position -> onItemClick(position) }

        val recyclerView = findViewById<RecyclerView>(R.id.userDisplayList)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun onItemClick(position: Int){
        Personne.setUser(position)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}