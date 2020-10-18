package com.example.bus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_passenger.view.*

class PassengerAdapter(
    private val passengers: List<Passenger> = listOf(),
    private val onPassengerClick: (Passenger) -> Unit
) : RecyclerView.Adapter<PassengerAdapter.PassengerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PassengerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_passenger, parent, false))

    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        holder.bindItem(passengers[position])
    }

    override fun getItemCount() = passengers.size

    inner class PassengerViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(passenger: Passenger){
            view.passenger_name.text = passenger.passenger_name
            view.passenger_seat.text = passenger.seat
            view.passenger_seat_type.text = passenger.seat_type
            view.type_imageView.setImageResource(passenger.type_image)

            view.setOnClickListener {
                onPassengerClick(passenger)
            }
        }
    }
}