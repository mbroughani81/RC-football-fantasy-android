package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import org.intellij.lang.annotations.JdkConstants

@Composable
fun TeamSchematicScreen() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()) {

        val soccerFieldSize = remember {
            mutableStateOf(Size.Zero)
        }
        Image(painter = painterResource(id = R.drawable.green_field),
            contentDescription = "soccer field base",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { layoutCoordinates ->
                    soccerFieldSize.value = layoutCoordinates.size.toSize()
                })

        Image(painter = painterResource(id = R.drawable.soccer_field_lines),
            contentDescription = "soccer field lines",
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            contentScale = ContentScale.Fit)

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(with(LocalDensity.current) { soccerFieldSize.value.height.toDp() })
            .padding(start = 8.dp, end = 8.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.soccer_field_white_part),
                contentDescription = "",
                alpha = 0.2f,
            )

            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.soccer_field_white_part), contentDescription = "", alpha = 0.2f)

            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.soccer_field_white_part), contentDescription = "", alpha = 0.2f)
            Spacer(modifier = Modifier.weight(0.5f))
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(with(LocalDensity.current) { soccerFieldSize.value.height.toDp() })
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)) {

            Row(Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Shirt(modifier = Modifier.weight(1f))
                Shirt(modifier = Modifier.weight(1f))
            }
            Row(Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
            }
            Row(Modifier.fillMaxWidth().weight(1f), horizontalArrangement =  Arrangement.SpaceEvenly) {
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
            }
            Row(Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
                Shirt(Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun Shirt(modifier: Modifier) {
    val shirtTapCount = remember {
        mutableStateOf(false)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(36.dp)) {
        Image(painter = painterResource(id = R.drawable.valencia_college_diactive), contentDescription = "shirt",
            modifier = Modifier
                .width(32.dp)
                .padding(top = 8.dp, bottom = 4.dp)
                .clickable(indication = null, interactionSource = remember {
                    MutableInteractionSource()
                }) {
                    shirtTapCount.value = !shirtTapCount.value

                }
        )
            if (shirtTapCount.value)
            PlayerInfo(Modifier)
    }
}

@Composable
fun PlayerInfo(modifier: Modifier) {
    Card(Modifier.width(36.dp)) {
        Column(Modifier.height(16.dp)) {
            Box(modifier = Modifier
                .background(color = Color(0xff37013B))
                .weight(1f)
                .width(36.dp), contentAlignment = Alignment.Center) {
                Text(text = "Hanif", color = Color(0xffFFFFFF),
                    fontSize = 7.sp,
                    fontFamily = VazirFont,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            Box(modifier = Modifier
                .weight(1f)
                .width(36.dp)
                .background(color = Color(0xffCCFFE4)), contentAlignment = Alignment.Center) {
                Text(text = "5.5", color = Color(0xff38003C), fontSize = 6.sp)
            }
        }
    }
}