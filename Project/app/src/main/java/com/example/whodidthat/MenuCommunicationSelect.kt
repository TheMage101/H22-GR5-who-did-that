package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuCommunicationSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication_select)

        val recyclerView = findViewById<RecyclerView>(R.id.contactList)


        val mAdapter = MessageSelectAdapter(Personne.getUserList()) { position -> onItemClick(position) }

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }

    /**
     * Est la methode qui va definir ce qu'il va se passer lorsu'on click sur l'un des items
     */
    private fun onItemClick(position: Int){
        val selectedUser = Personne.getUserList()[position]
        Personne.getCurrentUser().userCommunicatingTo = selectedUser

        val intent = Intent(this, MenuCommunication::class.java)
        startActivity(intent)
    }
}