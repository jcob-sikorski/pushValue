package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout.view.*


class Recycler_View_Adapter(
    var list: MutableList<CustomerModel>,
    var context: Context
) :
    RecyclerView.Adapter<View_Holder>() {

    companion object DeletedItem {
        var deletedItem: CustomerModel? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View_Holder {
        //Inflate the layout, initialize the View Holder
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)

        return View_Holder(v.rootView, v.cardView, v.title, v.imageView, v.deleteButton)
    }

    override fun onBindViewHolder(holder: View_Holder, position: Int) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.text = list[position].getName()

        holder.deleteButton.setOnClickListener(View.OnClickListener {
            val theRemovedItem: CustomerModel = list[position]

            // remove your item from data base
            list.removeAt(position) // remove the item from list
            notifyItemRemoved(position) // notify the adapter about the removed item
            notifyItemRangeChanged(position, itemCount)

            deletedItem = theRemovedItem
            val dataBaseHelper = DataBaseHelper(context.applicationContext)

            dataBaseHelper.deleteOne(theRemovedItem)

            Toast.makeText(context.applicationContext, "Deleted $theRemovedItem", Toast.LENGTH_SHORT).show()
        })
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
