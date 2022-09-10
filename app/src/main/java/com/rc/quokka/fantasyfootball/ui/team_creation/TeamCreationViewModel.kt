package com.rc.quokka.fantasyfootball.ui.team_creation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.PlayersApiRepository
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamCreationViewModel(
    private val playersRepository: PlayersRepository = PlayersApiRepository())
    : ViewModel() {
    private val _uiState = MutableStateFlow(TeamCreationUiState(emptyList(), 0))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.d("TeamSchematicViewModel", "scope started")

            playersRepository.observerUserPosts().collect {
                Log.d("TeamSchematicViewModel", "emitted")
                _uiState.value = _uiState.value.copy(userPostsList = it)
            }
//            _uiState.value = TeamCreationUiState(userPostsList = userPostsList)
        }
        viewModelScope.launch {
            playersRepository.observerUserMoney().collect {
                _uiState.value = _uiState.value.copy(userMoney = it)
            }
        }
    }

    fun clearPost(post: Post) {
        viewModelScope.launch {
            playersRepository.clearPost(post)
        }
    }

    fun fillPost(post: Post, player: Player) {
        viewModelScope.launch {
            playersRepository.fillPost(post = post, player = player)
        }
    }

    fun randomFillPost(post: Post) {
        viewModelScope.launch {
            if (playersRepository.getPlayers().filter { it.role == post.player.role }.size > 0) {
                val newPlayer =
                    playersRepository.getPlayers().filter { it.role == post.player.role }.random()
                fillPost(post = post, player = newPlayer)
            }
        }
    }
}

data class TeamCreationUiState(val userPostsList: List<Post>, val userMoney: Int)