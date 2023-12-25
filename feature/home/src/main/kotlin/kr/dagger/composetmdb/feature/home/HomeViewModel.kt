package kr.dagger.composetmdb.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.dagger.composetmdb.core.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import kr.dagger.composetmdb.core.domain.usecase.favorite.GetFavo
import kr.dagger.composetmdb.core.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kr.dagger.composetmdb.core.domain.usecase.favorite.InsertFavoriteMovieUseCase
import kr.dagger.composetmdb.core.domain.usecase.movie.GetPopularMoviePagingUseCase
import kr.dagger.composetmdb.core.domain.usecase.movie.GetPopularMovieUseCase
import kr.dagger.composetmdb.core.model.Favorite
import kr.dagger.composetmdb.core.model.Popular
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val getPopularMovieUseCase: GetPopularMovieUseCase,
	private val insertFavoriteMovieUseCase: InsertFavoriteMovieUseCase,
	private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
	private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
	private val getPopularMoviePagingUseCase: GetPopularMoviePagingUseCase,
	private val getFavo: GetFavo
) : ViewModel() {
	private val _uiStatePopularMovie: MutableStateFlow<HomeUiState<MutableList<Popular>>> =
		MutableStateFlow(HomeUiState.Loading)
	//	val popularPagingDataFlow: Flow<PagingData<Popular>> = getPopularMoviePagingUseCase.execute(Unit).cachedIn(viewModelScope)


	val popularPagingDataFlow: Flow<PagingData<Popular>> = getPopularMoviePagingUseCase.execute(Unit)
		.map { pagingData ->
			pagingData.map { popular ->
				if (popular.id in getFavorites().map { it.id }.toSet()) {
					popular.isFavorite = true
				}
				popular
			}.also {
//				Logger.d("res :: $it")
			}
		}
		.cachedIn(viewModelScope)

//	private suspend fun getFavorites(): Flow<List<Favorite>> {
//		return withContext(Dispatchers.IO) {
//			getFavoriteMoviesUseCase.execute(Unit)
//		}
//	}


	private suspend fun getFavorites(): List<Favorite> {
		return withContext(Dispatchers.IO) {
			getFavo.execute(Unit)
		}
	}


//	private fun getPopularMovies(favorite: List<Favorite>) {
//		viewModelScope.launch {
//			getPopularMovieUseCase.execute(Unit).catch {
//				_uiStatePopularMovie.value = UiState.Error(it.message.toString())
//			}.collect { movie ->
//				_uiStatePopularMovie.value = if (favorite.isEmpty()) {
//					UiState.Success(movie.toMutableList())
//				} else {
//					val list = movie.map { popular ->
//						if (popular.id in favorite.map { it.id }.toSet()) {
//							popular.isFavorite = true
//						}
//						popular
//					}
//					UiState.Success(list.toMutableList())
//				}
//			}
//		}
//	}
//
//	fun getFavoriteMovies() {
//		viewModelScope.launch {
//			getFavoriteMoviesUseCase.execute(Unit).catch {
//				_uiStatePopularMovie.value = UiState.Error(it.message.toString())
//			}.collect {
//				getPopularMovies(it)
//			}
//		}
//	}

	fun insertFavoriteMovie(favorite: Favorite) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				insertFavoriteMovieUseCase.execute(favorite)
			}
		}
	}

	fun deleteFavoriteMovie(id: Long) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				deleteFavoriteMovieUseCase.execute(id)
			}
		}
	}
}