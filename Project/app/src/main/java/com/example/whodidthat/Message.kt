package com.example.whodidthat

/**
 * Est un data class qui contient
 * le sender
 * le message
 * l'heure
 * et la date
 * qu'un message a été envoyé
 */
data class Message (val sender: Personne, val message: String, val time: String, val date: String)

/**
 * est un hash map qui contient les messsages des utilisateur
 * donc pour deux utilisateurs le hashmap va contenir un arrayList contenant leurs messages
 */
val uMessages = HashMap<Pair<Personne, Personne>, ArrayList<Message>>()