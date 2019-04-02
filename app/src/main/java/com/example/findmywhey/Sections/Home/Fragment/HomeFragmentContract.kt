package com.example.findmywhey.Sections.Home.Fragment

import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Base.Presenter
import com.example.findmywhey.Support.Base.View

/**
 * Criado por Henrique Menezes da Paixão on 28/03/2019
 */
interface HomeFragmentContract {

    interface UserView : View{

        fun showProdutos(list: ArrayList<ProdutoContentful>?)

    }

    interface UserActionListener <T : View> : Presenter<T> {

        fun loadProdutos()

    }

}