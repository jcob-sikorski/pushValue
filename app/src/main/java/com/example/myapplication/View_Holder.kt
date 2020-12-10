package com.example.myapplication

import android.R
import android.view.View
import android.widget.ImageView

import android.widget.TextView

import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView


data class View_Holder(
    var itemView: View,
    var cv: CardView,
    var title: TextView,
    var description: TextView,
    var imageView: ImageView


) : RecyclerView.ViewHolder(itemView) {
/*
var cv: CardView
var title: TextView
var description: TextView
var imageView: ImageView
init {
cv = itemView.findViewById(R.id.cardView)
title = itemView.findViewById(R.id.title)
description = itemView.findViewById(R.id.description)
imageView = itemView.findViewById(R.id.imageView) as ImageView
}
*/
}