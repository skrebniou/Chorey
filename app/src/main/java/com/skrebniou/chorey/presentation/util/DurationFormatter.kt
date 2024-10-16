package com.skrebniou.chorey.presentation.util

import android.content.Context
import com.skrebniou.chorey.R
import java.time.Duration

fun formatDuration(context: Context, duration: Duration): String {
    val hours = duration.toHours() % 24
    val minutes = duration.toMinutes() % 60

    return buildString {
        append(context.getString(R.string.remind) + " ")
        if (hours > 0) append(
            "$hours " + when (hours) {
                1L -> context.getString(R.string.hour)
                else -> context.getString(R.string.hours)
            }
        )
        if (minutes > 0 || length == 0) append(
            "$minutes " + when (minutes) {
                1L -> context.getString(R.string.minute)
                else -> context.getString(R.string.minutes)
            }
        )
    }.trim()
}
