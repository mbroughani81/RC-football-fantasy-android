package com.rc.quokka.fantasyfootball.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun FantasyFootballApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FantasyFootballScreen.TeamCreation.name,
        modifier = Modifier
    ) {
        composable(route = FantasyFootballScreen.Signin.name) {
            SigninScreen(onSigninButtonClicked = { navController.navigate(FantasyFootballScreen.TeamCreation.name) })
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