package com.rc.quokka.fantasyfootball

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import com.rc.quokka.fantasyfootball.ui.team_creation.components.*
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.DeletePlayerDialog
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamListScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamSchematicScreen
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (true  /* TODO(check if user is signed in or not) */) {
            val intent = Intent(this, AuthActivity::class.java)
            this.startActivity(intent)
        }
        setContent {
            val isOnSoccerFieldView = remember { mutableStateOf(true) }
            val isOnDeleteDialog = remember { mutableStateOf(false) }

            FantasyFootballTheme {
                if (isOnDeleteDialog.value) {
                    DeletePlayerDialog(onDismissHandler = { isOnDeleteDialog.value = false })
                }
                val coroutineScope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        NavigationDrawerView(scaffoldState.drawerState)
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen
                ) {
                    Column() {
                        Header(
                            modifier = Modifier
                                .weight(3f)
                                .clickable(indication = null, interactionSource = remember {
                                    MutableInteractionSource()
                                }) {
                                    coroutineScope.launch { scaffoldState.drawerState.open() }
                                })
                        NavBar(modifier = Modifier.weight(1f))
                        WeekInfo(modifier = Modifier.weight(1f))
                        TeamViewTypeSwitch(
                            onClickListButtonHandler = { isOnSoccerFieldView.value = false; },
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
                                        onPlayerClickHandler = {
                                            isOnDeleteDialog.value = true
                                        }, modifier = Modifier
                                            .height(300.dp)
                                            .zIndex(2f)
                                    )
                                } else {
                                    TeamListScreen(modifier = Modifier.height(300.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}