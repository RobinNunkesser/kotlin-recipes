package de.hshl.isd.placeholderposts.infrastructure.common

interface Post {
    val userID: Long
    val id: Long
    val title: String
    val body: String
}
