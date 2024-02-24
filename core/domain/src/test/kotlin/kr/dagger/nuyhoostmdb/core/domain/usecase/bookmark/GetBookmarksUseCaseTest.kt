package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.testing.MainDispatcherRule
import kr.dagger.nuyhoostmdb.core.testing.respository.TestBookmarkRepository
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class GetBookmarksUseCaseTest {

	@get:Rule
	val mainDispatcherRule = MainDispatcherRule()

	private val bookmarkRepository = TestBookmarkRepository()

	private val useCase = GetBookmarksUseCase(
		bookmarkRepository = bookmarkRepository,
	)

	@Test
	fun when_insert_bookmarks_return_testBookmarks() = runTest {
		// Given, When
		testBookmarks.forEach { bookmark ->
			bookmarkRepository.insertBookmark(bookmark)
		}

		// Then
		assertEquals(
			useCase.execute(Unit).first(),
			testBookmarks
		)
	}
}

private val testBookmarks = listOf(
	Bookmark(
		id = 1014590,
		title = "Upgraded",
		posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
		overView = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다."
	),
	Bookmark(
		id = 927107,
		title = "The Bricklayer",
		posterPath = "/36pYugctLa70NmwMEgXTR1G31Kq.jpg",
		overView = "뛰어난 실력을 지닌 전직 CIA 요원이 국제 음모를 파헤치기 위한 특수 미션을 그려낸 액션 스릴러"
	),
)