package com.example.whodidthat

val peoples = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String) {

    lateinit var gender: String
    lateinit var description: String
    var notes: String = ""
    var messages = HashMap<Pair<String, String>, List<Message>>()

    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    init {

        for(people in peoples) {
            people.messages.put(Pair(name, people.name), ArrayList())
        }

    }

    companion object {

        fun savePerson(peep: Personne) {
            peoples.add(peep)
        }

        fun getCurrentUser(): Personne {
            return peoples[currentUser]
        }

        fun saveNotes(notes: String) {
            getCurrentUser().notes = notes
        }

        fun getUser(index: Int): Personne{
            return peoples.get(index)
        }
    }
}