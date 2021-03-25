package de.hshl.isd.posts

import de.hshl.isd.placeholderposts.core.ports.PostIDDTO

data class ConcretePostIDDTO(override val id: Long) : PostIDDTO