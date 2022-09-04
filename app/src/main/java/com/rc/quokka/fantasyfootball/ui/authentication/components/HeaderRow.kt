package com.rc.quokka.fantasyfootball.ui.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size15VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size24VazirFont

@Composable
fun HeaderRow(text: String = "") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        Image(
            painterResource(id = R.drawable.header_line_1),
            contentDescription = null,
            modifier = Modifier.weight(0.2f)
        )
        CommonText(
            text = "ثبت نام",
            style = weight400Size24VazirFont.copy(textAlign = TextAlign.Center),
            color = Color.White,
            modifier = Modifier.weight(0.5f)
        )
        Image(
            painterResource(id = R.drawable.header_line_2),
            contentDescription = null,
            modifier = Modifier.weight(0.2f)
        )
    }
}