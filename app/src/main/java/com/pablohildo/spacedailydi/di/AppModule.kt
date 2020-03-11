package com.pablohildo.spacedailydi.di

import com.pablohildo.spacedailydi.ActivityRetriever
import com.pablohildo.spacedailydi.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}