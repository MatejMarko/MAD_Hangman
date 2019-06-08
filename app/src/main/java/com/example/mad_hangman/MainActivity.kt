package com.example.mad_hangman

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar!!.hide()



    }

    fun play(v: View) {
        val intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun addNewWordScreen(v: View) {
        val intent = Intent(this, AddNewWord::class.java)
        startActivity(intent)
    }

}
