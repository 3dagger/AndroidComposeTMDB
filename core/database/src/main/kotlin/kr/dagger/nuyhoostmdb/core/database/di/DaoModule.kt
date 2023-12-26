package kr.dagger.nuyhoostmdb.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.nuyhoostmdb.core.database.AppDatabase
import kr.dagger.nuyhoostmdb.core.database.dao.FavoriteDao

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