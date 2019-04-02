package com.example.findmywhey.Sections.Home

import android.content.Context
import com.example.findmywhey.Model.Produto
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Sections.Home.dataProviders.HomeDataProviderContract

/**
 * Criado por Henrique Menezes da Paixão on 27/03/2019
 */

class HomePresenter(var context: Context,
                    override var view:HomeContract.UserView?) :
    HomeContract.UserActionListener<HomeContract.UserView>{


}