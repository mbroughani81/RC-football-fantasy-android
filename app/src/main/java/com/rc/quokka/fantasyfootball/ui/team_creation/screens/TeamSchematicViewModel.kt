package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TeamSchematicViewModel(private val playersRepository: PlayersRepository = FakePlayersRepositories()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(TeamSchematicUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.d("TeamSchematicViewModel", "scope started")

            playersRepository.observerUserPlayers().collect {
                Log.d("TeamSchematicViewModel", "emitted")
                _uiState.value = TeamSchematicUiState(usersPlayersList = it)
            }

        }
    }
//    val userPlayersList = playersRepository.observerUsersPlayers().stateIn(
//        viewModelScope,
//        SharingStarted.Eagerly,
//        emptyList()
//    )

//    fun getGoalKeepers(): List<Player> {
//        val goalKeepers: MutableList<Player> = mutableListOf()
//        for (player in players) {
//            if (player.role == PlayerRole.GoalKeeper) {
//                goalKeepers.add(player)
//            }
//        }
//        return goalKeepers
//    }
//
//    fun getDefenders(players: List<Player>): List<Player> {
//        val defenders: MutableList<Player> = mutableListOf()
//        for (player in players) {
//            if (player.role == PlayerRole.GoalKeeper) {
//                defenders.add(player)
//            }
//        }
//        return defenders
//    }
//
//    fun getMidfielders(players: List<Player>): List<Player> {
//        val midfielders: MutableList<Player> = mutableListOf()
//        for (player in players) {
//            if (player.role == PlayerRole.GoalKeeper) {
//                midfielders.add(player)
//            }
//        }
//        return midfielders
//    }
//
//    fun getAttackers(players: List<Player>): List<Player> {
//        val attackers: MutableList<Player> = mutableListOf()
//        for (player in players) {
//            if (player.role == PlayerRole.GoalKeeper) {
//                attackers.add(player)
//            }
//        }
//        return attackers
//    }
}
data class TeamSchematicUiState(val usersPlayersList: List<Player>)