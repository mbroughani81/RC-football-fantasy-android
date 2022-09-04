package com.rc.quokka.fantasyfootball.ui.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont

@Composable
fun ConfirmCodeScreen(onConfirmButtonClick: () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(
            contentAlignment = Alignment.TopCenter,
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
                    modifier = Modifier.fillMaxWidth(), textModifier = Modifier.fillMaxWidth(0.7f))
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = onConfirmButtonClick,
                    contentPadding = PaddingValues(),
                    modifier = Modifier
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
                            "تایید ثبت نام",
                            style = weight700Size20VazirFont,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}