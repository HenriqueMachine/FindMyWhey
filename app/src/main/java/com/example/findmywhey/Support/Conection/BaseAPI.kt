package com.example.findmywhey.Support.Conection

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Url
import retrofit2.http.POST
import retrofit2.http.GET



/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */

interface BaseAPI {

    @GET
    fun getGenericWhithHeaders(@Url url: String,
                          @HeaderMap headers: Map<String, String>): Call<ResponseBody>

    @DELETE
    fun deleteGenericWhithHeaders(@Url url: String,
                                  @HeaderMap headers: Map<String, String>): Call<ResponseBody>

    @POST
    fun postGenericWhithHeaders(@Url url: String,
                    @Body json: RequestBody,
                    @HeaderMap headers: Map<String, String>): Call<ResponseBody>

    @PUT
    fun putGenericWhithHeaders(@Url url: String,
                               @Body json: RequestBody,
                               @HeaderMap headers: Map<String, String>): Call<ResponseBody>


    @POST
    fun postGenericMultpart(@Url url: String,
                            @Body body: RequestBody ,
                            //@Part file: MultipartBody.Part?,
                            @HeaderMap headers: Map<String, String>): Call<ResponseBody>
}
