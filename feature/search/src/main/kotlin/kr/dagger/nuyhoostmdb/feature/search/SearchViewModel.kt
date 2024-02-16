package kr.dagger.nuyhoostmdb.feature.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetMovieSearchUseCase
import kr.dagger.nuyhoostmdb.core.model.Search
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val getMovieSearchUseCase: GetMovieSearchUseCase
) : ViewModel() {

	val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")

	val searchResultUiState: StateFlow<SearchResultUiState> =
		searchQuery
			.debounce(1_000)
			.flatMapLatest { query ->
				if (query.length < SEARCH_QUERY_MIN_LENGTH) {
					flowOf(SearchResultUiState.Empty)
				} else {
					getMovieSearchUseCase.execute(query)
						.map<Search, SearchResultUiState>(SearchResultUiState::Success)
						.catch { emit(SearchResultUiState.Fail(message = it.message.toString())) }
						.onStart { emit(SearchResultUiState.Loading) }
				}
		}.stateIn(
			scope = viewModelScope,
			started = SharingStarted.WhileSubscribed(5_000),
			initialValue = SearchResultUiState.Loading
		)

	fun onSearchQueryChanged(query: String) {
		savedStateHandle[SEARCH_QUERY] = query
	}
}

private const val SEARCH_QUERY = "searchQuery"
private const val SEARCH_QUERY_MIN_LENGTH = 2