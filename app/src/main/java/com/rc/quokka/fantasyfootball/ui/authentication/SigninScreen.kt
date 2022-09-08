package com.rc.quokka.fantasyfootball.ui.authentication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.domain.model.SigninData
import com.rc.quokka.fantasyfootball.ui.authentication.HeaderRow
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont

@Composable
fun SigninScreen(
    onSigninButtonClicked: (data: SigninData) -> Unit,
    onSignupButtonClicked: () -> Unit
) {
    val usernameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
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
                HeaderRow("ورود به فانتزی")
                Spacer(modifier = Modifier.height(20.dp))
                FormInputField(
                    text = "نام کاربری",
                    textFieldValue = usernameValue.value,
                    onValueChange =  { it -> usernameValue.value = it },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(10.dp))
                FormInputField(
                    text = "رمز عبور",
                    textFieldValue = passwordValue.value,
                    onValueChange =  { it -> passwordValue.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = { onSigninButtonClicked(SigninData(usernameValue.value, passwordValue.value)) },
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
                            "ورود",
                            style = weight700Size20VazirFont,
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = onSignupButtonClicked,
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
                            "ثبت نام",
                            style = weight700Size20VazirFont,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SigninScreenPreview() {
    SigninScreen({}, {})
}