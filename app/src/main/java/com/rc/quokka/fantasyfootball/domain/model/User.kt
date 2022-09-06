package com.rc.quokka.fantasyfootball.domain.model

data class User(val username: String)

val AnonymousUser = User(username = "anonymous")
