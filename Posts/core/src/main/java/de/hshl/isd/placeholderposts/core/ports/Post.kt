package de.hshl.isd.placeholderposts.core.ports

interface Post {
    val userID: Long
    val id: Long
    val title: String
    val body: String
}
