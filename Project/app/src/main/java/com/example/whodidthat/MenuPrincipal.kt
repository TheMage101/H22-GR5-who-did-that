package com.example.whodidthat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whodidthat.databinding.ActivityMainBinding

class MenuPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {

            startActivity(Intent(this, MenuNotes::class.java))

        }

        binding.addUser.setOnClickListener {

            val user = Personne("BPB", "1100")
            user.description = "a"
            user.gender = "awda"
            user.notes = ""
            Personne.savePerson(user)

        }
    }
}