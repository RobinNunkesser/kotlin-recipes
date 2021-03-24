package de.hshl.isd.core.ports

import de.hshl.isd.explicitarchitecture.Command

interface GetAnswerCommand : Command<String,String>