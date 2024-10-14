package com.skrebniou.chorey.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBBDEFB), // A lighter blue for primary in dark mode
    secondary = Color(0xFF90CAF9), // A light blue for secondary elements
    tertiary = Color(0xFF64B5F6), // A bright blue for tertiary elements
    background = Color(0xFF121212), // Dark background for high contrast
    surface = Color(0xFF1E1E1E), // Slightly lighter surface for cards
    onPrimary = Color(0xFF0D47A1), // Dark text for readability on primary
    onSecondary = Color.Black, // Black text on secondary color for contrast
    onTertiary = Color.Black, // Black text on tertiary color
    onBackground = Color.White, // Light text on dark background
    onSurface = Color.White // Light text on dark surface
)

private val LightColorScheme = lightColorScheme(
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