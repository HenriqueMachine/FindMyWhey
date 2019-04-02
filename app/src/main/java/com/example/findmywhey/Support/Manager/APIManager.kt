package com.example.findmywhey.Support.Manager

import android.content.Context
import android.util.Log
import com.example.findmywhey.Support.Base.SingletonHolder
import com.example.findmywhey.Support.Conection.BaseAPI
import com.example.findmywhey.Support.Conection.RetrofitConection
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Criado por Henrique Menezes da Paixão on 26/03/2019
 */

class APIManager(val context: Context){

    private val TAG = "APIManager"
    private var baseAPI : BaseAPI? = null


    init {
        baseAPI = RetrofitConection("https://cdn.contentful.com").baseAPI
    }

    fun get(path:String,
            header:Map<String, String>,
            callback:APIResponse){


        privateGet(path, header, callback)

    }


    private fun privateGet(path:String,
                    header:Map<String, String>,
                    callback:APIResponse){

        baseAPI?.getGenericWhithHeaders(path,header)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    Log.e(TAG,"Erro:"+t?.message)

                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    var jsonElement:JsonElement? = null

                    if (response.isSuccessful){

                        try {

                            if(response.body()!=null) {
                                jsonElement = JsonParser().parse(response.body()?.string()) as JsonElement
                            }

                        }catch (e:Exception){
                            Log.e(TAG,e.message?:"")
                        }

                    }else{

                        try {

                            if (response.errorBody() != null) {
                                jsonElement = JsonParser().parse(response.errorBody()?.string())
                            }

                        }catch (e:Exception){
                            Log.e(TAG,e.message?:"")
                        }

                    }

                    callback.onResponse(jsonElement,response.code())
                }

                })
    }

    companion object : SingletonHolder<APIManager, Context>(::APIManager){

        val urlFaq = ""

        private val url = ""

        fun buildUrl(uri:String,params: Map<String, String>? = null):String{

            var url = this.url+uri+""

            if (params != null) {
                for (key in params.keys) {
                    url += "&$key=${params[key]}"
                }
            }

            return url
        }

        fun buildUrlContentfull(context: Context?, params: Map<String, String>? = null):String{

//            9527ee41f6a9fef845ac11f1752ba57a388e6d3a8e43d1a3992164370b98b8b8

            val space = "bbwo17v52ycg"
            val accessToken = "dde70bfe2ddfb372d4f070e4897624d45fe54f5ccf2034966c61ca7e9b1c5945"
            var url = "https://cdn.contentful.com/spaces/$space/entries?access_token=$accessToken"

            if (params != null) {
                for (key in params.keys) {
                    url += "&$key=${params[key]}"
                }
            }

            return url

        }

    }

    interface APIResponse{
        fun onResponse(response: JsonElement?, responseCode : Int?)
        fun onFailure(t : Throwable?)
    }

}