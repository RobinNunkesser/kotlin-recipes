package de.hshl.isd.placeholderposts.core

import de.hshl.isd.placeholderposts.core.ports.GetPostCommand
import de.hshl.isd.placeholderposts.core.ports.PostIDDTO
import de.hshl.isd.placeholderposts.core.ports.Post
import io.github.italbytz.ports.common.CrudRepository
import kotlinx.coroutines.*

class ConcreteGetPostCommand(private val repository: CrudRepository<Long, Post>) :
    GetPostCommand {

    override suspend fun execute(inDTO: PostIDDTO): String {
        return (repository.retrieve(inDTO.id)).toString()
    }

}