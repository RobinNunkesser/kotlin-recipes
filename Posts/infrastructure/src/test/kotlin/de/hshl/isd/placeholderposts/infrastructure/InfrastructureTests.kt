package de.hshl.isd.placeholderposts.infrastructure

import de.hshl.isd.placeholderposts.infrastructure.adapters.PostEntity
import de.hshl.isd.placeholderposts.infrastructure.adapters.PostRepositoryAdapter
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.internal.runners.statements.Fail

class InfrastructureTests {
    @Test
    fun readAllPosts() {
        val adapter = PostRepositoryAdapter()
        runBlocking {
            kotlin.runCatching {
                adapter.retrieveAll()
            }
                .onFailure { Fail(it) }
                .onSuccess {
                    Assert.assertEquals(100, it.count())
                }
        }
    }

    @Test
    fun readPost() {
        val adapter = PostRepositoryAdapter()
        runBlocking {
            kotlin.runCatching {
                adapter.retrieve(1)
            }
                .onFailure { Fail(it) }
                .onSuccess {
                    Assert.assertEquals(1, it.userID)
                    Assert.assertEquals(1, it.id)
                    Assert.assertTrue(it.title.startsWith("sunt aut facere"))
                    Assert.assertTrue(it.body.startsWith("quia et suscipit"))
                }
        }
    }

    @Test
    fun createPost() {
        val adapter = PostRepositoryAdapter()
        runBlocking {
            kotlin.runCatching {
                adapter.create(PostEntity(1, 1, "foo", "bar"))
            }
                .onFailure { Fail(it) }
                .onSuccess {
                    Assert.assertEquals(101, it)
                }
        }
    }

    @Test
    fun deletePost() {
        val adapter = PostRepositoryAdapter()
        runBlocking {
            kotlin.runCatching {
                adapter.delete(1)
            }
                .onFailure { Fail(it) }
                .onSuccess {
                    Assert.assertTrue(it)
                }
        }
    }

    @Test
    fun updatePost() {
        val adapter = PostRepositoryAdapter()
        runBlocking {
            kotlin.runCatching {
                adapter.update(1, PostEntity(1, 1, "foo", "bar"))
            }
                .onFailure { Fail(it) }
                .onSuccess {
                    Assert.assertTrue(it)
                }
        }
    }
}



