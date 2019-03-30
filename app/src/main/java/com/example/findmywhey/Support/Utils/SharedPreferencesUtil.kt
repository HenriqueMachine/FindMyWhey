package com.example.findmywhey.Support.Utils

import android.content.Context
import android.content.SharedPreferences
import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE

object SharedPreferencesUtil{
    private val PREF_NAME = "SHARED"
    private var sp: SharedPreferences? = null

    /**
     * Salva no sharedPreferences
     */
    @SuppressLint("ApplySharedPref")
    fun saveDataString(context: Context, key:String, data:String){
        sp = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val editor = sp?.edit()
        editor?.putString(key, data)
        editor?.commit()
    }

    @SuppressLint("ApplySharedPref")
    fun removeDataString(context: Context, key:String){
        sp = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val editor = sp?.edit()
        editor?.remove(key)
        editor?.commit()
    }

    fun getDataString(context: Context):String?{
        sp = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        return sp.toString()
    }
}
