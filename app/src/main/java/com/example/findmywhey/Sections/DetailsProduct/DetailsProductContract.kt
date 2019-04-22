package com.example.findmywhey.Sections.DetailsProduct

import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Base.Presenter
import com.example.findmywhey.Support.Base.View

/**
 * Criado por Henrique Menezes da Paixão on 22/04/2019
 */
interface DetailsProductContract {

    interface UserView : View {


    }

    interface UserActionListener <T : View> : Presenter<T> {

        fun myList(produto:ProdutoContentful?)

    }

}