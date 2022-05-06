package com.example.whodidthat

data class Message (val sender: Personne, val message: String, val time: String, val date: String)

val uMessages = HashMap<Pair<Personne, Personne>, ArrayList<Message>>()