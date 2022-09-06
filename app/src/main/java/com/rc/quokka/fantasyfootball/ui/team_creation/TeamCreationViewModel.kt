package com.rc.quokka.fantasyfootball.ui.team_creation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamCreationViewModel(private val playersRepository: PlayersRepository = FakePlayersRepositories()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(TeamCreationUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.d("TeamSchematicViewModel", "scope started")

            playersRepository.observerUserPlayers().collect {
                Log.d("TeamSchematicViewModel", "emitted")
                _uiState.value = TeamCreationUiState(usersPlayersList = it)
            }

        }
    }

    fun deletePlayer(player: Player) {
        viewModelScope.launch {
            playersRepository.deletePlayer(player)
        }
    }
}

data class TeamCreationUiState(val usersPlayersList: List<Player>)