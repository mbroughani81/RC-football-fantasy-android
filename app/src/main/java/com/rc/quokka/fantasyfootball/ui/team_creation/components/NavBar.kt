package com.rc.quokka.fantasyfootball.ui.team_creation.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont


@Composable
fun NavBar() {
    val cardSize = remember {
        mutableStateOf(Size.Zero)
    }

    val expanded = remember { mutableStateOf(false) }
    val items = listOf<String>("حنیف", "محمد", "سانیار")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .height(40.dp)
            .onGloballyPositioned { coordinates ->
                cardSize.value = coordinates.size.toSize()
            }
    ) {

        Box() {
            Text(
                text = "تیم من",
                fontFamily = VazirFont,
                fontSize = 17.sp,
                color = Color(0xff18DEEA),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 8.dp)
            )

            Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu icon",
                modifier = Modifier
                    .height(35.dp)
                    .padding(end = 8.dp)
                    .align(Alignment.CenterEnd)
                    .clickable(indication = null, interactionSource = remember {
                        MutableInteractionSource()
                    }) { expanded.value = !expanded.value })
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.width(with(LocalDensity.current) { cardSize.value.width.toDp() })
        ) {
            items.forEach {
                DropdownMenuItem(onClick = {}) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = it,
                            fontFamily = VazirFont,
                            fontSize = 14.sp,
                            color = Color(0xff3D195B),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}