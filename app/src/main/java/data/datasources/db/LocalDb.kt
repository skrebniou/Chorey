package data.datasources.db

import androidx.room.Database
import androidx.room.RoomDatabase
import data.datasources.db.dao.ChoreDao
import data.datasources.db.entities.ChoreDbEntity

@Database(
    entities = [
        ChoreDbEntity::class
    ],
    version = 1
)
abstract class LocalDb : RoomDatabase() {
    abstract fun getChoreDao(): ChoreDao
}
