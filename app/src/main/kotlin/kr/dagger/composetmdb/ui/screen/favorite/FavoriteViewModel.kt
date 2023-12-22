package kr.dagger.composetmdb.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.dagger.composetmdb.data.UiState
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import kr.dagger.composetmdb.domain.usecase.favorite.GetFavoriteMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
	private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
	private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {
	private val _uiStateFavoriteMovie: MutableStateFlow<UiState<MutableList<Favorite>>> = MutableStateFlow(UiState.Loading)
	val uiStateFavoriteMovie: StateFlow<UiState<MutableList<Favorite>>> = _uiStateFavoriteMovie

	fun getFavorites() {
		viewModelScope.launch {
			getFavoriteMoviesUseCase.execute(Unit).catch {
				_uiStateFavoriteMovie.value = UiState.Error(it.message.toString())
			}.collect { favorite ->
				_uiStateFavoriteMovie.value = UiState.Success(favorite.toMutableList())
			}
		}
	}

	fun deleteFavoriteMovie(id: Long) {
		viewModelScope.launch {
			deleteFavoriteMovieUseCase.execute(id)
			getFavorites()
		}
	}
}