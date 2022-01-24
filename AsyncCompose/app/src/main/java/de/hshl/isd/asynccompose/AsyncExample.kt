package de.hshl.isd.asynccompose

import kotlinx.coroutines.*
import java.net.URL

class AsyncExample {

    private val tag = "AsyncExample"

    fun backgroundExample() {

        // launch a new coroutine in background and continue
        MainScope().launch(context = Dispatchers.IO) {
            delay(1000L) // non-blocking delay for 1 second
            print("World!") // print after delay
        }
        print("Hello,") // main thread continues while coroutine is delayed
    }

    fun uiExample(handler: (String) -> Unit) {

        // UI changes should happen with Main Dispatcher
        MainScope().launch(context = Dispatchers.Main) {
            var result: Int
            val one = GlobalScope.async { doSomethingUsefulOne() }
            val two = GlobalScope.async { doSomethingUsefulTwo() }
            handler("""${one.isCompleted}, ${two.isCompleted}""")
            result = one.await() + two.await()
            handler("""$result""")
        }
    }

    fun uiNetworkExample(handler: (String) -> Unit) {

        MainScope().launch(context = Dispatchers.Main) {
            // Networking should happen on Dispatchers IO
            withContext(Dispatchers.IO) {
                val result = kotlin.runCatching {
                    URL("https://jsonplaceholder.typicode.com/users")
                        .openStream().bufferedReader().use { it.readText() }
                }
                result.onSuccess(handler)
                result.onFailure { handler(it.toString()) }
            }
        }
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }

}