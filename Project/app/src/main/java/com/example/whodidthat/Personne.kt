package com.example.whodidthat


val peoples = ArrayList<Personne>()

class Personne(var name: String, var age: String) {

    lateinit var gender: String
    lateinit var description: String
    var notes = ArrayList<String>()
    
    fun savePerson(peep: Personne){
        peoples.add(peep)
    }

    fun loadPerson(){
        //TODO
        //get a user of our choice
    }

    //TODO
    //get the various values we want to get from the wanted user
    //-events
    //-notes
    //-etc...
}
