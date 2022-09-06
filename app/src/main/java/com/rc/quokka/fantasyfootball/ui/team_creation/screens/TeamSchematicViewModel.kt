package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.lifecycle.ViewModel
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TeamSchematicViewModel(private val playersRepository: PlayersRepository = FakePlayersRepositories()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(TeamSchematicUiState(emptyList()))
    val uiState = _uiState.asStateFlow()
    val allPlayersList = usersPlayersList
    private val defenders: MutableList<Player> = mutableListOf()
    private val midfielders: MutableList<Player> = mutableListOf()
    private val attackers: MutableList<Player> = mutableListOf()

    fun getGoalKeepers(players: List<Player>): List<Player> {
        val goalKeepers: MutableList<Player> = mutableListOf()
        for (player in players) {
            if (player.role == PlayerRole.GoalKeeper){
                goalKeepers.add(player)
            }
        }
        return goalKeepers
    }

    fun getDefenders(players: List<Player>): List<Player> {
        val defenders: MutableList<Player> = mutableListOf()
        for (player in players) {
            if (player.role == PlayerRole.GoalKeeper){
                defenders.add(player)
            }
        }
        return defenders
    }

    fun getMidfielders(players: List<Player>): List<Player> {
        val midfielders: MutableList<Player> = mutableListOf()
        for (player in players) {
            if (player.role == PlayerRole.GoalKeeper){
                midfielders.add(player)
            }
        }
        return midfielders
    }

    fun getAttackers(players: List<Player>): List<Player> {
        val attackers: MutableList<Player> = mutableListOf()
        for (player in players) {
            if (player.role == PlayerRole.GoalKeeper){
                attackers.add(player)
            }
        }
        return attackers
    }


//    private val _GKPlayers = _allPlayersList.
//    val GKPlayers: List<Player?>
//        get() = _GKPlayers
//
//    private val _DEFPlayers = _allPlayersList.DEFPlayers
//    val DEFPlayers: List<Player?>
//        get() = _DEFPlayers
//
//    private val _MIDPlayers = _allPlayersList.MIDPlayers
//    val MIDPlayers: List<Player?>
//        get() = _MIDPlayers
//
//    private val _ATTPlayers = _allPlayersList.ATTPlayers
//    val ATTPlayers: List<Player?>
//        get() = _ATTPlayers
}

//data class PlayersList(
//    val GKPlayers: List<Player?>,
//    val DEFPlayers: List<Player?>,
//    val MIDPlayers: List<Player?>,
//    val ATTPlayers: List<Player?>
//)
private fun getGoalKeepers(players: List<Player>) {
    val goalKeepers : MutableList<Player> = mutableListOf()
    for (player in players) {
        if (player.role == PlayerRole.GoalKeeper){
            goalKeepers.add(player)
        }
    }
}

private val usersPlayersList = listOf(
        Player("gk1", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk2",PlayerRole.GoalKeeper, 0, 8f),
        Player("def1", PlayerRole.Defender, 0, 0f),
        Player("def2", PlayerRole.Defender, 6, 13f),
        Player("mid1", PlayerRole.Midfielder, 0, 0f),
        Player("mid2", PlayerRole.Midfielder, 0, 0f),
        Player("hanif", PlayerRole.Attacker, 4, 5.5f),
        Player("att1", PlayerRole.Attacker, 0, 0f) )

data class TeamSchematicUiState(val usersPlayersList: List<Player>)