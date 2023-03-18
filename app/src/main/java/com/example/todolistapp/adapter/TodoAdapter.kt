package com.example.todolistapp.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.example.todolistapp.R
import com.example.todolistapp.Todo

class TodoAdapter(var activity: Activity, private var items:ArrayList<Todo>):BaseAdapter() {
    // The task of this class is to connect the layout we created as custom to this class and to call the views here and to do the operations.
    private class  ViewHolder(row:View?){
        // Here we define all the videos that we use in the row view that we created as custom.
        var title:TextView?=null
        var deleteButton:ImageButton?=null
        init {
            this.title=row?.findViewById<TextView>(R.id.title)
            this.deleteButton=row?.findViewById<ImageButton>(R.id.delete)
        }
    }
    override fun getCount(): Int {
        // Return the total number of elements of the list
        return  items.size
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Todo {
        // Return every item in listview as a model
        return items[position]
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        // It freezes the id of the item in listview
        return  position.toLong()
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // We connect the custom layout we created here to the view holder. Because we defined views in view holder
        val view:View?
        val viewHolder:ViewHolder
        if (convertView==null){
            val inflater= activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view=inflater.inflate(R.layout.list_item,null)
            viewHolder=ViewHolder(view)
            view.tag=viewHolder
        }else{
            view=convertView
            viewHolder=view.tag as ViewHolder
        }
        viewHolder.title?.text=items[position].title
        viewHolder.deleteButton?.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }
        return  view as View
        TODO("Not yet implemented")

    }
}