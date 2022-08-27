package com.rc.quokka.fantasyfootball.ui.team_creation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont

@Composable
fun WeekInfo(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 10.dp)
    ) {
        Box(modifier = Modifier.background(color = Color(0xff3D195B))) {
            Text(
                text = "شنبه 30 مرداد 1400 - ساعت 17",
                fontFamily = VazirFont,
                fontSize = 14.sp,
                color = Color(0xffFFFFFF),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp)
            )
            Text(text = "هفته سوم",
                fontFamily = VazirFont,
                fontSize = 14.sp,
                color = Color(0xff00FF87),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 24.dp)
            )
        }
    }
}
