package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.rc.quokka.fantasyfootball.ui.team_creation.TeamCreationUiState
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size6VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size7VazirFont

@Composable
fun TeamSchematicScreen(
    userPostsList: List<Post>,
    onPlayerClickHandler: (post: Post) -> Unit,
    onPlayerLongClickHandler: (post: Post) -> Unit,
    modifier: Modifier = Modifier,
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
                postsList = userPostsList
                    .filter { it.player.role == PlayerRole.GoalKeeper },
                onPlayerLongClick = onPlayerLongClickHandler,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                postsList = userPostsList
                    .filter { it.player.role == PlayerRole.Defender },
                onPlayerLongClick = onPlayerLongClickHandler,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                postsList = userPostsList
                    .filter { it.player.role == PlayerRole.Midfielder },
                onPlayerLongClick = onPlayerLongClickHandler,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f)
            )
            PlayerRow(
                postsList = userPostsList
                    .filter { it.player.role == PlayerRole.Attacker },
                onPlayerLongClick = onPlayerLongClickHandler,
                onPlayerClick = onPlayerClickHandler,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun PlayerRow(
    postsList: List<Post>,
    onPlayerClick: (post: Post) -> Unit,
    onPlayerLongClick: (post: Post) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth()) {
        postsList
            .sortedBy {
                it.pos
            }.forEach { post ->
                Shirt(
                    post = post,
                    onPlayerClick = onPlayerClick,
                    onPlayerLongClick = onPlayerLongClick,
                    modifier = Modifier.weight(1f)
                )
            }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Shirt(
    post: Post,
    onPlayerClick: (post: Post) -> Unit,
    onPlayerLongClick: (post: Post) -> Unit,
    modifier: Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(36.dp)) {
        if (post.player.name != (-1).toString()){
            Image(
                painter = painterResource(id = R.drawable.delete_player_kit_img),
                contentDescription = "shirt",
                modifier = Modifier
                    .width(32.dp)
                    .padding(top = 8.dp, bottom = 4.dp)
                    .combinedClickable(
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        onClick = { onPlayerClick(post) },
                        onLongClick = { onPlayerLongClick(post) }
                    )
            )
            PlayerInfo(player = post.player)
        } else {
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
                        onClick = { onPlayerClick(post) },
                        onLongClick = { onPlayerLongClick(post) }
                    )
            )
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
                    text = player.rating.toString(),
                    style = weight700Size6VazirFont,
                    color = Color(0xff38003C)
                )
            }
        }
    }
}