package com.example.notetakingapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.Model.NoteModel
import com.example.notetakingapp.R

class NoteAdapter(private var dataList:ArrayList<NoteModel>):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        var title=item.findViewById<TextView>(R.id.noteTitle)
        var description=item.findViewById<TextView>(R.id.noteDetails)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text= (dataList[position]).title
        holder.description.text= (dataList[position]).description
    }


}