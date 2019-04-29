package com.example.findmywhey.Model

import java.io.Serializable

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

class ProdutoCart(
        var nomeDoProduto:String = "",
        var idDoProduto:String = "",
        var imagemDoProduto:String = "",
        var precoDoProduto:String = "",
        var quantidadeSelecionada:String = ""
) : Serializable{

}