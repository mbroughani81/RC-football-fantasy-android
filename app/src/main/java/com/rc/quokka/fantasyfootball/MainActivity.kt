package com.rc.quokka.fantasyfootball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FantasyFootballTheme {
                Column {
                    Header()
                }
            }
        }
    }
}


@Composable
fun Header() {
    Row(modifier = Modifier.height(130.dp)) {
        Box() {
            Image(
                painterResource(id = R.drawable.backgroud_rectangle),
                contentDescription = "header background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row() {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Spacer(modifier = Modifier.weight(11f))

                    Image(
                        painterResource(id = R.drawable.fourplayer_img),
                        contentDescription = "four players image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.weight(60f)
                    )
                }
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_premier_league),
                        contentDescription = "premier league icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(top = 25.dp)
                    )
                    Text(text = "فوتبال فانتزی", fontFamily = VazirFont, fontSize = 20.sp)
                }
            }

//                Column() {
//
//                }
        }
    }
}