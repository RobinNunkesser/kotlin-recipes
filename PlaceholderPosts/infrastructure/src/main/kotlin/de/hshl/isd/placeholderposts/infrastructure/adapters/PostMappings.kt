package de.hshl.isd.placeholderposts.infrastructure.adapters

import de.hshl.isd.placeholderposts.infrastructure.PlaceholderPost
import de.hshl.isd.placeholderposts.infrastructure.common.Post

fun PlaceholderPost.toPostEntity(): Post {
    return PostEntity(this.userId, this.id, this.title, this.body)
}

fun Post.toPost(): PlaceholderPost {
    return PlaceholderPost(this.userID, this.id, this.title, this.body)
}