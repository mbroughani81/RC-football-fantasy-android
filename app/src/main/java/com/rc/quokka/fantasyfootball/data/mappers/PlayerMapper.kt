package com.rc.quokka.fantasyfootball.data.mappers

import com.rc.quokka.fantasyfootball.data.datasources.PlayerDto
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole

class PlayerMapper {
    fun toDomain(playerDto: PlayerDto): Player {
        val (
            playerId: String,
            _,
            _,
            webName: String,
            _,
            positionId: Int,
            _,
            price: Float,
            score: Int
        ) = playerDto
        val role : PlayerRole = when (positionId) {
            1 -> PlayerRole.GoalKeeper
            2 -> PlayerRole.Defender
            3 -> PlayerRole.Midfielder
            4 -> PlayerRole.Attacker
            else -> {PlayerRole.GoalKeeper}
        }
        return Player(id = playerId, name = webName, role = role, rating = score, price = price)
    }
}