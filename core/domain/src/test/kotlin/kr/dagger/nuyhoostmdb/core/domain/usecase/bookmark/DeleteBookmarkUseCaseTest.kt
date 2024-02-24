package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.testing.MainDispatcherRule
import kr.dagger.nuyhoostmdb.core.testing.respository.TestBookmarkRepository
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DeleteBookmarkUseCaseTest {

	@get:Rule
	val mainDispatcherRule = MainDispatcherRule()

	private val bookmarkRepository = TestBookmarkRepository()

	private val useCase = DeleteBookmarkUseCase(
		bookmarkRepository = bookmarkRepository,
	)

	@Test
	fun whenHasParams_invoke_method_return_size_zero() = runTest {
		// Given
		bookmarkRepository.insertBookmark(testBookmark)
		val savedBookmark = bookmarkRepository.getBookmarks().first()

		// When
		useCase.execute(testBookmark.id)

		// Then
		assertEquals(savedBookmark.size, 0)
	}
}

private val testBookmark = Bookmark(
	id = 1014590,
	title = "Upgraded",
	posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
	overView = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다."
)