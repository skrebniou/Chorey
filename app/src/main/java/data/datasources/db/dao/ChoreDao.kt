package data.datasources.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import data.datasources.db.entities.ChoreDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChoreDao {
    @Upsert(entity = ChoreDbEntity::class)
    fun upsertChore(portfolioDb: ChoreDbEntity)

    @Query("SELECT * FROM Chores")
    fun getChores(): Flow<List<ChoreDbEntity>>

    @Query("SELECT * FROM Chores WHERE Chores.IsCompleted == 0")
    fun getPendingChores(): Flow<List<ChoreDbEntity>>

    @Query("SELECT * FROM Chores WHERE Chores.IsCompleted == 1")
    fun getCompletedChores(): Flow<List<ChoreDbEntity>>

    @Query("SELECT * FROM Chores WHERE Chores.Id == :id")
    fun getChore(id: Int): ChoreDbEntity

    @Query("DELETE FROM Chores WHERE Chores.Id == :id")
    fun deleteChore(id: Int): Unit
}
