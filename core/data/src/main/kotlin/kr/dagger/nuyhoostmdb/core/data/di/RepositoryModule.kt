package kr.dagger.nuyhoostmdb.core.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepositoryImpl
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepositoryImpl
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepository
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

	@Binds
	fun bindsFavoriteRepository(
		favoriteRepositoryImpl: FavoriteRepositoryImpl
	): FavoriteRepository

	@Binds
	fun bindsMovieRepository(
		movieRepositoryImpl: MovieRepositoryImpl
	): MovieRepository

	@Binds
	fun bindsPopularPagingRepository(
		popularPagingRepositoryImpl: PopularPagingRepositoryImpl
	): PopularPagingRepository
}