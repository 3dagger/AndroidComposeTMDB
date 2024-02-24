package kr.dagger.nuyhoostmdb.core.data.mapper

import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.UpComing
import kr.dagger.nuyhoostmdb.core.network.model.UpComingItemResponse
import org.junit.Assert.*
import org.junit.Test

class UpComingMapperTest {

	private val mapper = UpComingMapper

	@Test
	fun empty_upcoming_item_response_to_upcoming_model() = runTest {
		val emptyResponse = UpComingItemResponse(
			id = null,
			title = null,
			posterPath = null,
			overView = null,
		)

		assertEquals(
			mapper.mapFromUpComingResponseToModel(emptyResponse),
			testEmptyUpComingModel
		)
	}

	@Test
	fun upcoming_item_response_to_upcoming_model() = runTest {
		val response = UpComingItemResponse(
			id = 1014590,
			title = "Upgraded",
			posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
			overView = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다.",
		)

		assertEquals(
			mapper.mapFromUpComingResponseToModel(response),
			testUpComingModel
		)
	}
}

private val testEmptyUpComingModel = UpComing(
	id = 0,
	title = "",
	posterPath = "",
	overView = "",
)

private val testUpComingModel = UpComing(
	id = 1014590,
	title = "Upgraded",
	posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
	overView = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다.",
)