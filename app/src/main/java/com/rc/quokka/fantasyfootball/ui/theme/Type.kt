package com.rc.quokka.fantasyfootball.ui.theme

import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rc.quokka.fantasyfootball.R

// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )


/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
//)

val VazirFont = FontFamily(
    Font(R.font.vazirmatn_thin, FontWeight.Thin),
    Font(R.font.vazirmatn_extralight, FontWeight.ExtraLight),
    Font(R.font.vazirmatn_light, FontWeight.Light),
    Font(R.font.vazirmatn_regular, FontWeight.Normal),
    Font(R.font.vazirmatn_medium, FontWeight.Medium),
    Font(R.font.vazirmatn_semibold, FontWeight.SemiBold),
    Font(R.font.vazirmatn_bold, FontWeight.Bold),
    Font(R.font.vazirmatn_extrabold, FontWeight.ExtraBold),
    Font(R.font.vazirmatn_black, FontWeight.Black)
)

val weight900Size20VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W900, fontSize = 20.sp)


val weight900Size18VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W900, fontSize = 18.sp)


val weight900Size17VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W900, fontSize = 17.sp)

val weight900Size14VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W900, fontSize = 14.sp)

val weight900Size9VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W900, fontSize = 9.sp)

val weight700Size20VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W700, fontSize = 20.sp)

val weight700Size14VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W700, fontSize = 14.sp)

val weight700Size7VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W700, fontSize = 7.sp)

val weight700Size6VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W700, fontSize = 6.sp)

val weight800Size14VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W800, fontSize = 14.sp)

val weight400Size24VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 24.sp)

val weight400Size16VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 16.sp)

val weight400Size15VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 15.sp)

val weight400Size14VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 14.sp)

val weight400Size13VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 13.sp)

val weight400Size12VazirFont =
    TextStyle(fontFamily = VazirFont, fontWeight = FontWeight.W400, fontSize = 12.sp)
