package com.example.findmywhey.Support.Base

import android.app.ProgressDialog
import androidx.fragment.app.Fragment
import android.widget.Toast

/**
 * Created by Henrique Menezes da Paixão on 26/03/19.
 */
open class BaseFragment: androidx.fragment.app.Fragment(), View{

    /**
     * Método para exibir toast
     */
    fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(activity,msg,duration).show()
    }


}