package com.rc.quokka.fantasyfootball.ui.team_creation.components

import android.graphics.drawable.RippleDrawable
import android.media.Image
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.ColumnTypeCell
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.NavigationDrawerViewModel
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.PlayerDataCell
import com.rc.quokka.fantasyfootball.ui.team_creation.screens.Table
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size12VazirFont

//@Composable
//fun NavigationDrawer() {
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
//    ModalDrawer(
//        drawerContent = { NavigationDrawerView() },
//        drawerState = DrawerState(DrawerValue.Open),
//        gesturesEnabled = drawerState.isOpen,
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//    }
//}

@Composable
fun NavigationDrawerView(
    onPlayerRowCLickHandler: (player: Player) -> Unit,
    drawState: DrawerState,
    navigationDrawerViewModel: NavigationDrawerViewModel = viewModel(),
) {
    val uiState = navigationDrawerViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
            .background(Color.White)
            .clip(RectangleShape)
    ) {
        NavigationBarTopView()
        NavigationSearchBar()
//        Button(onClick = onRandomButtonClickHandler) {
//            Text(text = "یک بازیکن تصادفی انتخاب کن")
//        }
        FilterTags()
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Log.d("", "opopo" + uiState.value.playersList.toString())
            AllPlayersList(
                playersList = uiState.value.playersList,
                Modifier.fillMaxWidth(),
                onPlayerRowCLick = onPlayerRowCLickHandler
            )
//            Table(playersList = uiState.value.playersList, modifier = Modifier.width(500.dp))
        }

//        LazyColumn(content = {})
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
    val searchText = remember { mutableStateOf("جستجو") }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(value = searchText.value, colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
                onValueChange = {
                    searchText.value = it
                })
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search icon",
                modifier = Modifier.padding(end = 16.dp),
            )
        }
        Row(
            modifier = Modifier
                .height(1.dp)
                .background(color = Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {}
    }
//    Box(modifier = Modifier.background(Color.White)) {
//        TextField(modifier = Modifier
//            .background(Color.White)
//            .fillMaxWidth()
//            .padding(start = 4.dp, bottom = 4.dp), value = searchText.value, onValueChange = {
//            searchText.value = it
//        })
//    }
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
    modifier: Modifier,
    onPlayerRowCLick: (player: Player) -> Unit
) {
    val column1Weight = .6f
    val column2Weight = .2f
    val column3Weight = .2f

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item {
            Column() {
                Row {
                    ColumnTypeCell(text = "نام بازیکن", weight = column1Weight)
                    ColumnTypeCell(text = "عملکرد", weight = column2Weight)
                    ColumnTypeCell(text = "قیمت", weight = column3Weight)
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

@Composable
fun PlayerCountView(playersList: List<Player>) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff04f7da),
                        Color(0xff02fda2)
                    )
                )
            )
    ) {
        Text(text = "500 بازیکن نمایش داده شده است")
    }
}