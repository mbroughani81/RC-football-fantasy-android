package com.rc.quokka.fantasyfootball.domain.model

enum class PlayerFilter {
    All,
    GoalKeeper,
    Defender,
    Midfielder,
    Attacker
}

data class GetPlayerData(val limit: Int,val pageNumber: Int)