package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        createNewList(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemAnimator: ItemAnimator = DefaultItemAnimator()

        itemAnimator.addDuration = 1000
        itemAnimator.removeDuration = 1000
        recyclerView.itemAnimator = itemAnimator

        fab.setOnClickListener {
            startActivity(Intent(this, AddValueActivity::class.java))
            createNewList(recyclerView)
//            create new list updates view for user not instantly, but after user creates another object
        }
    }

    private fun createNewList(
        recyclerView: RecyclerView
    ) {
        val adapter =
            Recycler_View_Adapter(
                DataBaseHelper(this@MainActivity).getEveryone() as ArrayList<CustomerModel>,
                application
            )

        recyclerView.adapter = adapter
    }
}