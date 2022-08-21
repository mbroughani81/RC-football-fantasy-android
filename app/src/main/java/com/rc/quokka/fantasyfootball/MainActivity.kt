package com.rc.quokka.fantasyfootball

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import com.rc.quokka.fantasyfootball.ui.theme.FantasyFootballTheme

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
    Row(modifier = Modifier.height(150.dp)) {
        Box {
            Image (
                painterResource(id = R.drawable.backgroud_rectangle),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Image (
                painterResource(id = R.drawable.fourplayer_img),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(70.dp)
            )
        }
    }
}