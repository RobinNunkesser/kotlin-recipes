package de.hshl.isd.placeholderposts.infrastructure.adapters

import de.hshl.isd.placeholderposts.core.ports.Post

data class PostEntity(
    override val userID: Long,
    override val id: Long,
    override val title: String,
    override val body: String
) : Post
