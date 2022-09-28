package de.hshl.isd.placeholderposts.core.ports

import io.github.italbytz.ports.common.Command

interface GetPostCommand : Command<PostIDDTO, String>