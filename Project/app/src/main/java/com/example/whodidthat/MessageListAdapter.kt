package com.example.whodidthat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageListAdapter(messageList: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mContext: Context
    var mMessageList = messageList
    val VIEW_TYPE_MESSAGE_SENT = 1
    val VIEW_TYPE_MESSAGE_RECEIVED = 2
    val VIEW_TYPE_EMPTY = 3

    fun MessageListAdapter(context: Context, messageList: ArrayList<Message>) {
        mContext = context
        mMessageList = messageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.activity_first_person_pov_message,
                parent, false
            )
            return SentMessageHolder(itemView)
        }

        else {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.activity_other_person_message,
                parent, false
            )
            return ReceivedMessageHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = mMessageList.get(position)

        when (holder.getItemViewType()) {
            VIEW_TYPE_MESSAGE_SENT -> {
                (holder as SentMessageHolder).bind(message)
            }
            VIEW_TYPE_MESSAGE_RECEIVED -> {
                (holder as ReceivedMessageHolder).bind(message)
            }
            VIEW_TYPE_EMPTY ->{
            }
        }
    }

    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = mMessageList.get(position)

        if (mMessageList.size >= 1){
            if (message.sender.toString() == Personne.getCurrentUser().toString())
                return VIEW_TYPE_MESSAGE_SENT
            else
                return VIEW_TYPE_MESSAGE_RECEIVED
        }
        return VIEW_TYPE_EMPTY
    }


    class ReceivedMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText = itemView.findViewById<TextView>(R.id.text_message_other)

        val nameText = itemView.findViewById<TextView>(R.id.text_name_other)

        val timeText = itemView.findViewById<TextView>(R.id.text_message_hour_other)
        val dateText = itemView.findViewById<TextView>(R.id.text_message_date_other)

        fun bind(message: Message) {
            nameText.setText(message.sender.name)
            messageText.setText(message.message)
            timeText.setText(message.time)
            dateText.setText(message.date)

        }
    }


    class SentMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val messageText = itemView.findViewById<TextView>(R.id.text_message_me)
        val dateText = itemView.findViewById<TextView>(R.id.text_message_date_me)
        val timeText = itemView.findViewById<TextView>(R.id.text_message_hour_me)

        fun bind(message: Message) {
            messageText.setText(message.message)
            dateText.setText(message.date)
            timeText.setText(message.time)
        }
    }


}

