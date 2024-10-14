package com.skrebniou.chorey.presentation.entities

import java.time.Duration
import java.time.LocalDateTime

data class Chore(
    val id: Int,
    var label: String,
    var deadlineTime: LocalDateTime,
    var reminderTime: Duration,
    var description: String,
    var isCompleted: Boolean
)
