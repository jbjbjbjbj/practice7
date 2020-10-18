package com.example.bus

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_item.*
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    private lateinit var adapter: NavigationAdapter
    private lateinit var item_adapter: ItemAdapter

    private var nav_items = arrayListOf(
        NavigationItemModel(R.drawable.ic_tickets, "Продажа билетов"),
        NavigationItemModel(R.drawable.ic_administration, "Список администраторов"),
        NavigationItemModel(R.drawable.ic_bus, "Автобусы"),
        NavigationItemModel(R.drawable.ic_statistics, "Статистика"),
        NavigationItemModel(R.drawable.ic_passengers, "Пассажиры"),
        NavigationItemModel(R.drawable.ic_schedule, "Расписание"),
        NavigationItemModel(R.drawable.ic_history, "История"),
        NavigationItemModel(R.drawable.ic_settings, "Настройки")
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val d_date = LocalDate.of(2020, 9, 29)
    @RequiresApi(Build.VERSION_CODES.O)
    val d_time = LocalTime.of(20, 15)
    @RequiresApi(Build.VERSION_CODES.O)
    val a_date = LocalDate.of(2020, 9, 30)
    @RequiresApi(Build.VERSION_CODES.O)
    val a_time = LocalTime.of(6, 33)

    private var items = listOf(
        Item(R.drawable.yutong, "YUTONG", "KZ 888 KZ 02", "32 мест", "Асыката-Алматы", d_date, d_time, a_date, a_time),
        Item(R.drawable.iveco, "IVECO", "KZ 777 KZ 02", "30 мест", "Алматы-Нур-Султан", d_date, d_time, a_date, a_time),
        Item(R.drawable.eurobus, "Eurobus", "KZ 666 KZ 02", "36 мест", "Нур-Султан-Алматы", d_date, d_time, a_date, a_time)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Расписание"


        navigation_rv.layoutManager = LinearLayoutManager(this)
        item_view.layoutManager = LinearLayoutManager(this)
        navigation_rv.setHasFixedSize(true)

        adapter = NavigationAdapter(nav_items, onItemClick = {
            when (it.title) {
                "Продажа билетов" -> {
                    Toast.makeText(this, "Продажа билетов", Toast.LENGTH_LONG).show()
                }
                "Список администраторов" -> {
                    Toast.makeText(this, "Список администраторов", Toast.LENGTH_LONG).show()
                }
                "Автобусы" -> {
                    Toast.makeText(this, "Автобусы", Toast.LENGTH_LONG).show()
                }
                "Статистика" -> {
                    Toast.makeText(this, "Статистика", Toast.LENGTH_LONG).show()
                }
                "Пассажиры" -> {
                    val intent = Intent(this, PassengersActivity::class.java)
                    startActivity(intent)
                }
                "Расписание" -> {
                    Toast.makeText(this, "Расписание", Toast.LENGTH_LONG).show()
                }
                "История" -> {
                    Toast.makeText(this, "История", Toast.LENGTH_LONG).show()
                }
                "Настройки" -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_LONG).show()
                }
            }
        })
        navigation_rv.adapter = adapter

        item_adapter = ItemAdapter(items)
        item_view.adapter = item_adapter

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle (
            this,
            drawerLayout,
            toolbar,
            (R.string.open),
            (R.string.close)
        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
