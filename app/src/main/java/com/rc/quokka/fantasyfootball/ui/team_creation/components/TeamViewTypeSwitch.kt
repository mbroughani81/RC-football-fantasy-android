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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight700Size14VazirFont

@Composable
fun TeamViewTypeSwitch(
    isOnSoccerFieldView: Boolean,
    onClickListButtonHandler: () -> Unit,
    onClickSchematicButtonHandle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Card {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.rahnema_college_logo),
                    contentDescription = "rahnema college icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(60.dp)
                        .width(80.dp)
                )
            }
        }

        Card(
            backgroundColor = Color(0xfff7f7f7)
        ) {
            Box(modifier = Modifier.padding(horizontal = 7.dp)) {
                Row {
                    if (!isOnSoccerFieldView) {
                        TextButton(
                            onClick = onClickListButtonHandler,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clip(RoundedCornerShape(10))
                                .background(Color.White)
                        ) {
                            CommonText(
                                "مشاهده لیست",
                                style = weight700Size14VazirFont,
                                color = Color(0xff3D195B),
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                    } else {
                        TextButton(
                            onClick = onClickListButtonHandler,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            CommonText(
                                "مشاهده لیست",
                                style = weight400Size14VazirFont,
                                color = Color(0xff3D195B),
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                    }
                    if (isOnSoccerFieldView) {
                        TextButton(
                            onClick = onClickSchematicButtonHandle,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clip(RoundedCornerShape(10))
                                .background(Color.White)
                        ) {
                            CommonText(
                                "شماتیک ترکیب",
                                style = weight700Size14VazirFont,
                                color = Color(0xff3D195B),
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                            )
                        }
                    } else {
                        TextButton(
                            onClick = onClickSchematicButtonHandle,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            CommonText(
                                "شماتیک ترکیب",
                                style = weight400Size14VazirFont,
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
}