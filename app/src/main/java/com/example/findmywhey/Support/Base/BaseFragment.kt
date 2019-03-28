package com.example.findmywhey.Support.Base

import android.app.ProgressDialog
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by Henrique Menezes da Paixão on 26/03/19.
 */
open class BaseFragment: Fragment(), View{

    private var progressDialog: ProgressDialog? = null

    /**
     * Método para exibir toast
     */
    fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(activity,msg,duration).show()
    }

//    override fun showNoConnectionDialog(onRetry: () -> Unit, onLater: (() -> Unit)?) {
//        if (activity == null) {
//            return
//        }
//
//        val errorDialog = CustomDialogErrorRandomImage()
//        errorDialog.show(
//                activity!!,
//                getString(R.string.text_tittle_ops),
//                getString(R.string.text_no_internet_conection),
//                onRetry,
//                onLater)
//    }

}