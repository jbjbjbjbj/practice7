package com.example.bus

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passenger")
data class Passenger (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int?,
    @ColumnInfo(name = "passenger_name") var passenger_name: String,
    @ColumnInfo(name = "seat") var seat: String,
    @ColumnInfo(name = "seat_type") var seat_type: String,
    @ColumnInfo(name = "type_image") var type_image: Int
)