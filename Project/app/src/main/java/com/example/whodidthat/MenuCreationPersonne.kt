package com.example.whodidthat

import android.content.Intent
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

        profilePicture.setOnClickListener {
            //créer l'importation de photo
        }

        //cela verifie si les fields otn été rempli par l'utilisateurs et si oui et que le bouton
        //créer a été clicker alors une Personne est créer
        buttonCreate.setOnClickListener {
            //si tous les field ont été entré la personne est crée et on est déplacé au Main Menu
            if (nameTextField.text.isNotBlank() && ageTextNumber.text.isNotEmpty()) {
                val peep = Personne(nameTextField.text.toString(), ageTextNumber.text.toString())
                peep.savePerson(peep)
                startActivity(Intent(this, MenuPrincipal::class.java))
            } else {
                //si un des text field est vide son hint va mis en rouge
                if (nameTextField.text.isBlank())
                    nameTextField.setHintTextColor(resources.getColor(R.color.red))
                if (ageTextNumber.text.isBlank())
                    ageTextNumber.setHintTextColor(resources.getColor(R.color.red))
            }
        }
    }

}