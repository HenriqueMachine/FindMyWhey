package com.example.findmywhey.Support.Base

/**
 * Created by Henrique Menezes da Paixão on 26/03/19.
 */
interface Presenter<T : View> {

    var view: T?

    fun onDestroy(){
        view = null
    }

}