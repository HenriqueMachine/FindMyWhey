package com.example.findmywhey.Model

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

class ProdutoContentful(
        var nomeDoProduto:String = "",
        var descricaoDoProduto:String = "",
        var idDoProduto:String = "",
        var imagemDoProduto:String = "",
        var precoDoProduto:String = "",
        var quantidadeEmEstoque:String = "",
        var fabricanteDoProduto:String = "",
        var classificacaoDoProduto:String = ""
) {

    override fun toString(): String {
        return "Produto(idDoProduto = '$idDoProduto')," +
                " nomeDoProduto = '$nomeDoProduto'," +
                " descricaoDoProduto = '$descricaoDoProduto'," +
                " imagemDoProduto = '$imagemDoProduto'," +
                " precoDoProduto = '$precoDoProduto'," +
                " quantidadeEmEstoque = '$quantidadeEmEstoque'," +
                " nomeFabricante = '$fabricanteDoProduto,'" +
                " classificacaoDoProduto = '$classificacaoDoProduto'"
    }

}