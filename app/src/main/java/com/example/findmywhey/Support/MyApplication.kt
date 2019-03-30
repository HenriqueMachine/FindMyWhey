package com.example.findmywhey.Support

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.findmywhey.Domain.ContentfulDomain
import com.example.findmywhey.Domain.ResponseDomain
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Support.Manager.APIManager

/**
 * Criado por Henrique Menezes da Paixão on 27/03/2019
 */
class MyApplication: Application(), Application.ActivityLifecycleCallbacks {

    private var applicationState = ""
    private var currentActivity: Activity? = null

   init {

       appInstance = this

   }

    companion object {

        private var appInstance: MyApplication? = null

        fun getInstance(): MyApplication{

            if (appInstance == null){
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }

            return appInstance!!
        }

    }

    fun apiManager(): APIManager {
        return APIManager.getInstance(this)
    }

    override fun onActivityPaused(p0: Activity?) {
        applicationState = "Pause"
    }

    override fun onActivityResumed(p0: Activity?) {
        applicationState = "Resume"
        currentActivity = p0

    }

    override fun onActivityStarted(p0: Activity?) {
        applicationState = "Start"
        currentActivity = p0
    }

    override fun onActivityDestroyed(p0: Activity?) {
        applicationState = "Destroy"
        if (p0 == currentActivity) {
            currentActivity = null
        }
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(p0: Activity?) {
        applicationState = "Stop"
    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
        applicationState = "Create"
        currentActivity = p0
    }
}
