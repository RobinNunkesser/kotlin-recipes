import kotlinx.coroutines.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class AsyncExample {

    private val tag = "AsyncExample"

    fun backgroundExample() {

        // launch a new coroutine in background and continue
        GlobalScope.launch(context = Dispatchers.IO) {
            delay(1000L) // non-blocking delay for 1 second
            print("World!") // print after delay
        }
        print("Hello,") // main thread continues while coroutine is delayed
    }

    fun uiExample(handler: (String) -> Unit) {

        // UI changes should happen with Main Dispatcher
        GlobalScope.launch(context = Dispatchers.Main) {
            var result: Int
            val one = GlobalScope.async { doSomethingUsefulOne() }
            val two = GlobalScope.async { doSomethingUsefulTwo() }
            handler("""${one.isCompleted}, ${two.isCompleted}""")
            result = one.await() + two.await()
            handler("""$result""")
        }
    }

    fun uiNetworkExample(handler: (String) -> Unit) {

        GlobalScope.launch(context = Dispatchers.Main) {
            val response = GlobalScope.async { getData(URI.create("https://jsonplaceholder.typicode.com/users")) }
            handler("""${response.isCompleted}""")
            // Networking should happen on Dispatchers IO
            withContext(Dispatchers.IO) {
                val result = response.await()
                withContext(Dispatchers.Main) {
                    handler("""$result""")
                }
            }
        }
    }

    private suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    private suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }

    private fun getData(uri: URI): String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(uri)
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
}