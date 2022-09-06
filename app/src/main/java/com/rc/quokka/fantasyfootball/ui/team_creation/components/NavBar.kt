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
import com.rc.quokka.fantasyfootball.ui.theme.weight800Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight900Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight900Size17VazirFont


@Composable
fun NavBar(modifier: Modifier = Modifier) {
    val cardSize = remember {
        mutableStateOf(Size.Zero)
    }

    val expanded = remember { mutableStateOf(false) }
    val items = listOf<String>("نقل و انتقالات", "آخرین رویداد ها", "پروفایل")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .onGloballyPositioned { coordinates ->
                cardSize.value = coordinates.size.toSize()
            }
    ) {

        Box() {
            CommonText(
                text = "تیم من",
                style = weight900Size17VazirFont,
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
                        CommonText(
                            text = it,
                            style = weight900Size14VazirFont,
                            color = Color(0xff3D195B),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}