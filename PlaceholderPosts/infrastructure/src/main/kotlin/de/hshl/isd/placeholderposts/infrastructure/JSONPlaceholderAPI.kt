package de.hshl.isd.placeholderposts.infrastructure

import retrofit2.Call
import retrofit2.http.*

interface JSONPlaceholderAPI {

    @GET("posts/{id}")
    fun readPost(@Path("id") id: Long): Call<PlaceholderPost>

    @GET("posts")
    fun readAllPosts(): Call<List<PlaceholderPost>>

    @POST("posts")
    fun createPost(@Body post: PlaceholderPost): Call<PlaceholderPost>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Long, @Body post: PlaceholderPost): Call<PlaceholderPost>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Long): Call<Void>

}

