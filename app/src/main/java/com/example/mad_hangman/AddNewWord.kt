package com.example.mad_hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView

class AddNewWord : AppCompatActivity() {

    private var inputField: EditText? = null
    private var listViewOfWords: ListView? = null
    private var list: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)
        this.supportActionBar!!.hide()

        inputField = findViewById(R.id.inputField)

    }

    override fun onStart() {
        super.onStart()
        listViewOfWords = this.findViewById(R.id.listOfWords)
        list = Preferences(this).getWords()
        listViewOfWords?.adapter = ListAdapter(this, R.layout.list_view_row, list)

    }

    fun addNewWord(v: View) {
        var cleanedWord = inputField?.text?.split(" ")!![0].toUpperCase()
        var newList = ArrayList<String>()
        for (word in list!!) {
            newList.add(word)
        }
        newList.add(cleanedWord)
        list = newList
        listViewOfWords?.adapter = ListAdapter(this, R.layout.list_view_row, list)
        inputField?.setText("")
        Preferences(this).setNewList(newList)
    }

    fun removeWord(v: View) {
        var selectedWord = v.tag.toString()
        var newList = ArrayList<String>()
        for (word in list!!) {
            if (word != selectedWord)
                newList.add(word)
        }
        list = newList
        listViewOfWords?.adapter = ListAdapter(this, R.layout.list_view_row, list)
        Preferences(this).setNewList(newList)
    }
}
