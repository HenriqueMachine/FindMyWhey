package com.example.findmywhey.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.R
import com.example.findmywhey.Support.Base.loadFromUrl
import com.example.findmywhey.Support.Utils.MyViewHolder
import kotlinx.android.synthetic.main.item_produtos.view.*

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

class ProdutosAdapter(
    var mLista: ArrayList<ProdutoContentful>,
    var context: Context,
    val listern: ProdutoClicadoListern) : androidx.recyclerview.widget.RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): MyViewHolder {

        val view:View = LayoutInflater.from(p0.context).inflate(R.layout.item_produtos, p0, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = mLista[position]

        holder.itemView.tv_nome_produto.text = item.nomeDoProduto
        holder.itemView.iv_produto.loadFromUrl(item.imagemDoProduto)
        holder.itemView.cv_item_produto.setOnClickListener {

            listern.produtoClicked(position)
        }

    }


    interface ProdutoClicadoListern{
        fun produtoClicked(position:Int)
    }

}