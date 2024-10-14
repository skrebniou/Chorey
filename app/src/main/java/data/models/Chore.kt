package data.models

import data.datasources.db.entities.ChoreDbEntity
import java.time.Duration
import java.time.LocalDateTime

data class Chore(
    val id: Int,
    var label: String,
    var deadlineTime: LocalDateTime,
    var reminderTime: Duration,
    var description: String,
    var isCompleted: Boolean
) {
    fun toDbEntity(): ChoreDbEntity =
        ChoreDbEntity(id, label, deadlineTime, reminderTime, description, isCompleted)

}
