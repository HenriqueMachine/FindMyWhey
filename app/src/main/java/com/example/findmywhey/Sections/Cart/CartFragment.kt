package com.example.findmywhey.Sections.Cart


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.findmywhey.R
import com.example.findmywhey.Support.Base.BaseFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class CartFragment : BaseFragment(), CartContract.UserView {

    private val presenter : CartContract.UserActionListener<CartContract.UserView> by lazy {
     CartPresenter(context = activity!!, view = this)
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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

    }

    private fun initViews() {


    }


}
