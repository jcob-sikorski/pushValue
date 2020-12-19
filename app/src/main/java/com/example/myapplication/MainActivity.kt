package com.example.myapplication

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.util.LogPrinter
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val globalVar: MutableList<Data> = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = Recycler_View_Adapter(MainActivity.Companion.globalVar, application)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemAnimator: ItemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = 1000
        itemAnimator.removeDuration = 1000
        recyclerView.itemAnimator = itemAnimator

        fab.setOnClickListener {
            startActivity(Intent(this, AddValueActivity::class.java))

            val dataBaseHelper =  DataBaseHelper(this@MainActivity)

            val everyone = dataBaseHelper.getEveryone()

            Toast.makeText(this@MainActivity, everyone.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}