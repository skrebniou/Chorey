package com.skrebniou.chorey.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme( // not ready
    primary = Color(0xFF062D69),
    secondary = Color(0xFF0D47A1),
    tertiary = Color(0xFF42A5F5),
    background = Color(0xFF90CAF9),
    surface = Color(0xFFAFD4F1),
    onPrimary = Color.White,
    onSecondary = Color(0xFF062D69),
    onTertiary = Color.White,
    onBackground = Color(0xFF0D47A1),
    onSurface = Color(0xFF1C1B1F)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFad2f34),
    secondary = Color(0xFFff7f7d),
    background = Color(0xFFFCB4B3),
    surface = Color(0xFFFF8886),
    onBackground = Color(0xFFAD7574),
    onPrimary = Color(0xFFffffff),
    onSecondary = Color(0xFF7c0515)
)

@Composable
fun ChoreyTheme(
    content: @Composable () -> Unit
) {
    val darkTheme = isSystemInDarkTheme()

    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}