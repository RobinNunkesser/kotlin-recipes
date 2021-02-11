package de.hshl.isd.placeholderposts.infrastructure

data class PlaceholderPost(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)
