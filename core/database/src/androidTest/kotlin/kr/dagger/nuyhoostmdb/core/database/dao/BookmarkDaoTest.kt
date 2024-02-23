package kr.dagger.nuyhoostmdb.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.database.AppDatabase
import kr.dagger.nuyhoostmdb.core.database.entity.BookmarkEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class BookmarkDaoTest {

	private lateinit var bookmarkDao: BookmarkDao

	private lateinit var database: AppDatabase

	@Before
	fun createDatabase() {
		val context = ApplicationProvider.getApplicationContext<Context>()

		database = Room.inMemoryDatabaseBuilder(
			context,
			AppDatabase::class.java
		).build()

		bookmarkDao = database.bookmarkDao()
	}

	@After
	fun closeDb() {
		database.close()
	}

	@Test
	fun insert_bookmark_and_get_bookmark_first_item() = runTest {
		val bookmarkEntity = testBookmarkEntity(
			id = 11111,
			title = "avengers",
		)
		bookmarkDao.insertBookmark(bookmarkEntity)
		val savedBookmarkEntities = bookmarkDao.getBookmarks().first()

		assertEquals(savedBookmarkEntities.size, 1)
		assertEquals(savedBookmarkEntities.first(), bookmarkEntity)
	}

	@Test
	fun delete_bookmark_return_size_equals_one() = runTest {
		val bookmarkEntities = listOf(
			testBookmarkEntity(
				id = 12345,
				title = "wonka"
			),
			testBookmarkEntity(
				id = 67891,
				title = "avatar"
			)
		)

		bookmarkEntities.forEach {
			bookmarkDao.insertBookmark(it)
		}
		bookmarkDao.deleteBookmark(id = 12345)

		val savedBookmarkEntities = bookmarkDao.getBookmarks().first()

		assertEquals(savedBookmarkEntities.size, 1)
		assertEquals(savedBookmarkEntities.first().id, 67891)
	}
}

private fun testBookmarkEntity(
	id: Long,
	title: String,
) = BookmarkEntity(
	id = id,
	title = title,
	posterPath = "",
	overView = ""
)