package com.example.firstapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.loadImage

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var list = mutableListOf<String>()
    lateinit var holder: ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder = holder
        val item = list[position]
        holder.image.loadImage(item)
    }

    fun addItems(items: MutableList<String>) {
        list = items
        notifyDataSetChanged()
    }

    fun addItem(item: String) {
        list.add(item)
        notifyItemInserted(list.lastIndex)
    }

    fun itemRemove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        Log.v("DELETED_POSITION_AT", "$position")
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
    }

}