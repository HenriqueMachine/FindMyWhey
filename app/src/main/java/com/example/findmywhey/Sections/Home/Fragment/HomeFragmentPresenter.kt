package com.example.findmywhey.Sections.Home.Fragment

import android.content.Context

/**
 * Criado por Henrique Menezes da Paixão on 28/03/2019
 */

class HomeFragmentPresenter(var context: Context?,
                            override var view:HomeFragmentContract.UserView?) :
    HomeFragmentContract.UserActionListener<HomeFragmentContract.UserView>