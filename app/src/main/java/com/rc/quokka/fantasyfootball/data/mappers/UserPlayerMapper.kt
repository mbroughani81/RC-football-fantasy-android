package com.rc.quokka.fantasyfootball.data.mappers

import com.rc.quokka.fantasyfootball.data.datasources.PlayerDto
import com.rc.quokka.fantasyfootball.data.datasources.UserPlayerDto
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.model.Post

class UserPlayerMapper {
    fun toDomain(userPlayerDto: UserPlayerDto): Post {
        val (
            playerId: String,
            _,
            _,
            webName: String,
            _,
            positionId: Int,
            squadPlace: Int,
            _,
            price: Float,
            score: Int
        ) = userPlayerDto
        val role : PlayerRole = when (positionId) {
            1 -> PlayerRole.GoalKeeper
            2 -> PlayerRole.Defender
            3 -> PlayerRole.Midfielder
            4 -> PlayerRole.Attacker
            else -> {
                PlayerRole.GoalKeeper}
        }
        val pos = when(squadPlace) {
            in 1..2 -> squadPlace
            in 3..7 -> squadPlace - 2
            in 8..12 -> squadPlace - 7
            in 13..15 -> squadPlace - 12
            else -> -1
        }
        return Post(pos, Player(id = playerId, name = webName, role = role, rating = score, price = price))
    }
}