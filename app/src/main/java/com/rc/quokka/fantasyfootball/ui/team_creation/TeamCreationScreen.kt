package com.rc.quokka.fantasyfootball.ui.team_creation

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

@ExperimentalFoundationApi
@Composable
fun TeamCreationScreen(token: Token, teamCreationViewModel: TeamCreationViewModel = viewModel()) {
    val isOnSoccerFieldView = remember { mutableStateOf(true) }
    val deleteDialogCurrentPlayer = remember { mutableStateOf<Post?>(null) }
    val drawerCurrentPost = remember { mutableStateOf<Post?>(null) }
    val uiState = teamCreationViewModel.uiState.collectAsState()
    teamCreationViewModel.token = token

    FantasyFootballTheme {
        if (deleteDialogCurrentPlayer.value != null &&
            deleteDialogCurrentPlayer.value!!.player != NoGKPlayer &&
            deleteDialogCurrentPlayer.value!!.player != NoDEFPlayer &&
            deleteDialogCurrentPlayer.value!!.player != NoMIDPlayer &&
            deleteDialogCurrentPlayer.value!!.player != NoATTPlayer
        ) {
            DeletePlayerDialog(
                post = deleteDialogCurrentPlayer.value!!,
                onDeleteClickHandler = {
                    teamCreationViewModel.clearPost(deleteDialogCurrentPlayer.value!!)
                },
                onDismissHandler = { deleteDialogCurrentPlayer.value = null }
            )
        }
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Scaffold(
                scaffoldState = scaffoldState,
                drawerBackgroundColor = Color(0, 0, 0, 0),
                drawerElevation = 0.dp,
                drawerContent = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight().padding(vertical = 10.dp),
                    ) {
                        NavigationDrawerView(
                            token = token,
                            onPlayerRowCLickHandler = { player ->
                                coroutineScope.launch { scaffoldState.drawerState.close() }
                                teamCreationViewModel.fillPost(
                                    post = drawerCurrentPost.value!!,
                                    player = player
                                )
                            },
                            drawState = scaffoldState.drawerState
                        )
                    }
                },
                drawerGesturesEnabled = scaffoldState.drawerState.isOpen
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Column {
                        Header(
                            modifier = Modifier
                                .weight(3f)
                        )
                        NavBar(modifier = Modifier.weight(1f))
                        WeekInfo(modifier = Modifier.weight(1f))
                        TeamViewTypeSwitch(
                            isOnSoccerFieldView.value,
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
                                        .zIndex(1f),
                                    uiState.value.userMoney,
                                    uiState.value.userRemainingPlayersCount
                                )
                                if (isOnSoccerFieldView.value) {
                                    TeamSchematicScreen(
                                        userPostsList = uiState.value.userPostsList,
                                        onPlayerLongClickHandler = { post ->
                                            deleteDialogCurrentPlayer.value = post
                                        }, modifier = Modifier
                                            .height(300.dp)
                                            .zIndex(2f),
                                        onPlayerClickHandler = { post ->
                                            drawerCurrentPost.value = post
                                            coroutineScope.launch { scaffoldState.drawerState.open() }
                                        }
                                    )
                                } else {
                                    TeamListScreen(
                                        userPostsList = uiState.value.userPostsList,
                                        onPlayerClickHandler = { post ->
                                            drawerCurrentPost.value = post
                                            coroutineScope.launch { scaffoldState.drawerState.open() }
                                        },
                                        onPlayerLongClickHandler = { post ->
                                            deleteDialogCurrentPlayer.value = post}
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}