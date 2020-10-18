package com.example.bus

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PassengerDao {

    @Insert
    fun insertTicket(ticket: Ticket)

    @Insert
    fun insertPassenger(passenger: Passenger)

    @Query("SELECT * FROM passenger")
    fun getPassengers(): List<Passenger>

    @Query("SELECT * FROM ticket WHERE passenger_id=:id")
    fun getTicketByPassengerId(id: Int): Ticket

    @Query("DELETE FROM ticket WHERE id=:tid")
    fun deleteTicket(tid: Int)

}