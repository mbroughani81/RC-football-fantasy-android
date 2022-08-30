package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.model.Player
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size6VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size7VazirFont
import org.intellij.lang.annotations.JdkConstants

@Composable
fun TeamSchematicScreen(
    onPlayerClickHandler: () -> Unit,
    modifier: Modifier = Modifier,
    teamSchematicViewModel: TeamSchematicViewModel = viewModel(),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth(0.9f)
            .offset(y = -10.dp)
    ) {

        val soccerFieldSize = remember {
            mutableStateOf(Size.Zero)
        }
        Image(painter = painterResource(id = R.drawable.soccer_field),
            contentDescription = "soccer field base",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .onGloballyPositioned { layoutCoordinates ->
                    soccerFieldSize.value = layoutCoordinates.size.toSize()
                }
                .fillMaxHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(with(LocalDensity.current) { soccerFieldSize.value.height.toDp() })
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        ) {
            PlayerRow(
                playersList = teamSchematicViewModel.GKPlayers,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                playersList = teamSchematicViewModel.DEFPlayers,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                playersList = teamSchematicViewModel.MIDPlayers,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                playersList = teamSchematicViewModel.ATTPlayers,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun PlayerRow(
    playersList: List<Player?>,
    onPlayerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth()) {
        playersList.forEach { player ->
            Shirt(player = player, onPlayerClick = onPlayerClick, modifier = Modifier.weight(1f))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Shirt(player: Player?, onPlayerClick: () -> Unit, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(36.dp)) {
        Image(
            painter = painterResource(id = R.drawable.valencia_college_diactive),
            contentDescription = "shirt",
            modifier = Modifier
                .width(32.dp)
                .padding(top = 8.dp, bottom = 4.dp)
                .combinedClickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    onClick = {},
                    onLongClick = onPlayerClick
                )

        )
        if (player != null) {
            PlayerInfo(player = player)
        }
    }
}

@Composable
fun PlayerInfo(player: Player, modifier: Modifier = Modifier) {
    Card(Modifier.width(36.dp)) {
        Column(Modifier.height(16.dp)) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xff37013B))
                    .weight(1f)
                    .width(36.dp), contentAlignment = Alignment.Center
            ) {
                CommonText(
                    text = player.name,
                    style = weight700Size7VazirFont,
                    color = Color(0xffFFFFFF),
                    modifier = Modifier.fillMaxHeight()
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .width(36.dp)
                    .background(color = Color(0xffCCFFE4)), contentAlignment = Alignment.Center
            ) {
                CommonText(
                    text = player.score,
                    style = weight700Size6VazirFont,
                    color = Color(0xff38003C)
                )
            }
        }
    }
}