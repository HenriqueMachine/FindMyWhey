package com.example.findmywhey.Sections.Home.dataProviders

import com.example.findmywhey.Model.ProdutoContentful

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */
interface HomeDataProviderContract {

    fun loadProdutos(
        onResponse : (ArrayList<ProdutoContentful>) -> Unit,
        onError : (Throwable?) -> Unit

    )

}