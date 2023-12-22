package kr.dagger.composetmdb.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.dagger.composetmdb.data.local.AppDatabase
import kr.dagger.composetmdb.data.local.FavoriteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

	@Singleton
	@Provides
	fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
		return AppDatabase.getInstance(context)
	}

	@Provides
	fun provideFavoriteDao(appDatabase: AppDatabase): FavoriteDao {
		return appDatabase.favoriteDao()
	}
}