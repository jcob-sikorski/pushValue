package com.example.myapplication

import android.text.Editable

data class CustomerModel(
    val id: Long,
    val name: Editable? = null
)