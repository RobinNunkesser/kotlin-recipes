import de.hshl.isd.placeholderposts.core.ConcreteGetPostCommand
import de.hshl.isd.placeholderposts.infrastructure.adapters.PostRepositoryAdapter

fun main(args: Array<String>) {
    val service = ConcreteGetPostCommand(PostRepositoryAdapter())
    println("Enter post ID:")
    val num = readLine()!!.toLong()
    println("Async fetch of post $num ... Press enter to exit.")
    service.execute(ConcretePostIDDTO(num),::success,::failure)
    readLine()
}

fun success(value: String) {
    println(value)
}

fun failure(error: Throwable) {
    println(error.localizedMessage)
}