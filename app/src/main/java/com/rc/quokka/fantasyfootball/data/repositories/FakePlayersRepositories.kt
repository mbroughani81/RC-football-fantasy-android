package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.delay

class FakePlayersRepositories : PlayersRepository {
    override suspend fun getPlayers(): List<Player> {
//        TODO("Not yet implemented")
        delay(5000)
        return allPlayers
    }

    override suspend fun deletePlayer(player: Player, playersList: List<Player>) {
//        TODO("Not yet implemented")
        delay(5000)
    }

    override suspend fun addPlayer(player: Player, playersList: List<Player>) {
//        TODO("Not yet implemented")
    }

    override suspend fun getUsersPlayers(): List<Player> {
        delay(5000)
        return usersPlayersList
    }
}

private val allPlayers: List<Player> =
    listOf(
        Player("gk1", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk2", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk3", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk4", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk5", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk6", PlayerRole.GoalKeeper, 0, 0f),
        Player("def1", PlayerRole.Defender, 0, 0f),
        Player("def2", PlayerRole.Defender, 0, 0f),
        Player("def3", PlayerRole.Defender, 0, 0f),
        Player("def4", PlayerRole.Defender, 0, 0f),
        Player("def5", PlayerRole.Defender, 0, 0f),
        Player("def6",PlayerRole.Defender, 0, 0f),
        Player("def7", PlayerRole.Defender, 0, 0f),
        Player("mid1", PlayerRole.Midfielder, 0, 0f),
        Player("mid2", PlayerRole.Midfielder, 0, 0f),
        Player("mid3", PlayerRole.Midfielder, 0, 0f),
        Player("mid4", PlayerRole.Midfielder, 0, 0f),
        Player("mid5", PlayerRole.Midfielder, 0, 0f),
        Player("mid6", PlayerRole.Midfielder, 0, 0f),
        Player("mid7", PlayerRole.Midfielder, 0, 0f),
        Player("att1", PlayerRole.Attacker, 0, 0f),
        Player("att2", PlayerRole.Attacker, 0, 0f),
        Player("att3", PlayerRole.Attacker, 0, 0f),
        Player("att4", PlayerRole.Attacker, 0, 0f),
        Player("att5", PlayerRole.Attacker, 0, 0f),
        Player("att6", PlayerRole.Attacker, 0, 0f),
        Player("att7", PlayerRole.Attacker, 0, 0f),
        Player("att8", PlayerRole.Attacker, 0, 0f),
        Player("att9", PlayerRole.Attacker, 0, 0f),
    )

private val usersPlayersList = listOf(
    Player("gk1", PlayerRole.GoalKeeper, 0, 0f),
    Player("gk2",PlayerRole.GoalKeeper, 0, 8f),
    Player("def1", PlayerRole.Defender, 0, 0f),
    Player("def2", PlayerRole.Defender, 6, 13f),
    Player("mid1", PlayerRole.Midfielder, 0, 0f),
    Player("mid2", PlayerRole.Midfielder, 0, 0f),
    Player("hanif", PlayerRole.Attacker, 4, 5.5f),
    Player("att1", PlayerRole.Attacker, 0, 0f) )
