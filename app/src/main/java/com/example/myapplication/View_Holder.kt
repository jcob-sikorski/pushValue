package com.example.myapplication

import android.view.View
import android.widget.Button
import android.widget.ImageView

import android.widget.TextView

import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView


data class View_Holder(
    var itemView: View,
    var cv: CardView,
    var title: TextView,
    var imageView: ImageView,
    var deleteButton: Button


) : RecyclerView.ViewHolder(itemView) {
}