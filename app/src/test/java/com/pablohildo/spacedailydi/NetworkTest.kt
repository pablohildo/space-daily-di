package com.pablohildo.spacedailydi

import com.pablohildo.spacedailydi.di.networkModule
import com.pablohildo.spacedailydi.network.APIInterface
import com.squareup.moshi.Moshi
import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest : KoinTest {
    val api: APIInterface by inject()
    val moshi: Moshi by inject()
    val retrofit: Retrofit by inject()
    val okHttpClient: OkHttpClient by inject()
    val baseUrl: String by lazy { get<String>(named("BASE_URL")) }

    @Before
    fun setup() {
        startKoin {
            modules(listOf(networkModule))
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `test retrofit created`() {
        assertNotNull(retrofit)
        assert(baseUrl == "https://api.nasa.gov/planetary/")
    }

    @Test
    fun `test moshi created`() {
        assertNotNull(moshi)
    }

    @Test
    fun `test api created`() {
        assertNotNull(api)
    }

    @Test
    fun `test okhttp`() {
        assertNotNull(okHttpClient)
        assert(okHttpClient.connectTimeoutMillis == 30000)
        assert(okHttpClient.writeTimeoutMillis == 30000)
        assert(okHttpClient.readTimeoutMillis == 30000)
        assert(okHttpClient.interceptors.size == 1)
    }
}