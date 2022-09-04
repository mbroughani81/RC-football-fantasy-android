package com.rc.quokka.fantasyfootball.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rc.quokka.fantasyfootball.ui.authentication.screens.SignupScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.TeamCreationScreen

enum class FantasyFootballScreen() {
    Login,
    Signup,
    ConfirmCode,
    TeamCreation
}

@Composable
fun FantasyFootballApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FantasyFootballScreen.Signup.name,
        modifier = Modifier
    ) {
        composable(route = FantasyFootballScreen.Login.name) {

        }
        composable(route = FantasyFootballScreen.Signup.name) {
            SignupScreen()
        }
        composable(route = FantasyFootballScreen.ConfirmCode.name) {

        }
        composable(route = FantasyFootballScreen.ConfirmCode.name) {
            TeamCreationScreen()
        }
    }
}