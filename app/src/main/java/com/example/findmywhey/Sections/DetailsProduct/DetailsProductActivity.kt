package com.example.findmywhey.Sections.DetailsProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.R
import com.example.findmywhey.Sections.Home.Fragment.HomeFragment
import com.example.findmywhey.Support.Base.loadFromUrl
import kotlinx.android.synthetic.main.activity_details_product.*

class DetailsProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_product)

        init()

    }

    fun init (){

        configDetail()

    }

    private fun configDetail() {
        val detail = intent.getSerializableExtra(HomeFragment.PRODUCT_SERIALIZED) as ProdutoContentful?

        detail?.let {

            iv_detail_produto.loadFromUrl(it.imagemDoProduto)
            tv_detail_nome_produto.text = it.nomeDoProduto
            tv_detail_description_produto.text = it.descricaoDoProduto
            tv_detail_fabricante_produto.text = it.fabricanteDoProduto
            tv_detail_preco_produto.text = "R$ ${it.precoDoProduto}"
            tv_detail_quantidade_estoque_produto.text = "Apenas ${it.quantidadeEmEstoque} em estoque*"

        }
    }
}
