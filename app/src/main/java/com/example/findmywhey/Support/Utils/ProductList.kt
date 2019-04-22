package com.example.findmywhey.Support.Utils

import android.content.Context
import com.example.findmywhey.Model.ProdutoContentful

/**
 * Criado por Henrique Menezes da Paixão on 22/04/2019
 */

class ProductList(context: Context){

    var list : ArrayList<ProdutoContentful>? = null

    fun myList(produto:ProdutoContentful){

        list?.add(produto)

    }

    fun getProduct() : ArrayList<ProdutoContentful>? {

        return list

    }

    fun removeProduct(produto:ProdutoContentful){

        list?.remove(produto)

    }

    fun clearList(){

        list?.clear()

    }

}