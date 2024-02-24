package kr.dagger.nuyhoostmdb.core.data.mapper

import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.network.model.NowPlayingItemResponse
import org.junit.Assert.*
import org.junit.Test

class NowPlayingMapperTest {

	private val mapper = NowPlayingMapper

	@Test
	fun empty_now_playing_response_to_now_playing_model() = runTest {
		val emptyResponse = NowPlayingItemResponse(
			id = null,
			title = null,
			posterPath = null,
			overView = null,
		)

		assertEquals(
			mapper.mapFromNowPlayingResponseToModel(emptyResponse),
			testEmptyNowPlayingModel
		)
	}

	@Test
	fun now_playing_response_to_now_playing_model() = runTest {
		val response = NowPlayingItemResponse(
			id = 1014590,
			title = "Oppenheimer",
			posterPath = "/jpD6z9fgNe7OqsHoDeAWQWoULde.jpg",
			overView = "세상을 구하기 위해 세상을 파괴할 지도 모르는 선택을 해야 하는 천재 과학자의 핵개발 프로젝트."
		)

		assertEquals(
			mapper.mapFromNowPlayingResponseToModel(response),
			testNowPlayingModel
		)
	}
}

private val testEmptyNowPlayingModel = NowPlaying(
	id = 0,
	title = "",
	posterPath = "",
	overView = "",
)

private val testNowPlayingModel = NowPlaying(
	id = 1014590,
	title = "Oppenheimer",
	posterPath = "/jpD6z9fgNe7OqsHoDeAWQWoULde.jpg",
	overView = "세상을 구하기 위해 세상을 파괴할 지도 모르는 선택을 해야 하는 천재 과학자의 핵개발 프로젝트."
)