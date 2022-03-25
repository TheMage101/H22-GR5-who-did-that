package com.example.whodidthat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/*
Tuto pour custom calendar:
https://medium.com/@avi_kr16/creating-a-simple-android-calendar-in-7-steps-fa18a7945350
 */
class MenuCalendrier : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_calendrier)


    }


    override fun onBackPressed() {
        super.onBackPressed()
    }
}