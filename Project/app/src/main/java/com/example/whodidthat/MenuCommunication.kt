package com.example.whodidthat

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class MenuCommunication : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication)
        val messages = findViewById<RecyclerView>(R.id.messages)
        val sendButton = findViewById<Button>(R.id.button_send)
        val textBox = findViewById<EditText>(R.id.editTextInput)

        /**
         * Ramenene l'utilisateur au meu principal
         */
        val goBackButton = findViewById<Button>(R.id.goingBackToList)
        goBackButton.setOnClickListener {
            val intent = Intent(this@MenuCommunication, MenuCommunicationSelect::class.java)
            startActivity(intent)
        }

        /**
         * se bouton permet de switch l'utilisateur qui est présentement utilisé
         */
        val switchButton = findViewById<Button>(R.id.messagesSwitchButton)
        switchButton.setOnClickListener {
            val intent = Intent(this@MenuCommunication, MenuChoose::class.java)
            startActivity(intent)
        }

        /**
         * Ce bouton permer d'amener l'utilisateur à la visualisation de son profil
         */
        val profileButton = findViewById<Button>(R.id.messagesProfileButton)
        profileButton.setOnClickListener {
            val intent = Intent(this@MenuCommunication, MenuViewPersonne::class.java)
            startActivity(intent)
        }

        var pair: Pair<Personne, Personne>


        //cette liste récupere les messages de 2 users
        var tmpList = uMessages[Pair(
            Personne.getCurrentUser(),
            Personne.getCurrentUser().userCommunicatingTo
        )]

        // si tmpList est null cela veut dire que les valeurs des clés
        // sont inversés
        if (tmpList == null) {
            pair =
                Pair(
                    Personne.getCurrentUser().userCommunicatingTo,
                    Personne.getCurrentUser()
                )
        } else {
            pair =
                Pair(
                    Personne.getCurrentUser(),
                    Personne.getCurrentUser().userCommunicatingTo
                )
        }

        tmpList = uMessages.get(pair)


        if (tmpList != null)
            messages.adapter = MessageListAdapter(tmpList)

        messages.layoutManager = LinearLayoutManager(this)

         //envoie le message si le case texte n'est pas vide
        sendButton.setOnClickListener {
            if (textBox.text.isNotEmpty()) {
                val dateAndTime = LocalDateTime.now()
                val formatterTime = DateTimeFormatter.ofPattern("HH.mm")
                val formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val time = dateAndTime.format(formatterTime)
                val date = dateAndTime.format(formatterDate)
                val message = Message(
                    Personne.getCurrentUser(), textBox.text.toString(),
                    time, date
                )


                if (tmpList != null) {
                    tmpList.add(message)
                    uMessages.put(pair, tmpList)
                }

                if (tmpList != null) {
                    if (tmpList.isEmpty())
                        (messages.adapter as MessageListAdapter).notifyItemInserted(0)
                    else
                        (messages.adapter as MessageListAdapter).notifyItemInserted(uMessages.size - 1)
                }
                (messages.adapter as MessageListAdapter).notifyDataSetChanged()
                textBox.text.clear()
            }
        }
    }
}
