package com.example.findmywhey.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Criado por Henrique Menezes da Paixão on 30/03/2019
 */

class Produto(
        var nomeDoProduto:String,
        var descricaoDoProduto:String,
        var idDoProduto:String,
        var imagemDoProduto:String,
        var precoDoProduto:String,
        var quantidadeEmEstoque:String,
        var fabricanteDoProduto:String,
        var classificacaoDoProduto:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomeDoProduto)
        parcel.writeString(descricaoDoProduto)
        parcel.writeString(idDoProduto)
        parcel.writeString(imagemDoProduto)
        parcel.writeString(precoDoProduto)
        parcel.writeString(quantidadeEmEstoque)
        parcel.writeString(fabricanteDoProduto)
        parcel.writeString(classificacaoDoProduto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Produto> {
        override fun createFromParcel(parcel: Parcel): Produto {
            return Produto(parcel)
        }

        override fun newArray(size: Int): Array<Produto?> {
            return arrayOfNulls(size)
        }
    }
}