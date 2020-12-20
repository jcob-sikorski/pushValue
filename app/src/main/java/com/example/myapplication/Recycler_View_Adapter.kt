package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout.view.*


class Recycler_View_Adapter(
    var list: List<CustomerModel>,
    var context: Context
) :
    RecyclerView.Adapter<View_Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View_Holder {
        //Inflate the layout, initialize the View Holder
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)

        var holder = View_Holder(v.rootView, v.cardView, v.title, v.imageView)
        return holder
    }

    override fun onBindViewHolder(holder: View_Holder, position: Int) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.text = list[position].getName()
    }

    override fun getItemCount(): Int {
        //returns the number of elements the RecyclerView will display
        return list.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    // Insert a new item to the RecyclerView on a predefined position
    fun insert(position: Int, data: CustomerModel) {
        list.toMutableList().add(position, data)
        notifyItemInserted(position)
    }

    // Remove a RecyclerView item containing a specified Data object
    fun remove(data: CustomerModel?) {
        val position = list.indexOf(data)
        list.toMutableList().removeAt(position)
        notifyItemRemoved(position)
    }
}
