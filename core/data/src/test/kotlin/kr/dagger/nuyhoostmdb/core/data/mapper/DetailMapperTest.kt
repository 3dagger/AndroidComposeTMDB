package kr.dagger.nuyhoostmdb.core.data.mapper

import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.network.model.DetailResponse
import org.junit.Test
import kotlin.test.assertEquals

class DetailMapperTest {

	private val mapper = DetailMapper

	@Test
	fun empty_detail_response_to_detail_model() = runTest {
		val emptyResponse = DetailResponse(
			id = null,
			adult = null,
			backdropPath = null,
			genre = null,
			originalTitle = null,
			overview = null,
			popularity = null,
			posterPath = null,
			releaseDate = null,
			runTime = null,
			status = null,
			voteAverage = null,
			voteCount = null,
			isBookmark = null
		)

		assertEquals(
			mapper.mapFromDetailResponseToModel(emptyResponse),
			testEmptyDetailModel
		)
	}

	@Test
	fun detail_response_to_detail_model() = runTest {
		val response = DetailResponse(
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
			isBookmark = true
		)

		assertEquals(
			mapper.mapFromDetailResponseToModel(response),
			testDetailModel
		)
	}
}

private val testEmptyDetailModel = Detail(
	id = 0,
	adult = false,
	backdropPath = "",
	genre = emptyList(),
	originalTitle = "",
	overview = "",
	popularity = 0.0,
	posterPath = "",
	releaseDate = "",
	runTime = 0,
	status = "",
	voteAverage = 0.0,
	voteCount = 0,
	isBookmarked = false
)

private val testDetailModel = Detail(
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
	isBookmarked = true
)