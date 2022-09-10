package com.rc.quokka.fantasyfootball.ui

import android.util.Log
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rc.quokka.fantasyfootball.data.datasources.ConfirmCodeResponse
import com.rc.quokka.fantasyfootball.data.datasources.SignupResponse
import com.rc.quokka.fantasyfootball.data.repositories.UsersApiRepository
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AuthenticationViewModel(val usersRepository: UsersRepository = UsersApiRepository()) :
    ViewModel() {
    private val _uiState =
        MutableStateFlow(AuthenticationUiState(currentUser = AnonymousUser, currentEmail = "",isLoggedIn = false))
    val uiState = _uiState.asStateFlow()

    fun signinUser(data: SigninData) {
        viewModelScope.launch {
            val result = usersRepository.signinUser(data)
            when (result) {
                is Result.Success -> {
                    when (result.value) {
                        is SigninVerdict.SigninSuccessful -> {
                            _uiState.value =
                                AuthenticationUiState(
                                    currentUser = User("1234"), currentEmail = "" ,isLoggedIn = true
                                )
                        }
                        is SigninVerdict.SigninFailed -> {
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

    fun signupUser(data: SignupData, onSuccess: () -> Unit, onFail: () -> Unit) {
        viewModelScope.launch {
            val result = usersRepository.signupUser(data)
            Log.d("signupUser", "HUUUMMM")
            when (result) {
                is Result.Success -> {
                    when (result.value) {
                        is SignupVerdict.SignupSuccessful -> {
                            Log.d("signupUser", data.email)
                            _uiState.value =  _uiState.value.copy(currentEmail = data.email)
                            onSuccess()
                        }
                        is SignupVerdict.SignupFailed -> {
                            Log.d("signupUser", "shit1")
                            onFail()
                        }
                    }
                }
                is Result.Error -> {
                    Log.d("signupUser", "shit2")
                }
            }
        }
    }

    fun confirmCode(data: ConfirmCodeData, onSuccess: () -> Unit, onFail: () -> Unit) {
        viewModelScope.launch {
            val result = usersRepository.confirmCode(data)
            when (result) {
                is Result.Success -> {
                    when (result.value) {
                        is ConfirmCodeVerdict.ConfirmCodeSuccessful -> {
                            onSuccess()
                        }
                        is ConfirmCodeVerdict.ConfirmCodeFailed -> {
                            onFail()
                        }
                    }
                }
                is Result.Error -> {

                }
            }
        }
    }
}

data class AuthenticationUiState(
    val currentUser: User,
    val currentEmail: String,
    val isLoggedIn: Boolean
)
