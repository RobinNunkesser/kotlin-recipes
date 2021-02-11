package de.hshl.isd.placeholderposts.infrastructure.adapters

import de.hshl.isd.explicitarchitecture.Repository
import de.hshl.isd.placeholderposts.infrastructure.JSONPlaceholderService
import de.hshl.isd.placeholderposts.infrastructure.common.Post

class PostRepositoryAdapter : Repository<Long, Post> {

    var service = JSONPlaceholderService()

    override suspend fun create(entity: Post): Long {
        val response = service.createPost(entity.toPost()).execute()
        return response.body()!!.id
    }

    override suspend fun retrieve(id: Long): Post {
        val response = service.readPost(id).execute()
        return response.body()!!.toPostEntity()
    }

    override suspend fun retrieveAll(): List<Post> {
        val response = service.readAllPosts().execute()
        return response.body()!!.map { it.toPostEntity() }
    }

    override suspend fun update(id: Long, entity: Post): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Long): Boolean {
        TODO("Not yet implemented")
    }
}