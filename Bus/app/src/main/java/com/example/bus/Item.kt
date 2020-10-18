package com.example.bus

import java.time.LocalDate
import java.time.LocalTime

data class Item (
    var image: Int,
    var name: String,
    var number: String,
    var seats: String,
    var direction: String,
    var departure_date: LocalDate,
    var departure_time: LocalTime,
    var arrival_date: LocalDate,
    var arrival_time: LocalTime
)