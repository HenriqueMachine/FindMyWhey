package com.example.findmywhey.Domain

import com.example.findmywhey.Model.ProdutoContentful

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

interface ResponseDomain<T>{

    fun onResponse(response: ArrayList<ProdutoContentful>)
    fun onError(e:Throwable?)

}