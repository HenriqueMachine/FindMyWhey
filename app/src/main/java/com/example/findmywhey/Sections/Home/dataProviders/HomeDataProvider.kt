package com.example.findmywhey.Sections.Home.dataProviders

import com.example.findmywhey.Domain.ContentfulDomain
import com.example.findmywhey.Domain.ResponseDomain
import com.example.findmywhey.Model.ProdutoContentful

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

class HomeDataProvider : HomeDataProviderContract{

    private val contentfulDomain : ContentfulDomain by lazy {

        ContentfulDomain()

    }

    override fun loadProdutos(onResponse: (ArrayList<ProdutoContentful>) -> Unit,
                              onError: (Throwable?) -> Unit
    ) {

        contentfulDomain.loadProdutos(object : ResponseDomain<ArrayList<ProdutoContentful>>{
            override fun onResponse(response: ArrayList<ProdutoContentful>) {

                onResponse(response)

            }

            override fun onError(e: Throwable?) {
                onError(e)
            }

        })

    }


}