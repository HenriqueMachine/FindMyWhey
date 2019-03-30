package com.example.findmywhey.Domain

import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Manager.APIManager
import com.example.findmywhey.Support.MyApplication
import com.google.gson.JsonElement
import java.lang.Exception

/**
 * Criado por Henrique Menezes da Paixão on 27/03/2019
 */

class ContentfulDomain{

    private val apiManager = MyApplication.getInstance().apiManager()

     fun loadProdutos(callback: ResponseDomain<ArrayList<ProdutoContentful>>){

        val params = HashMap<String, String>()
        params["content_type"] = "produto"
        params["select"] = "fields"

        val url = APIManager.buildUrlContentfull(MyApplication.getInstance(), params)

        apiManager.get(url,
            HashMap<String,String>(),
            object : APIManager.APIResponse{
                override fun onResponse(response: JsonElement?, responseCode: Int?) {

                    if(responseCode == 200){
                        if (response != null){

                            val items = response.asJsonObject.get("items").asJsonArray

                            val list:ArrayList<ProdutoContentful> = ArrayList()

                            try {

                                items.forEach {

                                    val fields = items[0].asJsonObject.get("fields").asJsonObject
                                    val produto = ProdutoContentful()

                                    produto.idDoProduto = fields.get("").asString
                                    produto.nomeDoProduto = fields.get("").asString
                                    produto.descricaoDoProduto = fields.get("").asString
                                    produto.precoDoProduto = fields.get("").asString
                                    produto.quantidadeEmEstoque = fields.get("").asString
                                    produto.imagemDoProduto = fields.get("").asString
                                    produto.fabricanteDoProduto = fields.get("").asString
                                    produto.classificacaoDoProduto = fields.get("").asString

                                    try {

                                        val assets = response.asJsonObject.get("includes").asJsonObject.asJsonArray

                                        assets.forEach {

                                            val id = it.asJsonObject.get("sys").asJsonObject.get("id").asString

                                            if (produto.imagemDoProduto == id){

                                                produto.imagemDoProduto = it.asJsonObject.get("fields").asJsonObject.get("file").asJsonObject.get("url").asString
                                                produto.imagemDoProduto = produto.imagemDoProduto.replace("//", "https://")

                                            }

                                        }

                                    }catch (e:Exception){

                                    }

                                    list.add(produto)

                                }

                                callback.onResponse(list)

                            }catch (e:Exception){

                                callback.onError(e = e)

                            }

                        }
                    }

                }

                override fun onFailure(t: Throwable?) {

                    callback.onError(e = t)

                }

            })

    }

}