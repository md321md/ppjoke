package com.zz.ppjoke

import android.app.Application
import android.content.Context

class JokeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }
    companion object {
        lateinit var application: Application
    }
}