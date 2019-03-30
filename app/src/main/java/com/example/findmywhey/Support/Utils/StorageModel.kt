package com.example.findmywhey.Support.Utils

import android.content.Context
import com.google.gson.Gson

abstract class StorageModel{

    fun saveModelStorage(context: Context?){

        if (context != null) {
            val json = Gson().toJson(this)

            try {
                SharedPreferencesUtil.saveDataString(context, this::class.java.simpleName, json)
            }catch (e:Exception){

            }

        }

    }

    fun removeModelStorage(context: Context?){

        if (context != null) {
            try {

//                SharedPreferencesUtil.saveDataString(context, this::class.java.simpleName, "")
                SharedPreferencesUtil.removeDataString(context, this::class.java.simpleName)

            }catch (e:Exception){
                e.printStackTrace()
            }

        }

    }

    inline fun <reified T>getModelStorage(context: Context?):T?{

        if (context != null) {

            var json:String? = ""

            try {
                json = SharedPreferencesUtil.getDataString(context)
            }catch (e:Exception){

            }

            return if (!json.isNullOrEmpty()) {
                Gson().fromJson(json, T::class.java)
            } else {
                null
            }

        }else{

            return null

        }

    }

}