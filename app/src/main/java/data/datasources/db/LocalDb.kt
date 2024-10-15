package data.datasources.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import data.datasources.db.dao.ChoreDao
import data.datasources.db.entities.ChoreDbEntity
import data.util.DbConverters

@Database(
    entities = [
        ChoreDbEntity::class
    ],
    version = 1
)
@TypeConverters(DbConverters::class)
abstract class LocalDb : RoomDatabase() {
    abstract fun getChoreDao(): ChoreDao
}
