package kr.dagger.nuyhoostmdb.core.testing.respository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.model.Search
import kr.dagger.nuyhoostmdb.core.model.UpComing

class TestMovieRepository : MovieRepository {

	private val testUpComingData: MutableList<UpComing> = mutableListOf()

	private val testNowPlayingData: MutableList<NowPlaying> = mutableListOf()

	private val testDetailData: Detail = Detail(
		id = 1014590,
		adult = false,
		backdropPath = "/pRmF6VBsRnvWCbLB9P80UvZFMyK.jpg",
		genre = listOf(),
		originalTitle = "Upgraded",
		overview = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다.",
		popularity = 388.489,
		posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
		releaseDate = "2024-02-07",
		runTime = 190,
		status = "released",
		voteAverage = 5.5,
		voteCount = 9,
		isBookmarked = false
	)

	private val testSearchData: Search = Search(
		page = 0,
		result = listOf(),
		totalPages = 0,
		totalResults = 0,
	)

	override fun getUpComingMovies(): Flow<List<UpComing>> {
		return flow {
			emit(testUpComingData)
		}
	}

	override fun getNoPlayingMovies(): Flow<List<NowPlaying>> {
		return flow {
			emit(testNowPlayingData)
		}
	}

	override fun getMovieDetail(id: Int): Flow<Detail> {
		return flow {
			emit(testDetailData)
		}
	}

	override fun getMovieSearch(query: String): Flow<Search> {
		return flow {
			emit(testSearchData)
		}
	}
}