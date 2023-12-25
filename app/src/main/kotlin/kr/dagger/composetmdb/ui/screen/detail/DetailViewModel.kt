package kr.dagger.composetmdb.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.dagger.composetmdb.core.domain.usecase.movie.GetMovieDetailUseCase
import kr.dagger.composetmdb.core.model.Detail
import kr.dagger.composetmdb.data.UiState
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
	private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
	private val _uiStateDetailMovie: MutableStateFlow<UiState<Detail>> = MutableStateFlow(UiState.Loading)
	val uiStateDetailMovie: StateFlow<UiState<Detail>> = _uiStateDetailMovie

	fun getMovieDetail(id: Int) {
		viewModelScope.launch {
			getMovieDetailUseCase.execute(params = id).catch {
				_uiStateDetailMovie.value = UiState.Error(it.message.toString())
			}.collect { movie ->
				_uiStateDetailMovie.value = UiState.Success(movie)
			}
		}
	}
}