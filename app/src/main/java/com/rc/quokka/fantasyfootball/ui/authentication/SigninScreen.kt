package com.rc.quokka.fantasyfootball.ui.authentication.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.domain.model.SigninData
import com.rc.quokka.fantasyfootball.ui.authentication.HeaderRow
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.authentication.components.GradientBorderedButton
import com.rc.quokka.fantasyfootball.ui.authentication.components.GradientFilledButton
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
                HeaderRow("ورود به فانتزی")
                Spacer(modifier = Modifier.height(20.dp))
                FormInputField(
                    text = "نام کاربری",
                    textFieldValue = usernameValue.value,
                    onValueChange = { it -> usernameValue.value = it },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(10.dp))
                FormInputField(
                    text = "رمز عبور",
                    textFieldValue = passwordValue.value,
                    onValueChange = { it -> passwordValue.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(40.dp))
                GradientFilledButton(
                    text = "ورود",
                    onClick = {
                        onSigninButtonClicked(
                            SigninData(
                                usernameValue.value,
                                passwordValue.value
                            )
                        )
                    })
                Spacer(modifier = Modifier.height(20.dp))
                GradientBorderedButton(text = "ثبت نام", onClick = onSignupButtonClicked)
            }
            Image(
                painter = painterResource(id = R.drawable.authscreen_footer_img),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview
@Composable
fun SigninScreenPreview() {
    SigninScreen({}, {})
}