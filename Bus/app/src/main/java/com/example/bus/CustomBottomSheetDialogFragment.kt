package com.example.bus

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.*

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val passenger_id = PreferencesManager.getPassengerId(this.context!!)

        AsyncTask.execute {
            val passengerTicket = AppDatabase.getInstance(this.context!!)!!.getPassengerDao().getTicketByPassengerId(passenger_id)

            requireActivity().runOnUiThread {
                passenger_name_edittext.setText(passengerTicket.passenger_name)
                passenger_phone_edittext.setText(passengerTicket.phone.toString())
                passenger_email_edittext.setText(passengerTicket.email)
                passenger_seat_edittext.setText(passengerTicket.passenger_seat)
                passenger_price_edittext.setText(passengerTicket.price.toString())

                change_ticket_button.setOnClickListener {
                    Toast.makeText(context, "Change Button Clicked", Toast.LENGTH_SHORT).show()
                }
                send_bill_button.setOnClickListener {
                    Toast.makeText(context, "Send Button Clicked", Toast.LENGTH_SHORT).show()
                }
                cancel_ticket_button.setOnClickListener {
                    AsyncTask.execute {
                        AppDatabase.getInstance(this.context!!)!!.getPassengerDao().deleteTicket(tid = 1)
                        requireActivity().runOnUiThread {
                            dismiss()
                            Toast.makeText(context, "Билет удален", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}