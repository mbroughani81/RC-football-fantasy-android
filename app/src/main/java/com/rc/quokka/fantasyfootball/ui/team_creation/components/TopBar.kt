package com.rc.quokka.fantasyfootball.ui.team_creation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont


@Composable
fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier
            .height(70.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff04f7da),
                            Color(0xff02fda2)
                        )
                    )
                )
                .padding(5.dp)
                .fillMaxHeight()
        )
        {
            Text(
                "۱۵/۱۲",
                fontFamily = VazirFont,
                fontSize = 18.sp,
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
                Text(
                    "بازیکن باقی مانده",
                    fontFamily = VazirFont,
                    fontSize = 12.sp,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(1f)
                .padding(end = 30.dp)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff04f7da),
                            Color(0xff02fda2)
                        )
                    )
                )
                .padding(5.dp)
                .fillMaxHeight()
        ) {
            Text(
                "۷۳",
                fontFamily = VazirFont,
                fontSize = 18.sp,
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
                Text(
                    "پول باقی مانده",
                    fontFamily = VazirFont,
                    fontSize = 12.sp,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                )
            }
        }
    }
}