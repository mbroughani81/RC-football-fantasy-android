package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayersRepository {
    suspend fun getPlayers(): List<Player>
    
    suspend fun deletePlayer(player: Player, playersList: List<Player>)

    suspend fun addPlayer(player: Player, playersList: List<Player>)

    fun observerUserPlayers(): Flow<List<Player>>
}