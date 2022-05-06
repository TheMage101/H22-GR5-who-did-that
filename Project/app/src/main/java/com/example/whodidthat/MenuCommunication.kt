package com.example.whodidthat

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

        val tmpList = uMessages[Pair(
            Personne.getUser(0),
            Personne.getUser(1)
        )]

        println(uMessages.get(Pair(Personne.getUser(0), Personne.getUser(1))))

        println("\n\n"+uMessages.isEmpty()+"\n")
        if(tmpList != null) {
            println("\n\ndawsdawd\n")
            messages.adapter = MessageListAdapter(tmpList)
        }
        messages.layoutManager = LinearLayoutManager(this)

        sendButton.setOnClickListener {
            if (textBox.text.isNotEmpty()) {
                val dateAndTime = LocalDateTime.now()
                val formatterTime = DateTimeFormatter.ofPattern("HH.mm")
                val formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val time = dateAndTime.format(formatterTime)
                val date = dateAndTime.format(formatterDate)
                val message = Message(Personne.getCurrentUser(), textBox.text.toString(),
                time, date)
                val tMessageList = uMessages[Pair(
                    Personne.getUser(0),
                    Personne.getUser(1)
                )]

                if (tMessageList != null) {
                    print("wdwdwd")
                    tMessageList.add(message)
                    print(tMessageList.size)
                    uMessages.put(
                        Pair(Personne.getUser(0), Personne.getUser(1)),
                        tMessageList
                    )

                    (messages.adapter as MessageListAdapter).notifyItemInserted(uMessages.size - 1)
                    (messages.adapter as MessageListAdapter).notifyDataSetChanged()
                }
            }
        }
    }
}
