package com.example.whodidthat

val userList = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String, var pronouns: String, var Occupation: String) {


    lateinit var description: String
    var indexId = 0
    var notes: String = ""
    lateinit var userCommunicatingTo: Personne


    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param peep est la personne a ajouté
     */

    companion object {

        fun createTestEnvironement() {
            val a = Personne("a", "a", "f", "f")
            saveUser(a)
            val e = Personne("e", "e", "f", "f")
            saveUser(e)
            //END
        }

        fun saveUser(user: Personne) {
            userList.add(user)
            setUser(userList.size - 1)
            user.indexId = userList.size
            val emptyArray = ArrayList<Message>()

            for (aUser in userList) {
                uMessages[Pair(getCurrentUser(), aUser)] = emptyArray
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

        fun getUserList(): ArrayList<Personne> {
            return userList
        }

    }
}