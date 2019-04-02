package com.example.findmywhey.Support.Base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

/**
 * Criado por Henrique Menezes da Paixão on 27/03/2019
 */

open class BaseActivity : AppCompatActivity(), View{

    protected val context: Context get() = this


}