package de.hshl.isd.placeholderposts.infrastructure.adapters

import de.hshl.isd.explicitarchitecture.Repository
import de.hshl.isd.placeholderposts.core.ports.Post
import de.hshl.isd.posts.infrastructure.JSONPlaceholderService

class PostRepositoryAdapter : Repository<Long, Post> {

    var service = JSONPlaceholderService()

    override suspend fun create(entity: Post): Long {
        val response = service.createPost(entity.toPlaceholderPost()).execute()
        return response.body()!!.id
    }

    override suspend fun retrieve(id: Long): Post {
        val response = service.readPost(id).execute()
        return response.body()!!.toPost()
    }

    override suspend fun retrieveAll(): List<Post> {
        val response = service.readAllPosts().execute()
        return response.body()!!.map { it.toPost() }
    }

    override suspend fun update(id: Long, entity: Post): Boolean {
        val response = service.updatePost(id, entity.toPlaceholderPost()).execute()
        return response.body()!!.id == id
    }

    override suspend fun delete(id: Long): Boolean {
        service.deletePost(id).execute()
        return true
    }
}