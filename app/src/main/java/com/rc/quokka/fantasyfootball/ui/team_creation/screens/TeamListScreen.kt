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
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont

@Composable
fun TeamListScreen(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Table(modifier = modifier)
    }
}

@Composable
fun RowScope.ColumnTypeCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        style = TextStyle(
            textAlign = TextAlign.Center),
        color = Color.Gray,
        fontFamily = VazirFont,
        fontSize = 13.sp,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun RowScope.PlayerTypeCell(
    text: String,
) {
    Text(
        text = text,
        color = Color(0xff00FF87),
        fontFamily = VazirFont,
        fontSize = 15.sp,
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
    Text(
        text = text,
        style = TextStyle(textAlign = textAlign),
        color = Color(0xff3d195b),
        fontFamily = VazirFont,
        fontSize = 13.sp,
        modifier = Modifier
            .weight(weight)
            .padding(4.dp)
    )
}

@Composable
fun Table(modifier: Modifier = Modifier) {
    val gkData = listOf(
        listOf("Henderson", "9", "5.9"),
        listOf("Allison", "8.5", "5.5")
    )
    val defData = listOf(
        listOf("Henderson", "9", "5.9"),
        listOf("Allison", "8.5", "5.5"),
        listOf("Henderson2", "9", "5.9"),
    )
    val midData = listOf(
        listOf("Allison", "8.5", "5.5")
    )
    val attData = listOf(
        listOf("Henderson", "9", "5.9"),
    )
    val column1Weight = .6f
    val column2Weight = .2f
    val column3Weight = .2f
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)) {
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
            val (name, performance, price) = it
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(text = performance, weight = column2Weight, isCentered = true)
                PlayerDataCell(text = price, weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "مدافعان")
            }
        }
        items(defData) {
            val (name, performance, price) = it
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(text = performance, weight = column2Weight, isCentered = true)
                PlayerDataCell(text = price, weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "هافبک ها")
            }
        }
        items(midData) {
            val (name, performance, price) = it
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(text = performance, weight = column2Weight, isCentered = true)
                PlayerDataCell(text = price, weight = column3Weight, isCentered = true)
            }
        }
        item {
            Row {
                PlayerTypeCell(text = "مهاجمین")
            }
        }
        items(attData) {
            val (name, performance, price) = it
            Row(Modifier.fillMaxWidth()) {
                PlayerDataCell(text = name, weight = column1Weight)
                PlayerDataCell(text = performance, weight = column2Weight, isCentered = true)
                PlayerDataCell(text = price, weight = column3Weight, isCentered = true)
            }
        }
    }
}