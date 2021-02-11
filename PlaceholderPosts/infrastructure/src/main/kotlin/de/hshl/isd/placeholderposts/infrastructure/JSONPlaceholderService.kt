package de.hshl.isd.placeholderposts.infrastructure

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JSONPlaceholderService : JSONPlaceholderAPI {

    val retrofit =
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    var service: JSONPlaceholderAPI = retrofit.create(JSONPlaceholderAPI::class.java)

    override fun readPost(id: Long): Call<PlaceholderPost> = service.readPost(id)

    override fun readAllPosts(): Call<List<PlaceholderPost>> = service.readAllPosts()

    override fun createPost(post: PlaceholderPost): Call<PlaceholderPost> = service.createPost(post)
}