package com.example.findmywhey.Sections.Home

import com.example.findmywhey.Support.Base.Presenter
import com.example.findmywhey.Support.Base.View

/**
 * Criado por Henrique Menezes da Paixão on 27/03/2019
 */
interface HomeContract {

    interface UserView : View {

    }

    interface UserActionListener <T:View> : Presenter<T>{

    }

}