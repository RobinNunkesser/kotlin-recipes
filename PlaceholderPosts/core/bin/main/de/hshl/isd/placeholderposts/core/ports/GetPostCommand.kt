package de.hshl.isd.placeholderposts.core.ports

import de.hshl.isd.explicitarchitecture.Command

interface GetPostCommand :
    Command<PostIDDTO, String>