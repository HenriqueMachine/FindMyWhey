package com.example.findmywhey.Sections.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.findmywhey.R

class HomeActivity : AppCompatActivity(), HomeContract.UserView {

    private val presenter : HomeContract.UserActionListener<HomeContract.UserView> by lazy {
        HomePresenter(context = this, view = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
