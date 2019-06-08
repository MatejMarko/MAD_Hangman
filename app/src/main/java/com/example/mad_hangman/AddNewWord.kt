package com.example.mad_hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ListView

class AddNewWord : AppCompatActivity() {

    private var inputField: EditText? = null
    private var listViewOfWords: ListView? = null
    private var list: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)
        this.supportActionBar!!.hide()

        inputField = findViewById(R.id.inputField)

        Preferences(this).getWords()

    }

    override fun onStart() {
        super.onStart()
        listViewOfWords = findViewById(R.id.listOfWords)
        list = Preferences(this).getWords()
        listViewOfWords?.adapter = ListAdapter(this, R.layout.list_view_row, list)

    }

    fun addNewWord(v: View) {
        for (l in list!!) {
            Log.d("ffds", l)
        }
        var cleanedWord = inputField?.text?.split(" ")!![0].toUpperCase()
        Preferences(this).addWord(cleanedWord)
        list = Preferences(this).getWords()
        listViewOfWords?.invalidateViews()
        for (l in list!!) {
            Log.d("ffds", l)
        }
    }

    fun removeWord(v: View) {
        var selectedWord = v.tag.toString()
        Log.d("fssd", selectedWord)
    }
}
