package com.example.whodidthat

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT, " +
                AGE_COL + " TEXT, " +
                DESCRITPION_COL + "TEXT, " +
                NOTES_COL + "TEXT" + ")")
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPerson(name: String, age: String, description: String, notes: String) {
        val values = ContentValues()

        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
        values.put(DESCRITPION_COL, description)
        values.put(NOTES_COL, notes)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }


    @SuppressLint("Range")
    fun getUsers(): List<Personne> {
        val userList: ArrayList<Personne> = ArrayList<Personne>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor:Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        } catch(e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var userName: String
        var userAge: String
        var userDescription: String
        var userNotes: String

        if(cursor.moveToFirst()){
            do{
                userName = cursor.getString(cursor.getColumnIndex("name"))
                userAge = cursor.getString(cursor.getColumnIndex("age"))
                userDescription = cursor.getString(cursor.getColumnIndex("descritpion"))
                userNotes = cursor.getString(cursor.getColumnIndex("notes"))

                val user = Personne(userName, userAge, "e", "e")
                user.description = userDescription
                user.notes = userNotes

                userList.add(user)

            }while(cursor.moveToNext())
        }
        return userList
    }

    companion object {

        //c'est le nom de la database
        private val DATABASE_NAME = "UTILISATEURS"

        //c'est la version de la database
        private val DATABASE_VERSION = 1

        //c'est le nom de la table
        val TABLE_NAME = "PERSONNE"

        val ID_COL = "id"

        val NAME_COL = "name"

        val AGE_COL = "age"

        val DESCRITPION_COL = "description"

        val NOTES_COL = "notes"

    }
}