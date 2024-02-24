package kr.dagger.nuyhoostmdb.core.data.mapper

import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Movie
import kr.dagger.nuyhoostmdb.core.network.model.PopularItemResponse
import org.junit.Assert.*
import org.junit.Test

class PopularMapperTest {

	private val mapper = PopularMapper

	@Test
	fun empty_popular_response_to_movie_model() = runTest {
		val emptyResponse = PopularItemResponse(
			id = null,
			title = null,
			posterPath = null,
			overView = null,
		)

		assertEquals(
			mapper.mapFromPopularResponseToModel(emptyResponse),
			testEmptyMovieModel
		)
	}

	@Test
	fun popular_response_to_movie_model() = runTest {
		val response = PopularItemResponse(
			id = 927107,
			title = "The Bricklayer",
			posterPath = "/36pYugctLa70NmwMEgXTR1G31Kq.jpg",
			overView = "뛰어난 실력을 지닌 전직 CIA 요원이 국제 음모를 파헤치기 위한 특수 미션을 그려낸 액션 스릴러",
		)

		assertEquals(
			mapper.mapFromPopularResponseToModel(response),
			testMovieModel
		)
	}
}

private val testEmptyMovieModel = Movie(
	id = 0,
	title = "",
	posterPath = "",
	overView = "",
)

private val testMovieModel = Movie(
	id = 927107,
	title = "The Bricklayer",
	posterPath = "/36pYugctLa70NmwMEgXTR1G31Kq.jpg",
	overView = "뛰어난 실력을 지닌 전직 CIA 요원이 국제 음모를 파헤치기 위한 특수 미션을 그려낸 액션 스릴러",
)