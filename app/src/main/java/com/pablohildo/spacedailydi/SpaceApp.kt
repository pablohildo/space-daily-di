package com.pablohildo.spacedailydi

import android.app.Application
import com.pablohildo.spacedailydi.di.appModule
import com.pablohildo.spacedailydi.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpaceApp : Application() {
    val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SpaceApp)
            modules(listOf(appModule, networkModule))
        }

        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }
}