package com.rc.quokka.fantasyfootball.domain.model

data class Player(val name: String, val role: String, val rating: Int, val price: Float)

data class PlayersList(
    val GKPlayers: List<Player>,
    val DEFPlayers: List<Player>,
    val MIDPlayers: List<Player>,
    val ATTPlayers: List<Player>
)
