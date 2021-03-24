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
    fun testSuspendFunctions() {
        assertEquals(runBlocking { testClass!!.doSomethingUsefulOne() }, 13)
        assertEquals(runBlocking { testClass!!.doSomethingUsefulTwo() }, 29)
    }

    @Test
    fun testUIExample() {
        val future = CompletableFuture<Int>()
        testClass!!.uiExample {
            future.complete(1)
        }
        assertEquals(1, future.get() as Int)
    }

    @Test
    fun testUINetworkExample() {
        val future = CompletableFuture<Int>()
        testClass!!.uiNetworkExample {
            future.complete(1)
        }
        assertEquals(1, future.get() as Int)
    }
}