package com.rc.quokka.fantasyfootball.data.repositories

import android.util.Log
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakePlayersRepositories : PlayersRepository {

    var userPlayers = MutableStateFlow(listOf<Player>())

    override suspend fun getPlayers(): List<Player> {
//        TODO("Not yet implemented")
        delay(3000)
        return fakeAllPlayers
    }

    override suspend fun deletePlayer(player: Player, playersList: List<Player>) {
//        TODO("Not yet implemented")
        delay(3000)
        val newPlayersList = playersList.filter { player.id != it.id }
        userPlayers.value = newPlayersList
    }

    override suspend fun addPlayer(player: Player, playersList: List<Player>) {
//        TODO("Not yet implemented")
    }

    override fun observerUserPlayers(): Flow<List<Player>> = userPlayers
}

private val fakeAllPlayers: List<Player> =
    listOf(
        Player("gk1", "gk1", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk2", "gk2", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk3", "gk3", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk4", "gk4", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk5", "gk5", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk6", "gk6", PlayerRole.GoalKeeper, 0, 0f),
        Player("def1", "def1", PlayerRole.Defender, 0, 0f),
        Player("def2", "def2", PlayerRole.Defender, 0, 0f),
        Player("def3", "def3", PlayerRole.Defender, 0, 0f),
        Player("def4", "def4", PlayerRole.Defender, 0, 0f),
        Player("def5", "def5", PlayerRole.Defender, 0, 0f),
        Player("mid1", "mid1", PlayerRole.Midfielder, 0, 0f),
        Player("mid2", "mid2", PlayerRole.Midfielder, 0, 0f),
        Player("mid3", "mid3", PlayerRole.Midfielder, 0, 0f),
        Player("mid4", "mid4", PlayerRole.Midfielder, 0, 0f),
        Player("mid5", "mid5", PlayerRole.Midfielder, 0, 0f),
        Player("att1", "att1", PlayerRole.Attacker, 0, 0f),
        Player("att2", "att2", PlayerRole.Attacker, 0, 0f),
        Player("att3", "att3", PlayerRole.Attacker, 0, 0f),
        Player("att4", "att4", PlayerRole.Attacker, 0, 0f),
    )

private val fakeUsersPlayersList = mutableListOf(
    Player("gk1", "gk1", PlayerRole.GoalKeeper, 0, 0f),
    NoGKPlayer,
    Player("def1", "def1", PlayerRole.Defender, 0, 0f),
    NoDEFPlayer,
    NoDEFPlayer,
    Player("def4", "def4", PlayerRole.Defender, 0, 0f),
    Player("def5", "def5", PlayerRole.Defender, 0, 0f),
    Player("mid1", "mid1", PlayerRole.Midfielder, 0, 0f),
    Player("mid2", "mid2", PlayerRole.Midfielder, 0, 0f),
    Player("mid3", "mid3", PlayerRole.Midfielder, 0, 0f),
    NoMIDPlayer,
    NoMIDPlayer,
    Player("att1", "att1", PlayerRole.Attacker, 0, 0f),
    Player("att2", "att2", PlayerRole.Attacker, 0, 0f),
    Player("att3", "att3", PlayerRole.Attacker, 0, 0f)
)
