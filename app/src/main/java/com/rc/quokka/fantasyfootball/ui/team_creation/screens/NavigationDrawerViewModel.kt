package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.domain.model.PlayersList
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NavigationDrawerViewModel(playersRepository: PlayersRepository = FakePlayersRepositories()) :
    ViewModel() {
        private val _uiState = MutableStateFlow(NavigationDrawerUiState(PlayersList(emptyList(), emptyList(), emptyList(), emptyList())))
        val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val newState = NavigationDrawerUiState(playersList = playersRepository.getPlayers())
            _uiState.value = newState
        }
    }
}

data class NavigationDrawerUiState(val playersList: PlayersList)