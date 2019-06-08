package com.example.mad_hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var word: String = "Zemljevid"
    var guessingWord: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar!!.hide()

        var image: ImageView = findViewById(R.id.hangmanImage)
        image.setImageResource(R.drawable.i_1)

        guessingWord = findViewById(R.id.guessingWord)
        setInitialWord()

    }

    //TODO to dobro razmisli
    fun letterPressed(v: View) {
        var pressedLetter: Char = v.tag.toString()[0]
        var newWord = ""
        for (x in 0 until word.length - 1) {
            if (word[x] == pressedLetter && word[x] != '_') {
                newWord += pressedLetter
            } else {
                newWord += "_ "
            }
        }
        guessingWord?.text = newWord

    }

    private fun setInitialWord() {
        var dashedWord = ""
        for (x in 0 until word.length-1) {
            dashedWord += "_ "
        }
        dashedWord += "_"

        guessingWord?.text = dashedWord
    }
}
