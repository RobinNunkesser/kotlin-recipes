import kotlinx.coroutines.*

class AsyncExample {

    private val tag = "AsyncExample"

    fun backgroundExample() {

        GlobalScope.launch {
            // launch a new coroutine in background and continue
            withContext(Dispatchers.IO) {
                delay(1000L) // non-blocking delay for 1 second
                print("World!") // log after delay
            }
        }
        print("Hello,") // main thread continues while coroutine is delayed
    }

    fun uiExample(handler: (String) -> Unit) {

        GlobalScope.launch {
            var result: Int
            val one = GlobalScope.async { doSomethingUsefulOne() }
            val two = GlobalScope.async { doSomethingUsefulTwo() }
            handler("""${one.isCompleted}, ${two.isCompleted}""")
            withContext(Dispatchers.IO) {
                result = one.await() + two.await()
                withContext(Dispatchers.Main) {
                    handler("""$result""")
                }
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