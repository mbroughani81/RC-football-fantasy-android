package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.data.repositories.PlayersApiRepository
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NavigationDrawerViewModel(private val playersRepository: PlayersRepository = PlayersApiRepository()) :
    ViewModel() {
        private val _uiState = MutableStateFlow(NavigationDrawerUiState(emptyList()))
        val uiState = _uiState.asStateFlow()

    fun updateTable() {
        viewModelScope.launch {
            val newState = NavigationDrawerUiState(playersList = playersRepository.getPlayers())
            _uiState.value = newState
            Log.d("NavigationDrawegg", uiState.value.playersList.toString())
        }
    }
}

data class NavigationDrawerUiState(val playersList: List<Player>)