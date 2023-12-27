package kr.dagger.nuyhoostmdb.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetMovieDetailUseCase
import kr.dagger.nuyhoostmdb.core.model.Detail
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
	private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
	private val _uiStateDetailMovie: MutableStateFlow<MovieUiState<Detail>> = MutableStateFlow(MovieUiState.Loading)
	val uiStateDetailMovie: StateFlow<MovieUiState<Detail>> = _uiStateDetailMovie

	fun getMovieDetail(id: Int) {
		viewModelScope.launch {
			getMovieDetailUseCase.execute(params = id).catch {
				_uiStateDetailMovie.value = MovieUiState.Error(it.message.toString())
			}.collect { movie ->
				_uiStateDetailMovie.value = MovieUiState.Success(movie)
			}
		}
	}
}