package kr.dagger.nuyhoostmdb.movie

import androidx.lifecycle.SavedStateHandle
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
import kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark.InsertBookmarkUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetMovieDetailUseCase
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.model.Detail
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
	savedStateHandle: SavedStateHandle,
	getMovieDetailUseCase: GetMovieDetailUseCase,
	private val insertBookmarkUseCase: InsertBookmarkUseCase,
	private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {
	private val movieId = savedStateHandle.get<Int>("id")

	var movieUiState: StateFlow<MovieUiState> =
		getMovieDetailUseCase.execute(movieId ?: -1)
			.map<Detail, MovieUiState>(MovieUiState::Success)
			.onStart { emit(MovieUiState.Loading) }
			.stateIn(
				scope = viewModelScope,
				started = SharingStarted.WhileSubscribed(5_000),
				initialValue = MovieUiState.Loading
			)

	fun updateBookmark(detail: Detail) {
		when (detail.isBookmarked) {
			true -> deleteBookmark(detail)
			false -> insertBookmark(detail)
		}
	}

	private fun insertBookmark(detail: Detail) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				insertBookmarkUseCase.execute(
					Bookmark(
						id = detail.id,
						title = detail.originalTitle,
						posterPath = detail.posterPath,
						overView = detail.overview,
					)
				)
			}
		}
	}

	private fun deleteBookmark(detail: Detail) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				deleteBookmarkUseCase.execute(detail.id)
			}
		}
	}
}