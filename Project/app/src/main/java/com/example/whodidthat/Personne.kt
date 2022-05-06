package com.example.whodidthat

val peoples = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String) {

    lateinit var pronouns: String
    lateinit var description: String
    val indexId = 0
    var notes: String = ""


    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    companion object {

        fun createTestEnvironement() {
            val peep = Personne("a", "a")
            savePerson(peep)
            val e = Personne("e", "e")
            savePerson(e)
            //END

            print("awawdawawdwaaad")
            print(Personne.getUser(0).name)
        }

        fun savePerson(peep: Personne) {
            peoples.add(peep)

            for (people in peoples) {
                uMessages[Pair(getCurrentUser(), people)] = ArrayList<Message>()
            }
        }

        fun getCurrentUser(): Personne {
            return peoples.get(currentUser)
        }

        fun saveNotes(notes: String) {
            getCurrentUser().notes = notes
        }

        fun getUser(index: Int): Personne {
            return peoples[index]
        }

        fun setUser(index: Int) {
            currentUser = index
        }

        fun getUserList(): ArrayList<Personne>{
            return peoples
        }
    }
}