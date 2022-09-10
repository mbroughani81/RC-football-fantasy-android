package com.rc.quokka.fantasyfootball.ui.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.domain.model.ConfirmCodeData
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.authentication.components.GradientFilledButton
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont

@Composable
fun ConfirmCodeScreen(currentEmail: String, onConfirmButtonClick: (data: ConfirmCodeData) -> Unit) {
    val confirmCodeValue = remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xff3D185B))
                .padding(top = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(0.9f),
            ) {
                HeaderRow("تایید ثبت نام")
                Spacer(modifier = Modifier.height(70.dp))
                FormInputField(
                    text = "لطفا کدی که به ایمیلتان ارسال شده را در کادر زیر وارد کنید",
                    textFieldValue = confirmCodeValue.value,
                    onValueChange = { confirmCodeValue.value = it },
                    modifier = Modifier.fillMaxWidth(), textModifier = Modifier.fillMaxWidth(0.7f)
                )
                Spacer(modifier = Modifier.height(50.dp))
                GradientFilledButton(text = "تایید ثبت نام", onClick = {
                    onConfirmButtonClick(
                        ConfirmCodeData(code = confirmCodeValue.value, email = currentEmail)
                    )
                })
                Image(
                    painter = painterResource(id = R.drawable.authscreen_footer_img),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}