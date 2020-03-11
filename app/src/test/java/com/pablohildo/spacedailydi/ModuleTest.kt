package com.pablohildo.spacedailydi

import com.pablohildo.spacedailydi.di.appModule
import com.pablohildo.spacedailydi.di.networkModule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class ModuleTest : KoinTest {
    @Test
    fun `test koin modules`() {
        startKoin {
            modules(listOf(networkModule))
        }.checkModules()
        stopKoin()
    }
}