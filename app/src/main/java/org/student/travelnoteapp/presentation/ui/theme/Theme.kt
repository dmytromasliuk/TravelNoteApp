package org.student.travelnoteapp.presentation.ui.theme

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader

//Old app theme
//private val DarkColorPalette = darkColors(
//        primary = Purple200,
//        primaryVariant = Purple700,
//        secondary = Teal200
//)
//
//private val LightColorPalette = lightColors(
//        primary = Purple500,
//        primaryVariant = Purple700,
//        secondary = Teal200
//
//        /* Other default colors to override
//    background = Color.White,
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//    */
//)

//My new app theme
private val DarkColorPalette = darkColors(
    primary = BottleGreen,
    primaryVariant = DarkJungleGreen,
    background = Color.Black,
    surface = WildBlueYonder,
    onPrimary = Manatee
)

private val LightColorPalette = lightColors(
    primary = BottleGreen,
    primaryVariant = DarkJungleGreen,
    background = White,
    surface = WildBlueYonder,
    onPrimary = Manatee

    /* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)

@Composable
fun TravelNoteAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}