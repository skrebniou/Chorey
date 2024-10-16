package com.skrebniou.chorey.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF7c0515),
    secondary = Color(0xFF530711),
    background = Color(0xFF30060C),
    surface = Color(0xFFad2f34),
    onBackground = Color(0xFF7C1725),
    onPrimary = Color(0xFFF75268),
    onSecondary = Color(0xFFBE0F27)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFad2f34),
    secondary = Color(0xFFFF9F9D),
    background = Color(0xFFFFC9C8),
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