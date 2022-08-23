package com.rc.quokka.fantasyfootball

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FantasyFootballTheme {
                Column {
                    Header()
                    NavBar()
                    WeekInfo()
                    SoccerField()
                }
            }
        }
    }
}


@Composable
fun Header() {
    Row(modifier = Modifier.height(130.dp)) {
        Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
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
                        modifier = Modifier.weight(80f)
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_premier_league),
                        contentDescription = "premier league icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(top = 25.dp)
                    )
                    Text(
                        text = "فوتبال فانتزی",
                        fontFamily = VazirFont,
                        fontSize = 20.sp,
                        color = Color(0xff37013B)
                    )
                }
            }
        }
    }
}

@Composable
fun NavBar() {
    val cardSize = remember {
        mutableStateOf(Size.Zero)
    }

    val expanded = remember { mutableStateOf(false) }
    val items = listOf<String>("حنیف", "محمد", "سانیار")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .height(40.dp)
            .onGloballyPositioned { coordinates ->
                cardSize.value = coordinates.size.toSize()
            }
    ) {

        Box() {
            Text(
                text = "تیم من",
                fontFamily = VazirFont,
                fontSize = 17.sp,
                color = Color(0xff18DEEA),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 8.dp)
            )

//            TextButton(
//                onClick = { expanded.value = !expanded.value },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.menu),
//                    contentDescription = "dropdown menu",
//                    modifier = Modifier.height(40.dp)
//                )
//            }
            Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu icon",
            modifier = Modifier
                .height(35.dp)
                .padding(end = 8.dp)
                .align(Alignment.CenterEnd)
                .clickable(indication = null, interactionSource = remember {
                    MutableInteractionSource()
                }) { expanded.value = !expanded.value })
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.width(with(LocalDensity.current) {cardSize.value.width.toDp()})
        ) {
            items.forEach {
                DropdownMenuItem(onClick = { Log.d(TAG, it) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = it,
                            fontFamily = VazirFont,
                            fontSize = 14.sp,
                            color = Color(0xff3D195B),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }


//    DropdownMenu(
//        expanded = expanded.value,
//        onDismissRequest = { expanded.value = false },
//        modifier = Modifier.background(Color.Red).width(100.dp)
//    ) {
//        items.forEach {
//            DropdownMenuItem(onClick = { Log.d(TAG, it) }, modifier = Modifier.background(Color.Magenta)) {
//                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Green)) {
//                    Text(
//                        text = it,
//                        fontFamily = VazirFont,
//                        fontSize = 14.sp,
//                        color = Color(0xff3D195B),
//                        modifier = Modifier.align(Alignment.Center)
//                    )
//                }
//            }
//        }
//    }
}

@Composable
fun WeekInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 10.dp)
            .height(40.dp)
    ) {
        Box(modifier = Modifier.background(color = Color(0xff3D195B))) {
            Text(
                text = "شنبه 30 مرداد 1400 - ساعت 17",
                fontFamily = VazirFont,
                fontSize = 14.sp,
                color = Color(0xffFFFFFF),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp)
            )
            Text(text = "هفته سوم",
                fontFamily = VazirFont,
                fontSize = 14.sp,
                color = Color(0xff00FF87),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 24.dp)
            )
        }
    }
}

@Composable
fun SoccerField() {
    Box(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {

        val soccerFieldSize = remember {
            mutableStateOf(Size.Zero)
        }
        Image(painter = painterResource(id = R.drawable.green_field),
            contentDescription = "soccer field base",
            contentScale = ContentScale.Fit,
            modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                soccerFieldSize.value = layoutCoordinates.size.toSize()
            })

        Image(
            painter = painterResource(id = R.drawable.soccer_field_lines),
            contentDescription = "soccer field lines",
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(with(LocalDensity.current) { soccerFieldSize.value.height.toDp() })
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.soccer_field_white_part),
                contentDescription = "",
                alpha = 0.2f,
            )

            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.soccer_field_white_part),
                contentDescription = "",
                alpha = 0.2f
            )

            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.soccer_field_white_part),
                contentDescription = "",
                alpha = 0.2f
            )
            Spacer(modifier = Modifier.weight(0.5f))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(with(LocalDensity.current) { soccerFieldSize.value.height.toDp() })
                .padding(start = 8.dp, end = 8.dp)
        ) {

            val modifier = Modifier.weight(1f)

            Row(modifier) {
                Spacer(modifier = Modifier.weight(2f))
                Shirt(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(1f))
                Shirt(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(2f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(1f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(1f))
                Shirt(Modifier)
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(2f))
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier) {
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(2f))
                Shirt(Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(2f))
            }
        }
    }
}

@Composable
fun Shirt(modifier: Modifier) {
    Column() {
        Image(painter = painterResource(id = R.drawable.valencia_college_diactive), contentDescription = "shirt",
            modifier = Modifier
                .width(32.dp)
                .clickable(indication = null, interactionSource = remember {
                    MutableInteractionSource()
                }) {
                    Log.d(TAG, "MainActivity")
                }
        )
        PlayerInfo(modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun PlayerInfo(modifier: Modifier) {
    Card() {
        Column(Modifier.height(12.dp)) {
            Box(modifier = Modifier.background(color = Color(0xff37013B)).weight(1f), contentAlignment = Alignment.Center) {
                Text(text = "Hanif", color = Color(0xffFFFFFF),
                    fontSize = 7.sp,
                    fontFamily = VazirFont,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier.background(color = Color(0xff000000)).weight(1f)) {
                Text(text = "Sani", color = Color(0xffFFFFFF))
            }
        }
    }
}