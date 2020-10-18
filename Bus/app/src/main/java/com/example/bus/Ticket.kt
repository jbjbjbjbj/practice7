package com.example.bus

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket")
data class Ticket(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int?,
    @ColumnInfo(name = "passenger_id") var passenger_id: Int,
    @ColumnInfo(name = "passenger_name") var passenger_name: String,
    @ColumnInfo(name = "phone") var phone: Long,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "passenger_seat") var passenger_seat: String,
    @ColumnInfo(name = "price") var price: Int
)

