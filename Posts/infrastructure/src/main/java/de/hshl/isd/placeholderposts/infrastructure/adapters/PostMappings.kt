package de.hshl.isd.placeholderposts.infrastructure.adapters

import de.hshl.isd.placeholderposts.core.ports.Post
import de.hshl.isd.posts.infrastructure.PlaceholderPost

fun PlaceholderPost.toPost(): Post {
    return PostEntity(this.userId, this.id, this.title, this.body)
}

fun Post.toPlaceholderPost(): PlaceholderPost {
    return PlaceholderPost(this.userID, this.id, this.title, this.body)
}