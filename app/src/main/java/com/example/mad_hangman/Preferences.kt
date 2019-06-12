package com.example.mad_hangman

import android.content.Context
import android.content.SharedPreferences
import java.util.*
import kotlin.collections.HashSet

class Preferences(context: Context) {

    private val KEY = "listOfWords"
    private val preferences: SharedPreferences = context.getSharedPreferences("WORDS", Context.MODE_PRIVATE)

    fun setNewList(list: ArrayList<String>) {
        val editor = preferences.edit()
        editor.putStringSet(KEY, list.toSet())
        editor.apply()
    }

    fun getWords(): ArrayList<String>? {

        var initialSet = preferences.getStringSet(KEY, null)
        if (initialSet == null || initialSet.isEmpty())
            initialWords()

        initialSet = preferences.getStringSet(KEY, null)
        var listOfWords = arrayListOf<String>()
        for (word in initialSet)
            listOfWords.add(word.toUpperCase())
        return listOfWords
    }

    private fun initialWords() {
        var set = HashSet<String>()
        set.add("WEATHER")
        set.add("TOMATOES")
        set.add("BICYLE")
        set.add("PRACTICE")
        set.add("MANAGEMENT")
        set.add("DRINKING")
        set.add("FORECAST")
        set.add("HAMBURGER")
        set.add("TISSUE")
        set.add("MIRROR")
        set.add("SANDWICH")
        val editor = preferences.edit()
        editor.putStringSet(KEY, set.toSet())
        editor.apply()
    }
}