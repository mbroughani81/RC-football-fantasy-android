package com.rc.quokka.fantasyfootball.ui.team_creation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont

@Composable
fun TeamViewTypeSwitch(onClickListButtonHandler: () -> Unit, onClickSchematicButtonHandle: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
    ) {
        Card {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.rahnema_college_logo),
                    contentDescription = "premier league icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(100.dp)
                )
            }
        }

        Card(
            backgroundColor = Color(0xfff7f7f7)
        ) {
            Box(modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)) {
                Row {
                    TextButton(
                        onClick = onClickListButtonHandler,
                    ) {
                        Text(
                            "مشاهده لیست",
                            fontFamily = VazirFont,
                            fontSize = 16.sp,
                            color = Color(0xff3D195B),
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    TextButton(onClick = onClickSchematicButtonHandle) {
                        Text(
                            "شماتیک ترکیب",
                            fontFamily = VazirFont,
                            fontSize = 16.sp,
                            color = Color(0xff3D195B),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        )
                    }
                }
            }
        }
    }
}