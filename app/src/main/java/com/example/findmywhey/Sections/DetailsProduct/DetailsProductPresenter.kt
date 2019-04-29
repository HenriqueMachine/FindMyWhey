package com.example.findmywhey.Sections.DetailsProduct

import android.content.Context
import com.example.findmywhey.Model.ProdutoCart
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Utils.ProductList


/**
 * Criado por Henrique Menezes da Paixão on 22/04/2019
 */

class DetailsProductPresenter(var context: Context?,
                              override var view : DetailsProductContract.UserView?
) : DetailsProductContract.UserActionListener<DetailsProductContract.UserView> {

    private var produtoCart:ProdutoCart? = null

    override fun myList(produto: ProdutoContentful?, quantidadeCompra: Int?) {

        if (produto != null) {

            produtoCart?.nomeDoProduto = produto.nomeDoProduto
            produtoCart?.idDoProduto = produto.idDoProduto
            produtoCart?.imagemDoProduto = produto.imagemDoProduto
            produtoCart?.precoDoProduto = produto.precoDoProduto
            produtoCart?.quantidadeSelecionada = quantidadeCompra.toString()

            produtoCart?.let { ProductList.myList(it) }
        }

    }

}