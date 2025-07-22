package com.example.ggsouresjetpack.Side_Effects

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}