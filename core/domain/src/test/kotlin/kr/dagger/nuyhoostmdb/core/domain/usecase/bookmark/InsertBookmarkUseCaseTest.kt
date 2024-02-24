package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.testing.MainDispatcherRule
import kr.dagger.nuyhoostmdb.core.testing.respository.TestBookmarkRepository
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class InsertBookmarkUseCaseTest {

	@get:Rule
	val mainDispatcherRule = MainDispatcherRule()

	private val bookmarkRepository = TestBookmarkRepository()

	private val useCase = InsertBookmarkUseCase(
		bookmarkRepository
	)

	@Test
	fun when_invoke_method_return_testBookmarks() = runTest {
		// Given, When
		testBookmarks.forEach { bookmark -> useCase.execute(bookmark) }

		// Then
		assertEquals(
			bookmarkRepository.getBookmarks().first().size,
			testBookmarks.size
		)
		assertEquals(
			bookmarkRepository.getBookmarks().first(),
			testBookmarks
		)
	}
}

private val testBookmarks = listOf(
	Bookmark(
		id = 1014590,
		title = "Upgraded",
		posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
		overView = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다.",
	),
	Bookmark(
		id = 927107,
		title = "The Bricklayer",
		posterPath = "/36pYugctLa70NmwMEgXTR1G31Kq.jpg",
		overView = "뛰어난 실력을 지닌 전직 CIA 요원이 국제 음모를 파헤치기 위한 특수 미션을 그려낸 액션 스릴러",
	),
	Bookmark(
		id = 455411,
		title = "Tom and Jerry: Willy Wonka and the Chocolate Factory",
		posterPath = "/vh5iYhj80l1inSdep61sF8g1S8m.jpg",
		overView = "천재 초콜릿 발명가 윌리웡카가 제멋대로 듀오 톰과 제리를 만나다! 톰과 제리는 찰리가 초콜릿 공장에 들어가기 위한 골드 티켓을 얻도록 도와준다. 그리고 그들은 윌리웡카의 라이벌이 소중한 사탕을 훔쳐가는 것을 막아야하는데…",
	)
)