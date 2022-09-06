package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size13VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size15VazirFont
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rc.quokka.fantasyfootball.ui.team_creation.TeamCreationViewModel

@Composable
fun TeamListScreen(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Table(playersList = emptyList(), modifier = modifier)
    }
}

@Composable
fun RowScope.ColumnTypeCell(
    text: String,
    weight: Float
) {
    CommonText(
        text = text,
        style = weight400Size13VazirFont.copy(textAlign = TextAlign.Center),
        color = Color.Gray,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun RowScope.PlayerTypeCell(
    text: String,
) {
    CommonText(
        text = text,
        color = Color(0xff00FF87),
        style = weight400Size15VazirFont.copy(textAlign = TextAlign.Center),
        modifier = Modifier
            .width(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xff3D195B))
            .padding(start = 8.dp)
            .padding(2.dp)
    )
}

@Composable
fun RowScope.PlayerDataCell(
    text: String,
    weight: Float,
    isCentered: Boolean = false
) {
    val textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
    CommonText(
        text = text,
        style = weight400Size13VazirFont.copy(textAlign = textAlign),
        color = Color(0xff3d195b),
        modifier = Modifier
            .weight(weight)
            .padding(4.dp)
    )
}

@Composable
fun Table(
    playersList: List<Player>,
    modifier: Modifier = Modifier,
) {
//    val gkData = viewModel.getGoalKeepers(playersList)
//    val defData = viewModel.getDefenders(playersList)
//    val midData = viewModel.getMidfielders(playersList)
//    val attData = viewModel.getAttackers(playersList)
    val gkData = emptyList<Player>()
    val defData = emptyList<Player>()
    val midData = emptyList<Player>()
    val attData = emptyList<Player>()
    val column1Weight = .6f
    val column2Weight = .2f
    val column3Weight = .2f
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row {
                ColumnTypeCell(text = "", weight = column1Weight)
                ColumnTypeCell(text = "عملکرد", weight = column2Weight)
                ColumnTypeCell(text = "قیمت", weight = column3Weight)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "دروازه بانان")
            }
        }
        items(gkData) {
            val name = it.name
            val performance = it.rating
            val price = it.price
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(
                    text = performance.toString(),
                    weight = column2Weight,
                    isCentered = true
                )
                PlayerDataCell(text = price.toString(), weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "مدافعان")
            }
        }
        items(defData) {
            val name = it.name
            val performance = it.rating
            val price = it.price
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(
                    text = performance.toString(),
                    weight = column2Weight,
                    isCentered = true
                )
                PlayerDataCell(text = price.toString(), weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "هافبک ها")
            }
        }
        items(midData) {
            val name = it.name
            val performance = it.rating
            val price = it.price
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(
                    text = performance.toString(),
                    weight = column2Weight,
                    isCentered = true
                )
                PlayerDataCell(text = price.toString(), weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "مهاجمین")
            }
        }
        items(attData) {
            val name = it.name
            val performance = it.rating
            val price = it.price
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(
                    text = performance.toString(),
                    weight = column2Weight,
                    isCentered = true
                )
                PlayerDataCell(text = price.toString(), weight = column3Weight, isCentered = true)
            }
        }
    }
}