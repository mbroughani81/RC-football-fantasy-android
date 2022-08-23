package com.rc.quokka.fantasyfootball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.rc.quokka.fantasyfootball.ui.team_creation.components.Header
import com.rc.quokka.fantasyfootball.ui.team_creation.components.NavBar
import com.rc.quokka.fantasyfootball.ui.team_creation.components.TopBar
import com.rc.quokka.fantasyfootball.ui.team_creation.components.WeekInfo
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamListScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamSchematicScreen
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isOnSoccerFieldView = remember { mutableStateOf(true) }
            FantasyFootballTheme {
                Column {
                    Header()
                    NavBar()
                    WeekInfo()
                    Scaffold(
                        topBar = {
                            TopBar(
                                onClickListButtonHandler = { isOnSoccerFieldView.value = false },
                                onClickSchematicButtonHandle = { isOnSoccerFieldView.value = true }
                            )
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
