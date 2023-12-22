package kr.dagger.composetmdb.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.flow.zip
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.data.local.FavoriteDao
import kr.dagger.composetmdb.data.remote.MovieService
import kr.dagger.composetmdb.data.remote.mapper.PopularMapper
import kr.dagger.composetmdb.domain.model.Popular
import java.io.IOException
import javax.inject.Inject

class PopularMoviePagingSource @Inject constructor(
	private val movieService: MovieService,
) : PagingSource<Int, Popular>() {

	private suspend fun fetchItems(page: Int): List<Popular> {
		return movieService.getPopular(page = page).results.map {
			PopularMapper.mapFromPopularResponseToModel(it)
		}
	}

	companion object {
		const val STARTING_PAGE_INDEX = 1
	}

	override fun getRefreshKey(state: PagingState<Int, Popular>): Int? {
		return state.anchorPosition?.let {
			state.closestPageToPosition(it)?.prevKey?.plus(1)
				?: state.closestPageToPosition(it)?.nextKey?.minus(1)
		}
	}

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Popular> {
		val page = params.key ?: STARTING_PAGE_INDEX
		return try {
			val response = fetchItems(page)
			LoadResult.Page(
				data = response,
				prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
				nextKey = if (response.isEmpty()) null else page + 1
			)
		} catch (exception: IOException) {
			LoadResult.Error(exception)
		} catch (exception: retrofit2.HttpException) {
			LoadResult.Error(exception)
		} catch (exception: Exception) {
			LoadResult.Error(exception)
		}
	}

}