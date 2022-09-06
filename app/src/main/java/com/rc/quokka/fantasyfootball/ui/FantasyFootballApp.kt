package com.rc.quokka.fantasyfootball.ui

import android.util.Log
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

@Composable
fun FantasyFootballApp(authenticationViewModel: AuthenticationViewModel = viewModel()) {
    val navController = rememberNavController()
    val isLoggedIn = authenticationViewModel.isLoggedIn.collectAsState()


//    Log.d("FantasyFootballApp", authenticationViewModel.uiState.value.toString())
    if (isLoggedIn.value) {
        navController.navigate(FantasyFootballScreen.TeamCreation.name)
    }

    NavHost(
        navController = navController,
        startDestination = FantasyFootballScreen.TeamCreation.name,
        modifier = Modifier
    ) {
        composable(route = FantasyFootballScreen.Signin.name) {
            SigninScreen(
                onSigninButtonClicked = {
                    authenticationViewModel.signinUser(it)
                }
            )
        }
        composable(route = FantasyFootballScreen.Signup.name) {
            SignupScreen(onSignupButtonClicked = { navController.navigate(FantasyFootballScreen.ConfirmCode.name) })
        }
        composable(route = FantasyFootballScreen.ConfirmCode.name) {
            ConfirmCodeScreen(onConfirmButtonClick = { navController.navigate(FantasyFootballScreen.Signin.name) })
        }
        composable(route = FantasyFootballScreen.TeamCreation.name) {
            TeamCreationScreen()
        }
    }
}