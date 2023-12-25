package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemElementBinding

class ElementsAdapter : AbstractAdapter<ElementsAdapter.ElementsViewHolder, Element>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElementsViewHolder(ItemElementBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ElementsViewHolder, position: Int) = holder.bind(items[position])

    class ElementsViewHolder(
        private val binding: ItemElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Element) {
            binding.viewItemName.text = item.name
            binding.viewItemDescription.text = item.description
        }
    }
}