package com.example.whodidthat

val userList = ArrayList<Personne>()
var currentUser: Int = 0

class Personne(var name: String, var age: String, var pronouns: String, var Occupation: String) {


    lateinit var description: String
    var indexId = 0
    var notes: String = ""
    lateinit var userCommunicatingTo: Personne



    companion object {
        

    /**
     * Utiliser pour sauvegarder un nouvelle utilisateur
     * @param user est la personne a ajouté
     */
        fun saveUser(user: Personne) {
            userList.add(user)
            setUser(userList.size - 1)
            user.indexId = userList.size
            val emptyArray = ArrayList<Message>()

            for (aUser in userList) {
                uMessages.put(Pair(getCurrentUser(), aUser),ArrayList<Message>())
                print(uMessages.get(Pair(getCurrentUser(), aUser)).toString())
                /*
                user1  ->  user2
                user2  -/> u    ser1

                 */
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