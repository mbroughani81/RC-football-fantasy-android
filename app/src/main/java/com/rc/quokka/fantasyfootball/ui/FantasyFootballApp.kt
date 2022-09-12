package com.rc.quokka.fantasyfootball.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rc.quokka.fantasyfootball.domain.model.AnonymousUser
import com.rc.quokka.fantasyfootball.domain.model.SigninData
import com.rc.quokka.fantasyfootball.ui.authentication.ConfirmCodeScreen
import com.rc.quokka.fantasyfootball.ui.authentication.screens.SigninScreen
import com.rc.quokka.fantasyfootball.ui.authentication.screens.SignupScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.TeamCreationScreen

enum class FantasyFootballScreen() {
    Signin,
    Signup,
    ConfirmCode,
    TeamCreation
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FantasyFootballApp(authenticationViewModel: AuthenticationViewModel = viewModel()) {
    val navController = rememberNavController()
    val authenticationUiState = authenticationViewModel.uiState.collectAsState()
    val isLoggedIn = authenticationUiState.value.isLoggedIn

    if (isLoggedIn) {
        navController.navigate(FantasyFootballScreen.TeamCreation.name)
    }

    NavHost(
        navController = navController,
        startDestination = FantasyFootballScreen.Signin.name,
        modifier = Modifier
    ) {
        composable(route = FantasyFootballScreen.Signin.name) {
            SigninScreen(
                onSigninButtonClicked = {
                    authenticationViewModel.signinUser(it)
                },
                onSignupButtonClicked = {
                    navController.navigate(FantasyFootballScreen.Signup.name)
                }
            )
        }
        composable(route = FantasyFootballScreen.Signup.name) {
            SignupScreen(onSignupButtonClicked = { data ->
                authenticationViewModel.signupUser(
                    data,
                    { navController.navigate(FantasyFootballScreen.ConfirmCode.name) },
                    onFail = {})
            })
        }
        composable(route = FantasyFootballScreen.ConfirmCode.name) {
            Log.d("currentEmail", authenticationUiState.value.currentEmail)
            ConfirmCodeScreen(currentEmail = authenticationUiState.value.currentEmail,onConfirmButtonClick = { data ->
                authenticationViewModel.confirmCode(
                    data,
                    { navController.navigate(FantasyFootballScreen.Signin.name) },
                    onFail = {}
                )
            })
        }
        composable(route = FantasyFootballScreen.TeamCreation.name) {
            TeamCreationScreen()
        }
    }
}