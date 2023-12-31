package kr.dagger.nuyhoostmdb.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepositoryImpl
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepositoryImpl
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepository
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

	@Binds
	fun bindsFavoriteRepository(
		favoriteRepositoryImpl: BookmarkRepositoryImpl
	): BookmarkRepository

	@Binds
	fun bindsMovieRepository(
		movieRepositoryImpl: MovieRepositoryImpl
	): MovieRepository

	@Binds
	fun bindsPopularPagingRepository(
		popularPagingRepositoryImpl: PopularPagingRepositoryImpl
	): PopularPagingRepository
}