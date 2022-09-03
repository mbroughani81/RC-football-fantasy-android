package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.PlayersList

interface PlayersRepository {
    suspend fun getPlayers(): PlayersList
}