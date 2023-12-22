package kr.dagger.composetmdb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.composetmdb.data.local.FavoriteDao
import kr.dagger.composetmdb.data.remote.MovieService
import kr.dagger.composetmdb.data.repository.FavoriteRepositoryImpl
import kr.dagger.composetmdb.data.repository.MovieRepositoryImpl
import kr.dagger.composetmdb.data.repository.PopularPagingRepositoryImpl
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.repository.MovieRepository
import kr.dagger.composetmdb.domain.repository.PopularPagingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	@Singleton
	fun provideMovieRepository(movieService: MovieService): MovieRepository {
		return MovieRepositoryImpl(movieService)
	}

	@Provides
	@Singleton
	fun provideFavoriteRepository(favoriteDao: FavoriteDao): FavoriteRepository {
		return FavoriteRepositoryImpl(favoriteDao)
	}

	@Provides
	@Singleton
	fun providePopularPagingRepository(
		movieService: MovieService,
		favoriteDao: FavoriteDao
		): PopularPagingRepository {
		return PopularPagingRepositoryImpl(movieService)
	}
}