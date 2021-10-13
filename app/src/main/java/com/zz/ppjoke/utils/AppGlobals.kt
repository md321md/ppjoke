package com.zz.ppjoke.utils

import android.annotation.SuppressLint
import android.app.Application

private lateinit var sApplication: Application

// 通过反射ActivityThread.java调用currentApplication方法获取当前application
@SuppressLint("DiscouragedPrivateApi", "PrivateApi")
fun getApplication(): Application {
     try {
        val method = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication")
        sApplication = method.invoke(null,null) as Application
    } catch (t: Throwable) {
        t.printStackTrace()
    }
    return sApplication
}