package com.rc.quokka.fantasyfootball.ui

import android.util.Log
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.repositories.FakeUsersRepository
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AuthenticationViewModel(val usersRepository: UsersRepository = FakeUsersRepository()) :
    ViewModel() {
    private val _uiState =
        MutableStateFlow(AuthenticationUiState(currentUser = AnonymousUser, isLoggedIn = false))
    val uiState = _uiState.asStateFlow()

    fun signinUser(data: SigninData) {
        viewModelScope.launch {
            val result = usersRepository.signinUser(data)
            when (result) {
                is Result.Success -> {
                    val data = result.data
                    when (data) {
                        is SigninResponse.SigninSuccessful -> {
                            _uiState.value =
                                AuthenticationUiState(
                                    currentUser = User(data.user.username), isLoggedIn = true
                                )
                        }
                        is SigninResponse.SigninError -> {
                            Log.d("AuthenticationViewModel", "login is unsuccessful")
                        }
                    }
                }
                is Result.Error -> {
                    Log.d("AuthenticationViewModel", "error in connection")
                }
            }
        }
    }

    fun signupUser(data: SignupData) {

    }

    fun confirmCode(data: ConfirmCodeData) {

    }
}

data class AuthenticationUiState(
    val currentUser: User,
    val isLoggedIn: Boolean
)
