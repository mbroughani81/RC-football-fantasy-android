package com.rc.quokka.fantasyfootball.ui.team_creation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.weight900Size18VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight900Size9VazirFont


@Composable
fun TopBar(modifier: Modifier = Modifier, userMoney: String, userRemainingPlayersCount: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth(0.9f)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(0.4f)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff04f7da),
                            Color(0xff02fda2)
                        )
                    ),
                )
                .padding(bottom = 10.dp)
                .padding(5.dp)
                .fillMaxHeight()
        )
        {
            CommonText(
                text = "$userRemainingPlayersCount/15",
                style = weight900Size18VazirFont,
                color = Color(0xff3D195B),
                modifier = Modifier.padding(start = 8.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.head),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(50.dp)
                )
                CommonText(
                    text = "بازیکن باقی مانده",
                    style = weight900Size9VazirFont,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth(0.4f)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff04f7da),
                            Color(0xff02fda2)
                        )
                    )
                )
                .padding(bottom = 10.dp)
                .padding(5.dp)
                .fillMaxHeight()
        ) { 
            CommonText(
                userMoney,
                style = weight900Size18VazirFont,
                color = Color(0xff3D195B),
                modifier = Modifier.padding(start = 8.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(50.dp)
                )
                CommonText(
                    text = "پول باقی مانده",
                    style = weight900Size9VazirFont,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                )
            }
        }
    }
}