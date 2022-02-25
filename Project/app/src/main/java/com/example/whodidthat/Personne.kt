package com.example.whodidthat


val peoples = ArrayList<Personne>()

class Personne(var name: String, var age: String) {

    lateinit var gender: String
    lateinit var description: String
    
    
    fun savePerson(peep: Personne){
        peoples.add(peep)
    }
    
    
}
