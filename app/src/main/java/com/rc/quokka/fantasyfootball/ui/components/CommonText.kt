package com.rc.quokka.fantasyfootball.ui.team_creation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont

@Composable
fun CommonText(
    text: String = "",
    style: TextStyle,
    color: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontFamily = VazirFont,
        style = style,
        color = color,
        modifier = modifier
    )
//    Text(text = "fff")
}