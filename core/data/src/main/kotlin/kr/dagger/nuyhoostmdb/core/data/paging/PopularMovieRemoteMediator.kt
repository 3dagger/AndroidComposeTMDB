package kr.dagger.nuyhoostmdb.core.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kr.dagger.nuyhoostmdb.core.database.AppDatabase
import kr.dagger.nuyhoostmdb.core.model.Popular
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMovieRemoteMediator @Inject constructor(
	private val movieService: MovieService,
	private val appDatabase: AppDatabase
) : RemoteMediator<Int, Popular>() {

	override suspend fun initialize(): InitializeAction {
		return InitializeAction.SKIP_INITIAL_REFRESH
//		val currentTime = System.currentTimeMillis()
//		val lastUpdated = heroRemoteKeysDao.getRemoteKeysById(heroId = 1)?.lastUpdated ?: 0
//		val cacheTimeout = 1440 // 24 hours
//
//		val cachedExpired = (currentTime - lastUpdated) > (cacheTimeout * 60 * 1000)
//
//		return if (cachedExpired) {
//			InitializeAction.LAUNCH_INITIAL_REFRESH
//		} else {
//			InitializeAction.SKIP_INITIAL_REFRESH
//		}
	}


	override suspend fun load(
		loadType: LoadType,
		state: PagingState<Int, Popular>
	): MediatorResult {
		try {
//			val page = when (loadType) {
//				LoadType.REFRESH -> {
//					val remoteKeys = getRe
//				}
//			}
		} catch (e: Exception) {

		}
		return MediatorResult.Success(true)
	}


}