package com.example.whodidthat

val peoples = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String) {

    lateinit var gender: String
    lateinit var description: String
    var notes: String = ""


    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    init {
        print("E")
        for(people in peoples) {
            val tmpList = ArrayList<Message>()
            tmpList.add(Message(getCurrentUser(), "awdad"))
            uMessages.put(Pair(name, people.name), tmpList)

        }

    }

    companion object {

        fun createTestEnvironement(){
            val peep = Personne("a", "a")
            peep.notes = "asdawdasdwasdwasdwasdwas"
            savePerson(peep)
            val e = Personne("e", "e")
            Personne.savePerson(e)
            //END

            print("awawdawawdwaaad")
            print(Personne.getUser(0).name)
        }
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