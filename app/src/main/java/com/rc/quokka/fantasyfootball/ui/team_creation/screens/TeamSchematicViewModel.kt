package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.lifecycle.ViewModel
import com.rc.quokka.fantasyfootball.model.Player

class TeamSchematicViewModel : ViewModel() {
    private val _allPlayersList = getPlayersList()

    private val _GKPlayers = _allPlayersList.GKPlayers
    val GKPlayers: List<Player?>
        get() = _GKPlayers

    private val _DEFPlayers = _allPlayersList.DEFPlayers
    val DEFPlayers: List<Player?>
        get() = _DEFPlayers

    private val _MIDPlayers = _allPlayersList.MIDPlayers
    val MIDPlayers: List<Player?>
        get() = _MIDPlayers

    private val _ATTPlayers = _allPlayersList.ATTPlayers
    val ATTPlayers: List<Player?>
        get() = _ATTPlayers
}

data class PlayersList(
    val GKPlayers: List<Player?>,
    val DEFPlayers: List<Player?>,
    val MIDPlayers: List<Player?>,
    val ATTPlayers: List<Player?>
)

private fun getPlayersList(): PlayersList = PlayersList(
    listOf(
        Player("gk1", "5"),
        Player("gk2", "3")
    ), listOf(
        Player("def1", "5"),
        null,
        null,
        null,
        null
    ),
    listOf(
        null,
        null,
        null,
        Player("mid1", "3"),
        Player("mid2", "3")
    ),
    listOf(
        null,
        null,
        Player("att1", "3"),
    )
)
