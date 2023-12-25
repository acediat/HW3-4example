package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter <T: RecyclerView.ViewHolder, D: Any> : RecyclerView.Adapter<T>() {

    protected val items = mutableListOf<D>()

    override fun getItemCount(): Int = items.size

    fun addItem(item: D) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}