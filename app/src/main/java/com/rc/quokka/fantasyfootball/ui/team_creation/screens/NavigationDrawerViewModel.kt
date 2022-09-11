package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakePlayersRepositories
import com.rc.quokka.fantasyfootball.data.repositories.PlayersApiRepository
import com.rc.quokka.fantasyfootball.domain.model.GetPlayerData
import com.rc.quokka.fantasyfootball.domain.model.NoToken
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.Token
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NavigationDrawerViewModel(private val playersRepository: PlayersRepository = PlayersApiRepository()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(NavigationDrawerUiState(emptyList(), 1))
    var token: Token = NoToken
    val uiState = _uiState.asStateFlow()

    fun updateTable() {
        viewModelScope.launch {
            val newState = NavigationDrawerUiState(
                playersList = playersRepository.getPlayers(GetPlayerData(limit = 10, uiState.value.pageNumber)),
                pageNumber = uiState.value.pageNumber
            )
            _uiState.value = newState
            Log.d("NavigationDrawegg", uiState.value.playersList.toString())
        }
    }

    fun goNextPage() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(pageNumber = _uiState.value.pageNumber + 1)
            updateTable()
        }
    }

    fun goPrevPage() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(pageNumber = _uiState.value.pageNumber - 1)
            updateTable()
        }
    }
}

data class NavigationDrawerUiState(val playersList: List<Player>, val pageNumber: Int)