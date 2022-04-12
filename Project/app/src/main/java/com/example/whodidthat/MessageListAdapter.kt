package com.example.whodidthat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageListAdapter(private val messageList: List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mContext: Context
    var mMessageList = messageList
    final val VIEW_TYPE_MESSAGE_SENT = 1
    final val VIEW_TYPE_MESSAGE_RECEIVED = 2

    fun MessageListAdapter(context: Context, messageList: List<Message>) {
        mContext = context
        mMessageList = messageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == VIEW_TYPE_MESSAGE_SENT) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_first_person_pov_message,
            parent, false)
            return SentMessageHolder(itemView)
        }

        //add to it if some error
        // if(viewType == VIEW_TYPE_MESSAGE_RECEIVED)
        //saved line of code temporarily
        else{
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_other_person_message,
            parent, false)
            return ReceivedMessageHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = mMessageList.get(position)

        when (holder.getItemViewType()){
            VIEW_TYPE_MESSAGE_SENT -> {
                (holder as SentMessageHolder).bind(message)
            }
            VIEW_TYPE_MESSAGE_RECEIVED -> {
                (holder as ReceivedMessageHolder).bind(message)
            }
        }
    }

    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun getItemViewType(position: Int): Int{
        val message = mMessageList.get(position)

        if(message.sender.equals(Personne.getCurrentUser()))
            return VIEW_TYPE_MESSAGE_SENT
        else
            return  VIEW_TYPE_MESSAGE_RECEIVED
    }

    class ReceivedMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText = itemView.findViewById<TextView>(R.id.text_message_other)


        val nameText = itemView.findViewById<TextView>(R.id.text_name_other)

        fun bind(message: Message) {
            nameText.setText(message.sender.name)
            messageText.setText(message.message)
        }
    }


    class SentMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val messageText = itemView.findViewById<TextView>(R.id.text_message_me)

        fun bind(message: Message){
            messageText.setText(message.message)
        }
    }




}

