package com.example.whodidthat

val userList = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String, var pronouns: String, var Occupation: String) {


    lateinit var description: String
    val indexId = 0
    var notes: String = ""
    lateinit var userCommunicatingTo: Personne


    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    companion object {

        fun createTestEnvironement() {
            val peep = Personne("a", "a", "f", "f")
            savePerson(peep)
            val e = Personne("e", "e", "f", "f")
            savePerson(e)
            //END

            print("awawdawawdwaaad")
            print(Personne.getUser(0).name)
        }

        fun savePerson(user: Personne) {
            userList.add(user)
            val emptyArray = ArrayList<Message>()
            emptyArray.add(Message(getCurrentUser(), "aw", "1", "1321"))

            for (people in userList) {
                uMessages[Pair(getCurrentUser(), people)] = ArrayList<Message>()
            }
        }

        fun getCurrentUser(): Personne {
            return userList.get(currentUser)
        }

        fun saveNotes(notes: String) {
            getCurrentUser().notes = notes
        }

        fun getUser(index: Int): Personne {
            return userList[index]
        }

        fun setUser(index: Int) {
            currentUser = index
        }

        fun getUserList(): ArrayList<Personne>{
            return userList
        }

    }
}