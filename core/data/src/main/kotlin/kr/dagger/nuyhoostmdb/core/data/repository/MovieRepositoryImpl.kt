package kr.dagger.nuyhoostmdb.core.data.repository

import com.orhanobut.logger.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kr.dagger.nuyhoostmdb.core.data.mapper.DetailMapper
import kr.dagger.nuyhoostmdb.core.data.mapper.NowPlayingMapper
import kr.dagger.nuyhoostmdb.core.data.mapper.UpComingMapper
import kr.dagger.nuyhoostmdb.core.database.AppDatabase
import kr.dagger.nuyhoostmdb.core.database.dao.BookmarkDao
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.model.UpComing
import kr.dagger.nuyhoostmdb.core.network.model.DetailResponse
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import java.util.PrimitiveIterator
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
	private val movieService: MovieService,
	private val bookmarkDao: BookmarkDao
) : MovieRepository {

	override fun getNoPlayingMovies(): Flow<List<NowPlaying>> {
		return flow {
			emit(
				movieService.getNowPlaying().results.map {
					NowPlayingMapper.mapFromNowPlayingResponseToModel(it)
				}
			)
		}
	}

	override fun getUpComingMovies(): Flow<List<UpComing>> {
		return flow {
			emit(
				movieService.getUpComing().results.map {
					UpComingMapper.mapFromUpComingResponseToModel(it)
				}
			)
		}
	}

	override fun getMovieDetail(id: Int): Flow<Detail> {
		return flow {
			val bookmarkIds = mutableListOf<Long>()
			val getDetail = movieService.getDetail(id)

			bookmarkDao.getBookmarks().collect { it ->
				bookmarkIds.clear()
				it.forEach { bookmark ->
					bookmarkIds.add(bookmark.id)
				}

				bookmarkIds.ifEmpty {
					emit(
						DetailMapper.mapFromDetailResponseToModel(getDetail)
					)
					return@collect
				}

				emit(
					if (bookmarkIds.any { it == id.toLong() }) {
						DetailMapper.mapFromDetailResponseToModel(getDetail.copy(isBookmark = true))
					} else {
						DetailMapper.mapFromDetailResponseToModel(getDetail)
					}
				)
			}
		}
	}
}