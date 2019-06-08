package com.example.mad_hangman

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import java.util.*
import kotlin.collections.HashSet

class Preferences(context: Context) {

    private val KEY = "listOfWords"
    private val preferences: SharedPreferences = context.getSharedPreferences("WORDS", Context.MODE_PRIVATE)

    fun addWord(newWord: String) {
        val setOfWords = preferences.getStringSet(KEY, null)
        setOfWords.add(newWord.toUpperCase())
        val editor = preferences.edit()
        editor.putStringSet(KEY, setOfWords)
        editor.apply()
    }

    fun getWords(): List<String>? {
        var listOfWords = arrayListOf<String>()
        for (word in preferences.getStringSet(KEY, null))
            listOfWords.add(word.toUpperCase())
        return listOfWords
    }
}