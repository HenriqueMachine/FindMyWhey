package com.example.findmywhey.Support.Utils

import android.content.Context
import com.example.findmywhey.Model.ProdutoCart
import com.example.findmywhey.Support.Base.SingletonHolder

/**
 * Criado por Henrique Menezes da Paixão on 22/04/2019
 */

class ProductList(var context: Context){

    companion object : SingletonHolder<ProductList, Context>(::ProductList) {

        private var list : ArrayList<ProdutoCart>? = ArrayList<ProdutoCart>()

        fun myList(produto:ProdutoCart){

            list?.add(produto)

        }

        fun getProduct() : ArrayList<ProdutoCart>? {

            return list

        }

        fun removeProduct(produto:ProdutoCart){

            list?.remove(produto)

        }

        fun clearList(){

            list?.clear()

        }

    }
}