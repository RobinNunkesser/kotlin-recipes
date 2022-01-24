package de.hshl.isd.asynccompose

import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.concurrent.CompletableFuture

class AsyncUnitTest {
    private var testClass: AsyncExample? = null

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        testClass = AsyncExample()
    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun testUsefulFunctions() {
        assertEquals(13, runBlocking { testClass!!.doSomethingUsefulOne() })
        assertEquals(29, runBlocking { testClass!!.doSomethingUsefulTwo() })
        assertEquals(42, runBlocking { testClass!!.asyncCalculation() })
    }

    @Test
    fun testNetworkingFunction() {
        val result = runBlocking { testClass!!.readFromNetwork() }
        assertEquals("[", result.subSequence(0,1))
        assertEquals(runBlocking { testClass!!.doSomethingUsefulTwo() }, 29)
    }

}