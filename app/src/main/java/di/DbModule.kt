package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.datasources.db.LocalDb
import data.datasources.db.dao.ChoreDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideApplicationDb(@ApplicationContext context: Context): LocalDb {
        return Room.databaseBuilder(
            context,
            LocalDb::class.java,
            "ChoreyDb"
        ).build()
    }

    @Provides
    fun provideChoreDao(localDb: LocalDb): ChoreDao {
        return localDb.getChoreDao()
    }
}

