package com.example.findmywhey.Sections.Home.Fragment

import android.content.Context
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Sections.Home.dataProviders.HomeDataProviderContract

/**
 * Criado por Henrique Menezes da Paixão on 28/03/2019
 */

class HomeFragmentPresenter(var context: Context?,
                            override var view:HomeFragmentContract.UserView?,
                            private val dataProvider : HomeDataProviderContract) :
    HomeFragmentContract.UserActionListener<HomeFragmentContract.UserView>{


        private var produtos : ArrayList<ProdutoContentful>? = null

    override fun loadProdutos() {

        dataProvider.loadProdutos({

                produtos = it

                view?.showProdutos(it)


        },{
            //error
        })

    }

    override fun loadInformation(position: Int) {

        view?.showToast(produtos?.get(position)?.idDoProduto.toString())

    }

}