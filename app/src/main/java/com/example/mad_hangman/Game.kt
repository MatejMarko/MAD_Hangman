package com.example.mad_hangman

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.random.Random

class Game : AppCompatActivity() {

    //TODO select random word, also when new game buton pressed
    private var wordToGuess: String = ""
    private var wordToDisplay: String = ""
    private var guessingWordTextView: TextView? = null
    private var image: ImageView? = null
    private var strikes = 0
    private var maxStrikes = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        this.supportActionBar!!.hide()

        setWords()

        image = findViewById(R.id.hangmanImage)
        image?.setImageResource(R.drawable.i_1_s)

        guessingWordTextView = findViewById(R.id.guessingWord)
        displayGuessingWord()

    }

    fun letterPressed(v: View) {
        var pressedLetter: Char = v.tag.toString()[0]
        var newWord = ""
        var wrongLetter = true
        for (x in 0 until wordToDisplay.length) {
            when {
                wordToDisplay[x] != '_' -> newWord += wordToDisplay[x]
                wordToGuess[x] == pressedLetter -> {
                    newWord += pressedLetter
                    wrongLetter = false
                }
                else -> {
                    newWord += "_"
                }
            }
        }
        if (wrongLetter) {
            strikes++
            changeHangmanPhoto()
        }
        wordToDisplay = newWord
        displayGuessingWord()
        handlePressedLetter(v.id, wrongLetter)
        if (wordToDisplay == wordToGuess) {
            guessingWordTextView?.setTextColor(Color.GREEN)
            setLettersEnabled(false)
        }
    }

    private fun displayGuessingWord() {
        var dashedWord = ""
        for (x in 0 until wordToDisplay.length - 1) {
            dashedWord += wordToDisplay[x].toString() + " "
        }
        dashedWord += wordToDisplay[wordToDisplay.length - 1]

        guessingWordTextView?.text = dashedWord
    }

    private fun changeHangmanPhoto() {
        when (strikes) {
            1 -> image?.setImageResource(R.drawable.i_2_s)
            2 -> image?.setImageResource(R.drawable.i_3_s)
            3 -> image?.setImageResource(R.drawable.i_4_s)
            4 -> image?.setImageResource(R.drawable.i_5_s)
            5 -> image?.setImageResource(R.drawable.i_6_s)
            6 -> image?.setImageResource(R.drawable.i_7_s)
        }
    }

    private fun handlePressedLetter(letter: Int, wrong: Boolean) {
        var b: Button = findViewById(letter)
        if (!wrong)
            b.setTextColor(Color.GREEN)
        else
            b.setTextColor(Color.RED)
        b.isEnabled = false
        if (strikes == maxStrikes) {
            var displayedWord: TextView = findViewById(R.id.guessingWord)
            displayedWord.setTextColor(Color.RED)
            setLettersEnabled(false)
        }
    }

    fun newGame(v: View) {
        strikes = 0
        image?.setImageResource(R.drawable.i_1_s)
        setWords()
        displayGuessingWord()
        setLettersEnabled(true)
    }

    private fun setLettersEnabled(enable: Boolean) {
        var letterLayout: GridLayout = findViewById(R.id.lettersGrid)
        for (x in 0 until letterLayout.childCount - 1) {
            var child: Button = letterLayout.getChildAt(x) as Button
            child.isEnabled = enable
            if (child.currentTextColor != Color.RED && child.currentTextColor != Color.GREEN)
                child.setTextColor(Color.LTGRAY)
            if (enable) {
                child.setTextColor(Color.BLACK)
                guessingWordTextView?.setTextColor(Color.BLACK)
            }
        }
    }

    private fun setWords() {
        val list: List<String>? = Preferences(this).getWords()
        val size:Int = list?.size!!
        val r = Random.nextInt(0, size-1)
        wordToGuess = list[r]
        wordToDisplay = ""
        for (letter in wordToGuess)
            wordToDisplay += "_"

    }
}
