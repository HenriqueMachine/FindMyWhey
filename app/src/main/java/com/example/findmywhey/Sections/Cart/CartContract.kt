package com.example.findmywhey.Sections.Cart

import com.example.findmywhey.Support.Base.Presenter
import com.example.findmywhey.Support.Base.View

/**
 * Criado por Henrique Menezes da Paixão on 07/04/2019
 */
interface CartContract {

    interface UserView : View {

    }

    interface UserActionListener <T: View> : Presenter<T> {

    }

}