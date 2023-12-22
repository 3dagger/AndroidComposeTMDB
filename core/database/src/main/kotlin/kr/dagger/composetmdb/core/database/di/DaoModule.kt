package kr.dagger.composetmdb.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.composetmdb.core.database.AppDatabase
import kr.dagger.composetmdb.core.database.dao.FavoriteDao

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

	@Provides
	fun providesFavoriteDao(
		database: AppDatabase
	): FavoriteDao {
		return database.favoriteDao()
	}
}