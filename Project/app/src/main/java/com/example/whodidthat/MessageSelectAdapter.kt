package com.example.whodidthat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageSelectAdapter(listePersonne:ArrayList<Personne>, private val onItemClick: (position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var cListePersonne = listePersonne


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_menu_communication_select_user_layout,
            parent, false
        )
        return userHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = cListePersonne.get(position)
        (holder as userHolder).bind(user)
    }

    override fun getItemCount(): Int {
        print(cListePersonne.size)
        return cListePersonne.size
    }



    class userHolder(itemView: View, private val onItemClick: (position: Int) -> Unit): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val userName = itemView.findViewById<TextView>(R.id.userNameText)
        fun bind(user: Personne){
            userName.setText(user.name)
        }

        init {
            itemView.setOnClickListener(this)
            }

        override fun onClick(v: View) {
            val position = adapterPosition
            onItemClick(position)
        }

    }

}
