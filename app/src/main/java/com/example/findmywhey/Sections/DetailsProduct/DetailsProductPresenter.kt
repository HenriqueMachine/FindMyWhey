package com.example.findmywhey.Sections.DetailsProduct

import android.content.Context
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Utils.ProductList


/**
 * Criado por Henrique Menezes da Paixão on 22/04/2019
 */

class DetailsProductPresenter(var context: Context?,
                              override var view : DetailsProductContract.UserView?
) : DetailsProductContract.UserActionListener<DetailsProductContract.UserView> {

    override fun myList(produto: ProdutoContentful?) {

        if (produto != null) {
            ProductList.myList(produto)
        }

    }

}