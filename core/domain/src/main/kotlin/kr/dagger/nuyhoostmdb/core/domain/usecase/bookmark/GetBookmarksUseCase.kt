package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import javax.inject.Inject

class GetBookmarksUseCase @Inject constructor(
	private val bookmarkRepository: BookmarkRepository
) : BaseUseCase<Unit, Flow<List<Bookmark>>>() {

	override fun execute(params: Unit): Flow<List<Bookmark>> {
		return bookmarkRepository.getBookmarks()
	}
}