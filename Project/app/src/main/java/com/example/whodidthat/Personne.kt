package com.example.whodidthat


val peoples = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String) {

    lateinit var gender: String
    lateinit var description: String
    lateinit var notes: String

    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    companion object {

        fun savePerson(peep: Personne) {
            peoples.add(peep)
        }

        fun loadPerson() {
            //TODO
            //get a user of our choice
        }


        fun saveNotes(notes: String) {
            getCurrentUser().notes = notes
        }


        fun getCurrentUser(): Personne {
            return peoples[currentUser]
        }

    }
    //TODO
    //get the various values we want to get from the wanted user
    //-events
    //-notes
    //-etc...
}
