package com.example.findmywhey.Sections.Home.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.findmywhey.R
import com.example.findmywhey.Support.Base.BaseFragment


/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */
class HomeFragment : BaseFragment(), HomeFragmentContract.UserView {

    private val presenter : HomeFragmentContract.UserActionListener<HomeFragmentContract.UserView> by lazy {
        HomeFragmentPresenter(context = activity, view = this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        try {
            container?.clearDisappearingChildren()
        }catch (e: Exception){

        }

        container?.removeAllViews()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
