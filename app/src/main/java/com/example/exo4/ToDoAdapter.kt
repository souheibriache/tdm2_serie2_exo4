package com.example.exo4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*

class ToDoAdapter (ls : List<ToDo> , cont : Context) : RecyclerView.Adapter<ViewHolder>()  {
    var  list_todo = ls
    var contect = cont
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val ite = layoutInflater.inflate(R.layout.todo_item, parent, false)
        return ViewHolder(ite)
    }

    override fun getItemCount(): Int {
        return  list_todo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.userid_tv.text= list_todo[position].userId.toString()
        holder.itemView.todo_tv.text = list_todo[position].id.toString()
        holder.itemView.title_tv.text = list_todo[position].title
        holder.itemView.state_tv.text = list_todo[position].body
    }
}








class ViewHolder (v: View) : RecyclerView.ViewHolder(v) {
}