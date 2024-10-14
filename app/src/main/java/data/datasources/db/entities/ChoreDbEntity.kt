package data.datasources.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import data.models.Chore
import java.time.Duration
import java.time.LocalDateTime

@Entity(tableName = "Chores")
data class ChoreDbEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("Id")
    val id: Int = 0,
    @ColumnInfo("Label")
    var label: String,
    @ColumnInfo("DeadlineTime")
    var deadlineTime: LocalDateTime,
    @ColumnInfo("ReminderTime")
    var reminderTime: Duration,
    @ColumnInfo("Description")
    var description: String,
    @ColumnInfo("IsCompleted")
    var isCompleted: Boolean
) {
    fun toModel(): Chore = Chore(id, label, deadlineTime, reminderTime, description, isCompleted)
}
