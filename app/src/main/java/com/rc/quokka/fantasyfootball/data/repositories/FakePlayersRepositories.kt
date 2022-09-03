package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayersList
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.delay

class FakePlayersRepositories : PlayersRepository {
    override suspend fun getPlayers(): PlayersList {
//        TODO("Not yet implemented")
        delay(5000)
        return getPlayersList()
    }
}

private fun getPlayersList(): PlayersList = PlayersList(
    listOf(
        Player("gk1", "5", 0, 0f),
        Player("gk2", "3", 0, 0f)
    ), listOf(
        Player("def1", "5", 0, 0f),
    ),
    listOf(
        Player("mid1", "3", 0, 0f),
        Player("mid2", "3", 0, 0f)
    ),
    listOf(
        Player("att1", "3", 0, 0f),
    )
)
