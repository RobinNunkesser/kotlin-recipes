package de.hshl.isd.asynccompose

import kotlinx.coroutines.*
import java.net.URL

class AsyncExample {

    private val tag = "AsyncExample"

    suspend fun readFromNetwork() : String {
        // Networking must happen on Dispatchers IO
        return withContext(Dispatchers.IO) {
            URL("https://jsonplaceholder.typicode.com/users")
                .openStream().bufferedReader().use { it.readText() }
        }
    }

    suspend fun asyncCalculation() : Int {
        return doSomethingUsefulOne() + doSomethingUsefulTwo()
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(500L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }

}