package org.student.travelnoteapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

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
    primary = CoolGrey50PC1063,
    primaryVariant = FrenchGrey90PC1076,
    secondary = WhitePC937
)

private val LightColorPalette = lightColors(
    primary = CoolGrey70PC1065,
    primaryVariant = FrenchGrey90PC1076,
    secondary = WhitePC937

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