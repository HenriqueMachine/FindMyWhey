package com.example.findmywhey.Sections.Home.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */

import com.example.findmywhey.R

class HomeFragment : Fragment(), HomeFragmentContract.UserView {

    private val presenter : HomeFragmentContract.UserActionListener<HomeFragmentContract.UserView> by lazy {
        HomeFragmentPresenter(context = activity, view = this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        try {
            container?.clearDisappearingChildren()
        }catch (e: Exception){

        }

        container?.removeAllViews()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
