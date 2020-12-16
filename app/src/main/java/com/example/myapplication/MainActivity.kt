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

//        val data: List<Data> = fill_with_data()

        val data: MutableList<Data> = ArrayList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = Recycler_View_Adapter(data, application)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemAnimator: ItemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = 1000
        itemAnimator.removeDuration = 1000
        recyclerView.itemAnimator = itemAnimator

        fab.setOnClickListener {
            startActivity(Intent(this, AddValueActivity::class.java))

//            val dataBaseHelper =  DataBaseHelper(this@MainActivity)
        }
    }


//    fun fill_with_data(): List<Data> {
//
//        TODO()
////        val data: MutableList<Data> = ArrayList()
//
////        val database = getSharedPreferences("database", Context.MODE_PRIVATE)
//
////        data.add(
////            Data(
////                "Batman vs Superman",
////                "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "X-Men: Apocalypse",
////                "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "Captain America: Civil War",
////                "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "Kung Fu Panda 3",
////                "After reuniting with his long-lost father, Po  must train a village of pandas",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "Warcraft",
////                "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "Alice in Wonderland",
////                "Alice in Wonderland: Through the Looking Glass ",
////                R.drawable.ic_action_movie
////            )
////        )
////        data.add(
////            Data(
////                "Alice in Wonderland",
////                "Alice in Wonderland: Through the Looking Glass ",
////                R.drawable.ic_action_movie
////            )
////        )
////        return data
//    }
}