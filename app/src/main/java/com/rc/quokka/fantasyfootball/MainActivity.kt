package com.rc.quokka.fantasyfootball

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.zIndex
import com.rc.quokka.fantasyfootball.ui.team_creation.TeamCreationMainPage
import com.rc.quokka.fantasyfootball.ui.team_creation.components.*
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.DeletePlayerDialog
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamListScreen
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.TeamSchematicScreen
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TeamCreationMainPage()
        }
    }
}