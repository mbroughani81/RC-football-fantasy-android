package com.rc.quokka.fantasyfootball.ui.team_creation.components

import android.graphics.drawable.RippleDrawable
import android.media.Image
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import com.rc.quokka.fantasyfootball.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.rc.quokka.fantasyfootball.domain.model.Token
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.ColumnTypeCell
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.NavigationDrawerViewModel
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.PlayerDataCell
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.Table
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight300Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size12VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size16VazirFont

@ExperimentalFoundationApi
@Composable
fun NavigationDrawerView(
    onPlayerRowCLickHandler: (player: Player) -> Unit,
    drawState: DrawerState,
    navigationDrawerViewModel: NavigationDrawerViewModel = viewModel(),
) {

    val uiState = navigationDrawerViewModel.uiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95f)
            .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
            .background(Color.White)
            .padding(bottom = 10.dp)
    ) {
        NavigationBarTopView()
        NavigationSearchBar()
        FilterTags()
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            AllPlayersList(
                playersList = uiState.value.playersList,
                onPlayerRowCLick = onPlayerRowCLickHandler
            )
        }
        DrawerPageButtons(
            pageNumber = uiState.value.pageNumber,
            onClickNextButton = navigationDrawerViewModel::goNextPage,
            onClickPrevButton = navigationDrawerViewModel::goPrevPage
        )
    }
    if (drawState.isOpen) {
        navigationDrawerViewModel.updateTable()
    }
}

@Composable
fun NavigationBarTopView() {
    Box(
        modifier = Modifier
            .background(color = Color(0xff3D195B))
            .fillMaxWidth()
            .height(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "انتخاب بازیکن", fontFamily = VazirFont, color = Color(0xffFFFFFF))
    }
}

@Composable
fun NavigationSearchBar() {
    val searchText = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search icon",
            )
            TextField(
                value = searchText.value,
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    backgroundColor = Color.White,
                ),
                onValueChange = {
                    searchText.value = it
                },
                placeholder = {
                    CommonText(
                        text = "جستجو",
                        style = weight300Size14VazirFont
                    )
                })

        }
        Row(
            modifier = Modifier
                .height(1.dp)
                .background(color = Color.Black)
                .fillMaxWidth()
        ) {}
    }
}

@Composable
fun GradientButton(modifier: Modifier, content: @Composable () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        content()
    }
}

@Composable
fun FilterTags() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        GradientButton(modifier = Modifier
            .weight(1f)
            .padding(vertical = 8.dp)
            .clip(MaterialTheme.shapes.small)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff03FBB8),
                        Color(0xff04F5EC)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {}) {
            Text(text = "ALL", fontSize = 10.sp, textAlign = TextAlign.Center)
        }
        GradientButton(modifier = Modifier
            .weight(1f)
            .padding(vertical = 8.dp)
            .clip(MaterialTheme.shapes.small)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff03FBB8),
                        Color(0xff04F5EC)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {}) {
            Text(text = "GK", fontSize = 10.sp, textAlign = TextAlign.Center)
        }

        GradientButton(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .clip(MaterialTheme.shapes.small)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff03FBB8),
                            Color(0xff04F5EC)
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "DEF", fontSize = 10.sp)
        }

        GradientButton(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .clip(MaterialTheme.shapes.small)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff03FBB8),
                            Color(0xff04F5EC)
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "MID", fontSize = 10.sp)
        }

        GradientButton(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .clip(MaterialTheme.shapes.small)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff03FBB8),
                            Color(0xff04F5EC)
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "ATT", fontSize = 10.sp)
        }
    }
}

@Composable
fun AllPlayersList(
    playersList: List<Player>,
    onPlayerRowCLick: (player: Player) -> Unit,
) {
    val column1Weight = .6f
    val column2Weight = .2f
    val column3Weight = .2f

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        item {
            Column {
                Row {
                    ColumnTypeCell(text = "نام بازیکن", weight = column1Weight)
                    ColumnTypeCell(text = "عملکرد", weight = column2Weight, isCentered = true)
                    ColumnTypeCell(text = "قیمت", weight = column3Weight, isCentered = true)
                }
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .height(0.5.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {}
            }
        }
        items(playersList) { item: Player ->
            val name = item.name
            val price = item.price
            val rating = item.rating
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onPlayerRowCLick(item) }) {
                    PlayerDataCell(text = name, weight = column1Weight)
                    PlayerDataCell(
                        text = rating.toString(),
                        weight = column2Weight,
                        isCentered = true
                    )
                    PlayerDataCell(
                        text = price.toString(),
                        weight = column3Weight,
                        isCentered = true
                    )
                }
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .height(0.5.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {}
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun DrawerPageButtons(
    pageNumber: Int,
    onClickNextButton: () -> Unit,
    onClickPrevButton: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(25.dp)) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.vector_right_gray),
                        contentDescription = null,
                        modifier = Modifier.combinedClickable(onClick = {})
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector_right_gray),
                        contentDescription = null,
                        modifier = Modifier.combinedClickable(onClick = {})
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.vector_right_purple),
                    contentDescription = null,
                    modifier = Modifier.combinedClickable(onClick = onClickPrevButton)
                )
                Text(text = "${pageNumber}")
                Image(
                    painter = painterResource(id = R.drawable.vector_left_purple),
                    contentDescription = null,
                    modifier = Modifier.combinedClickable(onClick = onClickNextButton)
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.vector_left_gray),
                        contentDescription = null,
                        modifier = Modifier.combinedClickable(onClick = {})
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector_left_gray),
                        contentDescription = null,
                        modifier = Modifier.combinedClickable(onClick = {})
                    )
                }
            }
        }
    }
}