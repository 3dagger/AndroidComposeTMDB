package kr.dagger.nuyhoostmdb.core.testing.respository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.model.Bookmark

class TestBookmarkRepository : BookmarkRepository {

	private val testBookmarkData: MutableList<Bookmark> = mutableListOf()
	override fun getBookmarks(): Flow<List<Bookmark>> {
		return flow {
			emit(testBookmarkData)
		}
	}

	override suspend fun insertBookmark(bookmarkEntity: Bookmark) {
		testBookmarkData.add(bookmarkEntity)
	}

	override suspend fun deleteBookmark(id: Long) {
		if (testBookmarkData.isEmpty()) return

		val item = testBookmarkData.find { it.id == id }
		testBookmarkData.remove(item)
	}
}