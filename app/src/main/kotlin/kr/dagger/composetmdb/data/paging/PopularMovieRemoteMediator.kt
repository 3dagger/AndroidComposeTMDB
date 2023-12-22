package kr.dagger.composetmdb.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kr.dagger.composetmdb.data.local.AppDatabase
import kr.dagger.composetmdb.data.remote.MovieService
import kr.dagger.composetmdb.domain.model.Popular
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