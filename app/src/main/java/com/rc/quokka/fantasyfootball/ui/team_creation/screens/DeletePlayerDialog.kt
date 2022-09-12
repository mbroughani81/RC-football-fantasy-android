package com.rc.quokka.fantasyfootball.ui.team_creation.screens

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.rc.quokka.fantasyfootball.R
import com.rc.quokka.fantasyfootball.domain.model.NoGKPlayer
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.rc.quokka.fantasyfootball.ui.team_creation.components.CommonText
import com.rc.quokka.fantasyfootball.ui.theme.VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size12VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size14VazirFont
import com.rc.quokka.fantasyfootball.ui.theme.weight400Size15VazirFont

@Composable
fun DeletePlayerDialog(post: Post, onDeleteClickHandler: () -> Unit, onDismissHandler: () -> Unit) {
    CustomDialog(post = post, onDeleteClick = onDeleteClickHandler, onDismiss = onDismissHandler)
}

@Composable
fun TitleText(text: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.background(color = Color(0xff3D195B))) {
        CommonText(
            text = text,
            style = weight400Size15VazirFont.copy(textAlign = TextAlign.Center),
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth(),
            color = Color(0xff00FF87),
        )
    }
}

@Composable
fun PlayerShirtImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.delete_player_kit_img),
        contentDescription = "",
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun ConfirmText(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        val message1 = "آیا از حذف "
        val message2 = " مطمئن هستید؟"
        CommonText(
            message1 + text + message2,
            style = weight400Size14VazirFont,
            modifier = modifier
        )
    }
}

@Composable
fun ButtonRow(onDismiss: () -> Unit, onDelete: () -> Unit,  modifier: Modifier = Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Button(
            onClick = onDismiss,
            contentPadding = PaddingValues(3.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            CommonText(
                "لغو",
                style = weight400Size12VazirFont,
                color = Color(0xff3D195B)
            )
        }
        Button(
            onClick = { onDelete(); onDismiss();},
            contentPadding = PaddingValues(3.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffED1B5D))
        ) {
            CommonText(
                "حذف",
                style = weight400Size12VazirFont,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun DeletePlayerDialogPreview() {
    DeletePlayerDialog(Post(pos = 1, NoGKPlayer), {}, {})
}

@Composable
fun CustomDialog(post: Post, onDeleteClick: () -> Unit, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { /*TODO*/ },
        content = {
            Card() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight(0.6f)
                        .fillMaxWidth()
                ) {
                    TitleText("حذف بازیکن", modifier = Modifier.weight(10f))
                    PlayerShirtImage(
                        modifier = Modifier
                            .weight(35f)
                    )
                    ConfirmText(
                        post.player.name,
                        modifier = Modifier
                            .weight(7f)
                    )
                    ButtonRow(
                        onDismiss = onDismiss,
                        onDelete = onDeleteClick,
                        modifier = Modifier
                            .weight(8f)
                    )
                    Spacer(modifier = Modifier.weight(4f))
                }
            }

        },
    )
}
