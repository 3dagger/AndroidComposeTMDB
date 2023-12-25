package kr.dagger.composetmdb.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.dagger.composetmdb.core.data.mapper.PopularMapper
import kr.dagger.composetmdb.core.model.Popular
import kr.dagger.composetmdb.core.network.service.MovieService
import retrofit2.HttpException
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
		} catch (exception: HttpException) {
			LoadResult.Error(exception)
		} catch (exception: Exception) {
			LoadResult.Error(exception)
		}
	}

}