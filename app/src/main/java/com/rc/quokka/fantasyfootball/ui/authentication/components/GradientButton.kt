package com.rc.quokka.fantasyfootball.ui.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.domain.model.SigninData
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont

@Composable
fun GradientFilledButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        contentPadding = PaddingValues(),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xffCF31B9),
                            Color(0xff9B3AF9)
                        )
                    )
                )
        ) {
            CommonText(
                text,
                style = weight700Size20VazirFont,
                color = Color.White
            )
        }
    }
}


@Composable
fun GradientBorderedButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff3D185B)),
        border = BorderStroke(
            width = 1.dp, brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xffCF31B9),
                    Color(0xff9B3AF9)
                )
            )
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        contentPadding = PaddingValues(),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {

        CommonText(
            text,
            style = weight700Size20VazirFont,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}