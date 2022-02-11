package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whodidthat.databinding.ActivityMainBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)



    }
}