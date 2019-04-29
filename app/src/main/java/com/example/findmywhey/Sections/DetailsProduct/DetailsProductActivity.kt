package com.example.findmywhey.Sections.DetailsProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.R
import com.example.findmywhey.Sections.Home.Fragment.HomeFragment
import com.example.findmywhey.Support.Base.loadFromUrl
import kotlinx.android.synthetic.main.activity_details_product.*

class DetailsProductActivity : AppCompatActivity(), DetailsProductContract.UserView {

    private val presenter : DetailsProductContract.UserActionListener<DetailsProductContract.UserView> by lazy {
        DetailsProductPresenter(context = this, view = this)
    }

    private var quantidadeProduto: Int? = null
    private var quantidadeCompra: Int? = 0
    private var produto: ProdutoContentful? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_product)

        init()

    }

    private fun init (){

        configDetail()
        configComponents()

    }

    private fun configComponents() {

        cardview_mais.setOnClickListener {

            if (quantidadeCompra!!.toInt() >= quantidadeProduto!!.toInt()){

                //DIALOG
                Toast.makeText(this, "Compra limitada a quantidade em estoque", Toast.LENGTH_SHORT).show()
            }else{
                quantidadeCompra = quantidadeCompra?.plus(1)

            }

            tv_detail_quantidade_produto.text = quantidadeCompra.toString()

        }

        cardview_menos.setOnClickListener {

            if (quantidadeCompra!!.toInt() <= 0){

                //DIALOG
                Toast.makeText(this, "Compra não aceita número negativos", Toast.LENGTH_SHORT).show()
            }else{
                quantidadeCompra = quantidadeCompra?.minus(1)

            }

            tv_detail_quantidade_produto.text = quantidadeCompra.toString()

        }

        ic_close.setOnClickListener {
            onBackPressed()
        }

        button_comprar.setOnClickListener {
            presenter.myList(produto, quantidadeCompra)
        }

    }

    private fun configDetail() {
        val detail = intent.getSerializableExtra(HomeFragment.PRODUCT_SERIALIZED) as ProdutoContentful?

        produto = detail

        detail?.let {

            iv_detail_produto.loadFromUrl(it.imagemDoProduto)
            tv_detail_nome_produto.text = it.nomeDoProduto
            tv_detail_description_produto.text = it.descricaoDoProduto
            tv_detail_fabricante_produto.text = it.fabricanteDoProduto
            tv_detail_preco_produto.text = "R$ ${it.precoDoProduto}"
            tv_detail_quantidade_estoque_produto.text = "Apenas ${it.quantidadeEmEstoque} em estoque*"

            quantidadeProduto = it.quantidadeEmEstoque.toInt()

        }
    }
}
