package data.util

import androidx.room.TypeConverter
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DbConverters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let {
            LocalDateTime.parse(it, formatter)
        }
    }

    @TypeConverter
    @JvmStatic
    fun localDateTimeToTimestamp(dateTime: LocalDateTime?): String? {
        return dateTime?.format(formatter)
    }

    @TypeConverter
    @JvmStatic
    fun fromMillis(value: Long?): Duration? {
        return value?.let {
            Duration.ofMillis(it)
        }
    }

    @TypeConverter
    @JvmStatic
    fun durationToMillis(duration: Duration?): Long? {
        return duration?.toMillis()
    }
}
