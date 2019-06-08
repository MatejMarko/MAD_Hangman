package com.example.mad_hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AddNewWord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)
        this.supportActionBar!!.hide()
        
    }
}
