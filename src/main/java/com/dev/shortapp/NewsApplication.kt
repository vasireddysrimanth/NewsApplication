package com.dev.shortapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"inside the Application Class")
    }

    companion object{
        private const val TAG = "NewsApplication"
    }
}