package org.student.travelnoteapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//My new app theme
private val DarkColorPalette = darkColors(
    primary = BottleGreen,
    primaryVariant = DarkJungleGreen,
    secondary = AliceBlue,
    background = Color.Black,
    surface = WildBlueYonder,
    onPrimary = Manatee,
    onBackground = WhitePC937,
    onSecondary = Charcoal
)

private val LightColorPalette = lightColors(
    primary = BottleGreen,
    primaryVariant = DarkJungleGreen,
    secondary = AliceBlue,
    secondaryVariant = WhitePC937,
    background = White,
    surface = WildBlueYonder,
    onPrimary = Manatee,
    onBackground = Color.Black,
    onSecondary = Charcoal

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