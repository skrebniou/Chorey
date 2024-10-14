package com.skrebniou.chorey.presentation.util

import java.time.Duration

fun formatDuration(duration: Duration): String {
    val days = duration.toDays()
    val hours = duration.toHours() % 24
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    return buildString {
        append("In ")
        if (days > 0) append("$days days ")
        if (hours > 0) append("$hours hours ")
        if (minutes > 0) append("$minutes minutes ")
        if (seconds > 0 || length == 0) append("$seconds seconds") // Always show seconds if nothing else
    }.trim()
}