package com.siefb.app

import android.app.Application
import com.siefb.app.data.AppContainer

class SiefbApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = AppContainer(this)
    }
}