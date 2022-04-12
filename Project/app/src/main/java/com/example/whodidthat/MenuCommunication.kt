package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MenuCommunication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication)
        val messages = findViewById<RecyclerView>(R.id.messages)

        val messageList = generateList(20)

        messages.adapter = MessageListAdapter(messageList)
        messages.layoutManager = LinearLayoutManager(this)

    }

    fun generateList(size: Int): List<Message>{
        val list = ArrayList<Message>()
        val r = Random

        for(i in 0..size){
            when(r.nextInt(2)){
                0 -> {
                    val message = Message(Personne.getCurrentUser(), "a")
                    list.add(message)
                }
                1-> {
                    val message = Message(Personne.getUser(1), "e")
                    list.add(message)
                }
            }
        }

        return list
    }
}
