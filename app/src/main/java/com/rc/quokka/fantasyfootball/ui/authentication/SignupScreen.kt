package com.rc.quokka.fantasyfootball.ui.authentication.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
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
import com.rc.quokka.fantasyfootball.domain.model.SignupData
import com.rc.quokka.fantasyfootball.ui.authentication.HeaderRow
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.team_creation.components.GradientButton
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size7VazirFont

@Composable
fun SignupScreen(onSignupButtonClicked: (data: SignupData) -> Unit) {
    val usernameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val firstnameValue = remember { mutableStateOf("") }
    val lastnameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val birthdayValue = remember { mutableStateOf("") }
    val countryValue = remember { mutableStateOf("") }


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
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                HeaderRow("ثبت نام")
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(top = 20.dp)
                ) {
                    item {
                        FormInputField(
                            text = "نام",
                            textFieldValue = firstnameValue.value,
                            onValueChange = { firstnameValue.value = it }
                        )
                    }
                    item {
                        FormInputField(
                            text = "نام خانوادگی",
                            textFieldValue = lastnameValue.value,
                            onValueChange = { lastnameValue.value = it }
                        )
                    }
                    item {
                        FormInputField(
                            text = "ایمیل",
                            textFieldValue = emailValue.value,
                            onValueChange = { emailValue.value = it }
                        )
                    }
                    item {
                        FormInputField(
                            text = "کشور",
                            textFieldValue = countryValue.value,
                            onValueChange = { countryValue.value = it }
                        )
                    }
                    item {
                        FormInputField(
                            text = "نام کاربری",
                            textFieldValue = usernameValue.value,
                            onValueChange = { usernameValue.value = it }
                        )
                    }
                    item {
                        FormInputField(
                            text = "رمز عبور",
                            textFieldValue = passwordValue.value,
                            onValueChange = { passwordValue.value = it }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                    item {
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            onClick = {
                                onSignupButtonClicked(
                                    SignupData(
                                        firstnameValue.value,
                                        lastnameValue.value,
                                        emailValue.value,
                                        countryValue.value,
                                        usernameValue.value,
                                        passwordValue.value
                                    )
                                )
                            },
                            contentPadding = PaddingValues(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
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
    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen({})
}