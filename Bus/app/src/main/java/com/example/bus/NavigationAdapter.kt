package com.example.bus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_nav_item.view.*

class NavigationAdapter (private var items: ArrayList<NavigationItemModel>,
                         private val onItemClick: (NavigationItemModel) -> Unit
                        ): RecyclerView.Adapter<NavigationAdapter.NavigationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NavigationViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_nav_item, parent, false))

    override fun onBindViewHolder(holder: NavigationViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    inner class NavigationViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(item: NavigationItemModel){
            view.navigation_title.text = item.title
            view.navigation_icon.setImageResource(item.icon)

            view.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}