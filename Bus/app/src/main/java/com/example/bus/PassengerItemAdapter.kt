package com.example.bus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class PassengerItemAdapter(
    private val items: List<Item> = listOf(),
    private val onItemClick: (Item) -> Unit
) : RecyclerView.Adapter<PassengerItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_passenger_item, parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(item: Item){
            view.imageView.setImageResource(item.image)
            view.bus_name.text = item.name
            view.bus_number.text = item.number
            view.seats_number.text = item.seats
            view.direction.text = item.direction
            view.departure_date.text = "Дата - " + item.departure_date.toString()
            view.departure_time.text = "Время - " + item.departure_time.toString()
            view.arrival_date.text = "Дата - " + item.arrival_date.toString()
            view.arrival_time.text = "Время - " + item.arrival_time.toString()

            view.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}