package com.example.bus

import android.content.Context

object PreferencesManager {
    private const val PREF_PASSENGER_ID = "passengerid"
    private const val PREF_ID = "id"

    fun savePassengerId(context: Context, id: Int){
        getPrefs(context).edit().putInt(PREF_PASSENGER_ID, id).apply()
    }

    fun saveId(context: Context, id: Int){
        getPrefs(context).edit().putInt(PREF_ID, id).apply()
    }

    fun getPassengerId(context: Context) = getPrefs(context).getInt(PREF_PASSENGER_ID, 0)

    fun getId(context: Context) = getPrefs(context).getInt(PREF_ID, 0)

    private fun getPrefs(context: Context) = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
}