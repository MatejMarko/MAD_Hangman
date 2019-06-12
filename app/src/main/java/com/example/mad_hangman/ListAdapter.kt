package com.example.mad_hangman

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, var resource: Int, var items: ArrayList<String>?) :
    ArrayAdapter<String>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null)
        val word: TextView = view.findViewById(R.id.word)
        word.text = items?.get(position)
        val xIcon: ImageView = view.findViewById(R.id.xIcon)
        xIcon.tag = items?.get(position)
        return view
    }

}