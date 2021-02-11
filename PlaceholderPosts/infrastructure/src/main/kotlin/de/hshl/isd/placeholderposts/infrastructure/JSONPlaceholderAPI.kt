package de.hshl.isd.placeholderposts.infrastructure

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JSONPlaceholderAPI {

    @GET("posts/{id}")
    fun readPost(@Path("id") id: Long): Call<PlaceholderPost>

    @GET("posts")
    fun readAllPosts(): Call<List<PlaceholderPost>>

    @POST("posts")
    fun createPost(@Body post: PlaceholderPost): Call<PlaceholderPost>

}

