package com.example.findmywhey.Support.Base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.findmywhey.R
import java.text.NumberFormat
import java.util.*

/**
 * Created by rafaelbarbosa on 26/12/17.
 */

/**
 * Extenção para facilitar uso do OnClickListener de qualquer view
 */
fun AppCompatActivity.onClick(@IdRes viewId: Int,onClick: (v: android.view.View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

/**
 * Extenção para facilitar configuração da Toolbar
 */
fun AppCompatActivity.setupToolbar(@IdRes viewId: Int, title: String? = null,
                                   upNavigation: Boolean = false): ActionBar{

    val toolbar = findViewById<Toolbar>(viewId)
    setSupportActionBar(toolbar)
    if (title != null){
        supportActionBar?.title = title
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)

    return supportActionBar!!

}

/**
 * Extenção para facilitar configuração da Toolbar
 */
fun AppCompatActivity.setupToolbar(toolbar: Toolbar){

    setSupportActionBar(toolbar)
    supportActionBar?.title = ""
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

}

/**
 * Extenção criada para facilitar a adição de Fragments em determinado container
 */
fun AppCompatActivity.addFrament(@IdRes layoutId: Int, fragment: androidx.fragment.app.Fragment?){

    try {

        supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)

        try {
            findViewById<ViewGroup>(layoutId).removeAllViews()
        }catch (e : Exception){
            Log.i("LOG","addFrament ${e.message}")
        }

        supportFragmentManager.executePendingTransactions()

        //fragment?.arguments = intent.extras
        val ft = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            ft.add(layoutId,fragment)
        }
        ft.addToBackStack(null)
        ft.commit()

    }catch (e:Exception){

    }

}

/**
 * Extenção criada para facilitar a adição de Fragments em determinado container
 */
fun AppCompatActivity.addFramentNoStack(@IdRes layoutId: Int, fragment: androidx.fragment.app.Fragment?){

    try {

        supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)

        try {
            findViewById<ViewGroup>(layoutId).removeAllViews()
        }catch (e : Exception){
            Log.i("LOG","addFrament ${e.message}")
        }


        supportFragmentManager.executePendingTransactions()
        //fragment?.arguments = intent.extras
        val ft = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            ft.add(layoutId,fragment)
        }
        ft.commit()

    }catch (e: Exception){

    }


}

fun AppCompatActivity.clearStackFrament(){
    supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

/**
 * Extenção criada para facilitar o replace de Fragments em determinado container
 */
fun AppCompatActivity.replaceFragment(@IdRes layoutId: Int, fragment: androidx.fragment.app.Fragment, clearStack: Boolean = false){

    try {

        if (clearStack) {
            supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        try {
            findViewById<ViewGroup>(layoutId).removeAllViews()
        }catch (e : Exception){
            Log.i("LOG","addFrament ${e.message}")
        }

        supportFragmentManager.executePendingTransactions()

        //fragment.arguments = intent.extras
        val ft = supportFragmentManager.beginTransaction()

        if (!clearStack) {
            ft.setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out)
        }

        ft.replace(layoutId,fragment)
        ft.addToBackStack(null)
        ft.commit()

    }catch (e: Exception){

    }

}

/**
 * Extenção criada para facilitar o replace de Fragments em determinado container sem pilha de fragments
 */
fun AppCompatActivity.replaceFragmentNoStack(@IdRes layoutId: Int, fragment: androidx.fragment.app.Fragment){

    try {

        supportFragmentManager.executePendingTransactions()
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
        ft.replace(layoutId,fragment)
        ft.commit()

    }catch (e: Exception){

    }

}

fun Double.formatToCurrency():String{
    val format = NumberFormat.getCurrencyInstance(Locale( "pt", "BR" ))
    var valor = format.format(this)
    return valor.replace("R$","R$ ")
}

fun Double.formatToKM():String{

    val sb = StringBuilder()
    val formatter = Formatter(sb, Locale( "pt", "BR" ))
    formatter.format("%(,.0f", this)
    return sb.toString()
}

fun View.setMarginCustom(left:Int, top:Int,right:Int,bottom:Int){

            if (this.getLayoutParams() is ViewGroup.MarginLayoutParams){
            val p = this.getLayoutParams() as ViewGroup.MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            this.requestLayout()
        }

}