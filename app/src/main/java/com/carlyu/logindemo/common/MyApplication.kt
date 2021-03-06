package com.carlyu.logindemo.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by Roman on 2021/1/11
 *
 * 这里注意AndroidManifest的 android:name=".common.MyApplication" 配置
 * 否则onCreate回调不会执行，造成context为空指针异常
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        var context: Context? = null
    }
}