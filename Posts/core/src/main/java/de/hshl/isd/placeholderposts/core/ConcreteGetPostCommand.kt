package de.hshl.isd.placeholderposts.core

import de.hshl.isd.explicitarchitecture.Repository
import de.hshl.isd.placeholderposts.core.ports.GetPostCommand
import de.hshl.isd.placeholderposts.core.ports.PostIDDTO
import de.hshl.isd.placeholderposts.core.ports.Post
import kotlinx.coroutines.*

class ConcreteGetPostCommand(private val repository: Repository<Long, Post>) :
    GetPostCommand {
    override fun execute(
        inDTO: PostIDDTO,
        successHandler: (success: String) -> Unit,
        errorHandler: (error: Throwable) -> Unit
    ) {
        GlobalScope.launch {
                val result = kotlin.runCatching {
                    repository.retrieve(inDTO.id)
                }
                    result.onSuccess { successHandler(it.toString()) }
                    result.onFailure { errorHandler(it) }
        }
    }
}