package kr.dagger.nuyhoostmdb.feature.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark.DeleteBookmarkUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark.GetBookmarksUseCase
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
	getBookmarksUseCase: GetBookmarksUseCase,
	private val deleteBookmarkUseCase: DeleteBookmarkUseCase
) : ViewModel() {

	val bookmarkStateFlow: StateFlow<BookmarkUiState> =
		getBookmarksUseCase.execute(Unit)
			.map<List<Bookmark>, BookmarkUiState>(BookmarkUiState::Success)
			.onStart { emit(BookmarkUiState.Loading) }
			.stateIn(
				scope = viewModelScope,
				started = SharingStarted.WhileSubscribed(5_000),
				initialValue = BookmarkUiState.Loading,
			)

	fun deleteFavoriteMovie(id: Long) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				deleteBookmarkUseCase.execute(id)
			}
		}
	}
}