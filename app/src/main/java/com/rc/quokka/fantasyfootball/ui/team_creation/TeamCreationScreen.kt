package com.rc.quokka.fantasyfootball.ui.team_creation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.ui.team_creation.components.*
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.DeletePlayerDialog
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamListScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamSchematicScreen
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import kotlinx.coroutines.launch

@Composable
fun TeamCreationScreen(teamCreationViewModel: TeamCreationViewModel = viewModel()) {
    val isOnSoccerFieldView = remember { mutableStateOf(true) }
    val deleteDialogCurrentPlayer = remember { mutableStateOf<Player?>(null) }
    val drawerCurrentPlayer = remember { mutableStateOf<Player?>(null) }
    val currentPlayerPos = remember { mutableStateOf<Int?>(null) }
    val uiState = teamCreationViewModel.uiState.collectAsState()

    FantasyFootballTheme {
        if (deleteDialogCurrentPlayer.value != null &&
            deleteDialogCurrentPlayer.value != NoGKPlayer &&
            deleteDialogCurrentPlayer.value != NoDEFPlayer &&
            deleteDialogCurrentPlayer.value != NoMIDPlayer &&
            deleteDialogCurrentPlayer.value != NoATTPlayer
        ) {
            DeletePlayerDialog(
                player = deleteDialogCurrentPlayer.value!!,
                onDeleteClickHandler = {
                    teamCreationViewModel.deletePlayer(deleteDialogCurrentPlayer.value!!)
                },
                onDismissHandler = { deleteDialogCurrentPlayer.value = null }
            )
        }
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Scaffold(
                scaffoldState = scaffoldState,
                drawerBackgroundColor = Color.Transparent,
                drawerContent = {
                    NavigationDrawerView(
                        onRandomButtonClickHandler = {
                            teamCreationViewModel.randomAddPlayer(
                                drawerCurrentPlayer.value!!,
                                currentPlayerPos.value!!
                            )
                        },
                        scaffoldState.drawerState
                    )
                },
                drawerGesturesEnabled = scaffoldState.drawerState.isOpen
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Column() {
                        Header(
                            modifier = Modifier
                                .weight(3f)
                        )
                        NavBar(modifier = Modifier.weight(1f))
                        WeekInfo(modifier = Modifier.weight(1f))
                        TeamViewTypeSwitch(
                            onClickListButtonHandler = { isOnSoccerFieldView.value = false },
                            onClickSchematicButtonHandle = { isOnSoccerFieldView.value = true },
                            modifier = Modifier.weight(3f)
                        )
                        Scaffold(
                            modifier = Modifier.weight(8f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TopBar(
                                    modifier = Modifier
                                        .height(75.dp)
                                        .zIndex(1f)
                                )
                                if (isOnSoccerFieldView.value) {
                                    TeamSchematicScreen(
                                        userPlayersList = uiState.value.usersPlayersList,
                                        onPlayerLongClickHandler = {
                                            deleteDialogCurrentPlayer.value = it
                                        }, modifier = Modifier
                                            .height(300.dp)
                                            .zIndex(2f),
                                        onPlayerClickHandler = { player, pos ->
                                            drawerCurrentPlayer.value = player
                                            currentPlayerPos.value = pos
                                            coroutineScope.launch { scaffoldState.drawerState.open() }
                                        }
                                    )
                                } else {
                                    TeamListScreen()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}