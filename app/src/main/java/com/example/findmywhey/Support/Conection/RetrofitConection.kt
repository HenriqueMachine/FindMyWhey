package com.example.findmywhey.Support.Conection

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Buffer

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */

class RetrofitConection(url: String) {

    var baseAPI: BaseAPI

    init {

        val gson = GsonBuilder()
                .setLenient()
                .create()


        val client = OkHttpClient.Builder()
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        baseAPI = retrofit.create(BaseAPI::class.java)

    }

    private fun bodyToString(request: Request): String {

        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body()?.writeTo(buffer)
            return buffer.readUtf8()
        } catch (e: IOException) {
            return "did not work"
        }

    }

}
