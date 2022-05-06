package com.example.whodidthat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageSelectAdapter(listePersonne: ArrayList<Personne>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var cContext: Context
    lateinit var cListener: onItemClickListener
    var cListePersonne = listePersonne


    interface onItemClickListener(listener: onItemClickListener){
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        cListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_emnu_communication_select_user_layout,
            parent, false
        )
        return userHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = cListePersonne[position]
        (holder as userHolder).bind(user)
    }

    override fun getItemCount(): Int {
        return cListePersonne.size
    }


    class userHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val userName = itemView.findViewById<TextView>(R.id.userNameText)

        fun bind(user: Personne){
            userName.setText(user.name)
        }

        init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }
        }
    }

}
