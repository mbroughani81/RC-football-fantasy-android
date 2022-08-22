package com.rc.quokka.fantasyfootball

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import org.intellij.lang.annotations.JdkConstants

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FantasyFootballTheme {
                Column {
                    Header()
                    NavBar()
                    Scaffold(
                        topBar = {
                            TopBar()
                        }
                    ) {

                    }

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
    var expanded = remember { mutableStateOf(false) }
    val items = listOf<String>("حنیف", "محمد", "سانیار")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .height(40.dp)
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

            TextButton(
                onClick = { expanded.value = !expanded.value },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "dropdown menu",
                    modifier = Modifier.height(40.dp)
                )
            }
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach {
                DropdownMenuItem(onClick = { Log.d(TAG, it) }) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {
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

}

@Composable
fun TopBar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
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
                        onClick = {},
                    ) {
                        Text(
                            "مشاهده لیست",
                            fontFamily = VazirFont,
                            fontSize = 16.sp,
                            color = Color(0xff3D195B),
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    TextButton(onClick = {}) {
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

        Spacer(modifier = Modifier.height(35.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier
                .height(70.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(brush = Brush.horizontalGradient(colors = listOf(Color(0xff04f7da), Color(0xff02fda2))))
                    .padding(5.dp)
                    .fillMaxHeight()
            )
            {
                Text(
                    "۱۵/۱۲",
                    fontFamily = VazirFont,
                    fontSize = 16.sp,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.head),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Text(
                        "بازیکن باقی مانده",
                        fontFamily = VazirFont,
                        fontSize = 12.sp,
                        color = Color(0xff3D195B),
                        modifier = Modifier
                            .wrapContentWidth(unbounded = true)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 30.dp)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(brush = Brush.horizontalGradient(colors = listOf(Color(0xff04f7da), Color(0xff02fda2))))
                    .padding(5.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    "۷۳",
                    fontFamily = VazirFont,
                    fontSize = 16.sp,
                    color = Color(0xff3D195B),
                    modifier = Modifier
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Text(
                        "پول باقی مانده",
                        fontFamily = VazirFont,
                        fontSize = 12.sp,
                        color = Color(0xff3D195B),
                        modifier = Modifier
                            .wrapContentWidth(unbounded = true)
                    )
                }
            }
        }
    }
}