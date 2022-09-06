package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.data.datasources.PlayersApiDataSource
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.Flow

class PlayersApiRepository(val playersApiDataSource: PlayersApiDataSource = PlayersApiDataSource()) : PlayersRepository {

    private val fakeRepo = FakePlayersRepositories()

    override suspend fun getPlayers(): List<Player> {
        return playersApiDataSource.getPlayers()
    }

    override suspend fun deletePlayer(player: Player) {
        fakeRepo.deletePlayer(player)
    }

    override suspend fun addPlayer(player: Player, pos: Int) {
        fakeRepo.addPlayer(player, pos)
    }

    override fun observerUserPlayers(): Flow<List<Player>> {
        return fakeRepo.observerUserPlayers()
    }
}