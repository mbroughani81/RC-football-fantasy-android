package com.rc.quokka.fantasyfootball.ui.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size15VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size16VazirFont

@Composable
fun FormInputField(
    text: String = "",
    textFieldValue: String = "",
    onValueChange: (String) -> Unit = {},
    textModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CommonText(
            text = text,
            style = weight400Size16VazirFont.copy(textAlign = TextAlign.Center),
            color = Color(0xffEDD8FF),
            modifier = textModifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        Card(
            backgroundColor = Color(0xff3D185B),
            border = BorderStroke(1.dp, Color(0xffA057DB)),
            shape = RoundedCornerShape(10.dp)
        ) {
            TextField(
                value = textFieldValue,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle.Default.copy(fontSize = 15.sp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}