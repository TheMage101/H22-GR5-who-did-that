package com.example.whodidthat

data class Message (val sender: Personne, val message: String)
val uMessages = HashMap<Pair<String, String>, ArrayList<Message>>()