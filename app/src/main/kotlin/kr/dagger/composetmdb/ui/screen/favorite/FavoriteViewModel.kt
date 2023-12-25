package kr.dagger.composetmdb.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.dagger.composetmdb.core.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import kr.dagger.composetmdb.core.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kr.dagger.composetmdb.core.model.Favorite
import kr.dagger.composetmdb.data.UiState
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
	private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
	private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {
	private val _uiStateFavoriteMovieEntity: MutableStateFlow<UiState<MutableList<Favorite>>> = MutableStateFlow(UiState.Loading)
	val uiStateFavoriteMovieEntity: StateFlow<UiState<MutableList<Favorite>>> = _uiStateFavoriteMovieEntity

	fun getFavorites() {
		viewModelScope.launch {
			getFavoriteMoviesUseCase.execute(Unit).catch {
				_uiStateFavoriteMovieEntity.value = UiState.Error(it.message.toString())
			}.collect { favorite ->
				_uiStateFavoriteMovieEntity.value = UiState.Success(favorite.toMutableList())
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