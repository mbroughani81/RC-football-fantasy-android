package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.rc.quokka.fantasyfootball.R

@Composable
fun TeamSchematicScreen() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)) {

        val soccerFieldSize = remember {
            mutableStateOf(Size.Zero)
        }
        Image(painter = painterResource(id = R.drawable.green_field),
            contentDescription = "soccer field base",
            contentScale = ContentScale.Fit,
            modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
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
            .padding(start = 8.dp, end = 8.dp)) {

            val modifier = Modifier.weight(1f)

            Row(modifier) {
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(1f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(1f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(1f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
                Shirt()
                Spacer(modifier = Modifier.weight(2f))
            }
        }
    }
}

@Composable
fun Shirt() {
    Image(painter = painterResource(id = R.drawable.valencia_college_diactive), contentDescription = "shirt",
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))
}
