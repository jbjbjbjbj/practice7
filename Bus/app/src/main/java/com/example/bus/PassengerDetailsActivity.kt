package com.example.bus

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_passenger_details.*

class PassengerDetailsActivity : AppCompatActivity() {

    private var free_seats = listOf(
        Passenger(5,"Нет имени", "0 A", "нижний", R.drawable.notype),
        Passenger(6,"Нет имени", "0 B", "нижний", R.drawable.notype),
        Passenger(7,"Нет имени", "2", "нижний", R.drawable.notype),
        Passenger(8,"Нет имени", "2", "верхный", R.drawable.notype),
        Passenger(9,"Нет имени", "3", "нижний", R.drawable.notype),
        Passenger(10,"Нет имени", "3", "верхный", R.drawable.notype),
        Passenger(11,"Нет имени", "4", "нижний", R.drawable.notype),
        Passenger(12,"Нет имени", "4", "верхный", R.drawable.notype)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passenger_details)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Пассажиры"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        passenger_view.layoutManager = LinearLayoutManager(this)

        free_seats_view.layoutManager = LinearLayoutManager(this)
        free_seats_view.adapter = PassengerAdapter(free_seats, onPassengerClick = {})

        setupViews()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun setupViews() {
        if (PreferencesManager.getId(this) == 0){
            PreferencesManager.saveId(this, 1)
        AsyncTask.execute {

            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertPassenger(Passenger(null,"Aigerim", "0 A", "верхный", R.drawable.offline))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertPassenger(Passenger(null,"Arlan", "0 B", "верхный", R.drawable.offline))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertPassenger(Passenger(null,"Assel", "1", "нижний", R.drawable.online))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertPassenger(Passenger(null,"Temirlan", "1", "верхный", R.drawable.online))

            val passengers = AppDatabase.getInstance(applicationContext)!!.getPassengerDao().getPassengers()

            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertTicket(Ticket(null,passengers[0].id!!, "Aigerim", 77079282498, "Почта", "0 A верхный", 3000))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertTicket(Ticket(null,passengers[1].id!!, "Arlan", 77079282498, "Почта", "0 B верхный", 3000))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertTicket(Ticket(null,passengers[2].id!!, "Assel", 77079282498, "Почта", "1 нижний", 3000))
            AppDatabase.getInstance(applicationContext)!!.getPassengerDao().insertTicket(Ticket(null,passengers[3].id!!, "Temirlan", 77079282498, "Почта", "1 верхный", 3000))

            runOnUiThread {
                passenger_view.adapter = PassengerAdapter(passengers, onPassengerClick = {
                    PreferencesManager.savePassengerId(this, it.id!!)
                    CustomBottomSheetDialogFragment().apply {
                        show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
                    }
                })
            }
        }
        } else {
            AsyncTask.execute {
                val passengers = AppDatabase.getInstance(applicationContext)!!.getPassengerDao().getPassengers()

                runOnUiThread {
                    passenger_view.adapter = PassengerAdapter(passengers, onPassengerClick = {
                        PreferencesManager.savePassengerId(this, it.id!!)
                        CustomBottomSheetDialogFragment().apply {
                            show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
                        }
                    })
                }
            }
        }
    }
}
