package com.example.findmywhey.Sections.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.findmywhey.R
import com.example.findmywhey.Support.View.CustomNavigationBottom
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(), HomeContract.UserView {

    private val presenter : HomeContract.UserActionListener<HomeContract.UserView> by lazy {
        HomePresenter(context = this, view = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun goHome(){
        navigation_bottom?.post {
            navigation_bottom.performClickProsition(CustomNavigationBottom.ITEM_HOME)
        }
    }

    override fun onResume() {
        super.onResume()

        if (navigation_bottom.getPositionSelected() == CustomNavigationBottom.ITEM_HOME){
            navigation_bottom.post {
                //                    presenter.clickHome()
            }
        }
    }

    private fun setupActionBarBottom() {

        navigation_bottom.setstelectedListern {

            when(it){

                CustomNavigationBottom.ITEM_HOME -> {


                }

                CustomNavigationBottom.ITEM_CARRINHO -> {


                }

                CustomNavigationBottom.ITEM_HISTORICO -> {


                }

                CustomNavigationBottom.ITEM_PESQUISA -> {


                }

                CustomNavigationBottom.ITEM_MENU -> {


                }
            }
        }

    }

    private fun controlBootButtons():Boolean {

        return if (navigation_bottom.getPositionSelected() != CustomNavigationBottom.ITEM_HOME){

            goHome()
            false

        }else{
            true
        }

    }

}
