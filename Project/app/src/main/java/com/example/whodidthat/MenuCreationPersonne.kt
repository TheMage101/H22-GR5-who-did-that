package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.whodidthat.databinding.ActivityMainBinding

class MenuCreationPersonne : AppCompatActivity() {

    //TODO:
    //creer sauvegarde de personne
    //finir l'interface de cretion

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_menu_creation_personne)

        val profilePicture = findViewById<ImageView>(R.id.pfp)
        val nameTextField = findViewById<EditText>(R.id.NameTextInput)
        val ageTextNumber = findViewById<EditText>(R.id.ageTextNumber)
        val buttonCreate = findViewById<Button>(R.id.createButton)

        profilePicture.setOnClickListener{
            //créer l'importation de photo
        }

        //cela verifie si les fields otn été rempli par l'utilisateurs et si oui et que le bouton
        //créer a été clicker alors une Personne est créer
        buttonCreate.setOnClickListener {
            if(nameTextField.text.isNotBlank() && ageTextNumber.text.isNotEmpty()){
                val peep = Personne(nameTextField.text.toString(), ageTextNumber.text.toString())
                peep.savePerson()
            }
            else{
                    if(nameTextField.text.isBlank()){
                        nameTextField.setHintTextColor(resources.getColor(R.color.))
                }
            }
        }
    }

}