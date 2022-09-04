package com.rc.quokka.fantasyfootball.ui.authentication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rc.quokka.fantasyfootball.ui.authentication.HeaderRow
import com.rc.quokka.fantasyfootball.ui.authentication.components.FormInputField
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size20VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size7VazirFont

@Composable
fun SignupScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xff3D185B))
                .padding(top = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                HeaderRow()
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    contentPadding = PaddingValues(top = 20.dp)
                ) {
                    item {
                        FormInputField(text = "نام")
                    }
                    item {
                        FormInputField(text = "نام خانوادگی")
                    }
                    item {
                        FormInputField(text = "ایمیل")
                    }
                    item {
                        FormInputField(text = "کشور")
                    }
                    item {
                        FormInputField(text = "نام کاربری")
                    }
                    item {
                        FormInputField(text = "رمز عبور")
                    }
                    item {
                        Button(onClick = {}) {
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

@Preview
@Composable
fun SignupScreenPreview() {

}