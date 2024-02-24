package kr.dagger.nuyhoostmdb.core.data.mapper

import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Search
import kr.dagger.nuyhoostmdb.core.network.model.SearchItemResponse
import kr.dagger.nuyhoostmdb.core.network.model.SearchResponse
import org.junit.Assert.*
import org.junit.Test

class SearchMapperTest {

	private val mapper = SearchMapper

	@Test
	fun empty_search_response_to_search_model() = runTest {
		val emptyResponse = SearchResponse(
			page = null,
			results = listOf(),
			totalPages = null,
			totalResults = null,
		)

		assertEquals(
			mapper.mapFromSearchResponseToModel(emptyResponse),
			testEmptySearchModel
		)
	}

	@Test
	fun search_response_to_search_model() = runTest {
		val response = SearchResponse(
			page = 1,
			results = listOf(
				SearchItemResponse(
					adult = false,
					backdropPath = "/gzUvtI4VTjGLua5LZ2Y2eVndr2W.jpg",
					id = 455411,
					originalTitle = "Tom and Jerry: Willy Wonka and the Chocolate Factory",
					overview = "천재 초콜릿 발명가 윌리웡카가 제멋대로 듀오 톰과 제리를 만나다! 톰과 제리는 찰리가 초콜릿 공장에 들어가기 위한 골드 티켓을 얻도록 도와준다. 그리고 그들은 윌리웡카의 라이벌이 소중한 사탕을 훔쳐가는 것을 막아야하는데…",
					popularity = 33.467,
					posterPath = "/vh5iYhj80l1inSdep61sF8g1S8m.jpg",
					releaseDate = "2017-06-28",
					title = "톰과 제리: 윌리 웡카와 초콜릿 공장",
					voteAverage = 6.635,
					voteCount = 126
				)
			),
			totalPages = 21,
			totalResults = 11
		)

		assertEquals(
			mapper.mapFromSearchResponseToModel(response),
			testSearchModel
		)
	}
}

private val testEmptySearchModel = Search(
	page = 0, result = listOf(), totalPages = 0, totalResults = 0
)

private val testSearchModel = Search(
	page = 1,
	result = listOf(
		Search.SearchItem(
			adult = false,
			backdropPath = "/gzUvtI4VTjGLua5LZ2Y2eVndr2W.jpg",
			id = 455411,
			originalTitle = "Tom and Jerry: Willy Wonka and the Chocolate Factory",
			overview = "천재 초콜릿 발명가 윌리웡카가 제멋대로 듀오 톰과 제리를 만나다! 톰과 제리는 찰리가 초콜릿 공장에 들어가기 위한 골드 티켓을 얻도록 도와준다. 그리고 그들은 윌리웡카의 라이벌이 소중한 사탕을 훔쳐가는 것을 막아야하는데…",
			popularity = 33.467,
			posterPath = "/vh5iYhj80l1inSdep61sF8g1S8m.jpg",
			releaseDate = "2017-06-28",
			title = "톰과 제리: 윌리 웡카와 초콜릿 공장",
			voteAverage = 6.635,
			voteCount = 126
		)
	),
	totalPages = 21,
	totalResults = 11
)