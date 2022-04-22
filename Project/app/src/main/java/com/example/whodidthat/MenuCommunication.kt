package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MenuCommunication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_communication)
        val messages = findViewById<RecyclerView>(R.id.messages)
        val sendButton = findViewById<Button>(R.id.button_send)
        val textBox = findViewById<EditText>(R.id.editTextInput)

        val tmpList = uMessages[Pair(
            Personne.getCurrentUser().name,
            Personne.getUser(1).name
        )]

        println("\n\n"+uMessages.isNullOrEmpty()+"eeeee\n")
        if(!tmpList.isNullOrEmpty()) {
            println("\n\ndawsdawd\n")
            messages.adapter = MessageListAdapter(tmpList)
        }
        messages.layoutManager = LinearLayoutManager(this)

        sendButton.setOnClickListener {
            if (textBox.text.isNotEmpty()) {
                val message = Message(Personne.getCurrentUser(), textBox.text.toString())
                val tMessageList = uMessages[Pair(
                    Personne.getCurrentUser().name,
                    Personne.getUser(1).name
                )]

                if (tMessageList != null) {
                    print("wdwdwd")
                    tMessageList.add(message)
                    print(tMessageList.size)
                    uMessages.put(
                        Pair(Personne.getCurrentUser().name, Personne.getUser(1).name),
                        tMessageList
                    )

                    (messages.adapter as MessageListAdapter).notifyItemInserted(uMessages.size - 1)
                }
            }
        }
    }

    fun generateList(size: Int): ArrayList<Message> {
        val list = ArrayList<Message>()
        val r = Random

        for (i in 0..size) {
            when (r.nextInt(2)) {
                0 -> {
                    val message = Message(Personne.getCurrentUser(), "a")
                    list.add(message)
                }
                1 -> {
                    val message = Message(Personne.getUser(1), "e")
                    list.add(message)
                }
            }
        }

        return list
    }
}
