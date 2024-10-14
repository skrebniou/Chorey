package data.repositories

import data.datasources.db.dao.ChoreDao
import data.datasources.db.entities.ChoreDbEntity
import data.models.Chore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.Duration
import java.time.LocalDateTime
import javax.inject.Inject

class ChoreRepository @Inject constructor(
    private val choreDao: ChoreDao
) {
    suspend fun getChores(): Flow<List<Chore>> {
        return withContext(Dispatchers.IO) {
            val list = choreDao.getChores()
            return@withContext list.map { it ->
                it.map {
                    it.toModel()
                }
            }
        }
    }

    suspend fun getPendingChores(): Flow<List<Chore>> {
        return withContext(Dispatchers.IO) {
            val list = choreDao.getPendingChores()
            return@withContext list.map { it ->
                it.map {
                    it.toModel()
                }
            }
        }
    }

    suspend fun getCompletedChores(): Flow<List<Chore>> {
        return withContext(Dispatchers.IO) {
            val list = choreDao.getCompletedChores()
            return@withContext list.map { it ->
                it.map {
                    it.toModel()
                }
            }
        }
    }

    suspend fun getChore(id: Int): Chore {
        return withContext(Dispatchers.IO) {
            choreDao.getChore(id).toModel()
        }
    }

    suspend fun updateChore(id: Int, chore: Chore) {
        return withContext(Dispatchers.IO) {
            choreDao.upsertChore(chore.toDbEntity())
        }
    }

    suspend fun createChore() {
        return withContext(Dispatchers.IO) {
            choreDao.upsertChore(
                ChoreDbEntity(
                    label = "New (tbc)",
                    deadlineTime = LocalDateTime.now(),
                    reminderTime = Duration.ofHours(12),
                    description = "New chore (tbc)",
                    isCompleted = false
                )
            )
        }
    }

    suspend fun deleteChore(id: Int) {
        return withContext(Dispatchers.IO) {
            choreDao.deleteChore(id)
        }
    }
}
