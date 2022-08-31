package com.rc.quokka.fantasyfootball

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
import com.rc.quokka.fantasyfootball.ui.team_creation.components.*
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamListScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamSchematicScreen
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isOnSoccerFieldView = remember { mutableStateOf(true) }
            FantasyFootballTheme {
                    val coroutineScope = rememberCoroutineScope()
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            NavigationDrawerView()
                        },
                        drawerGesturesEnabled = scaffoldState.drawerState.isOpen
                    ) {
                        Column() {
                            Header(Modifier.clickable (indication = null, interactionSource = remember {
                                MutableInteractionSource()
                            }){
                                coroutineScope.launch { scaffoldState.drawerState.open() }
                            })
                            NavBar()
                            WeekInfo()
                            TeamViewTypeSwitch(
                                onClickListButtonHandler = {  isOnSoccerFieldView.value = false },
                                onClickSchematicButtonHandle =  { isOnSoccerFieldView.value = true },
                            )
                            Scaffold(
                                topBar = {
                                    TopBar()
                                }
                            ) {
                                if (isOnSoccerFieldView.value) {
                                    TeamSchematicScreen()
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