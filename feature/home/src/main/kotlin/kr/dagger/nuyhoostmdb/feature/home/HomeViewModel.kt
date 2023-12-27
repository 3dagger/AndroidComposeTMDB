package kr.dagger.nuyhoostmdb.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetNowPlayingMoviesUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetPopularMoviePagingUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.movie.GetUpComingMoviesUseCase
import kr.dagger.nuyhoostmdb.core.model.Popular
import kr.dagger.nuyhoostmdb.core.model.UpComing
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	getPopularMoviePagingUseCase: GetPopularMoviePagingUseCase,
	getUpComingMoviesUseCase: GetUpComingMoviesUseCase,
	private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {


	val upComingStateFlow: StateFlow<UpComingUiState> =
		getUpComingMoviesUseCase.execute(Unit)
			.map<List<UpComing>, UpComingUiState>(UpComingUiState::Success)
			.onStart { emit(UpComingUiState.Loading) }
			.stateIn(
				scope = viewModelScope,
				started = SharingStarted.WhileSubscribed(5_000),
				initialValue = UpComingUiState.Loading
			)



	val popularPagingDataFlow: Flow<PagingData<Popular>> =
		getPopularMoviePagingUseCase.execute(Unit)
			.cachedIn(viewModelScope)
}


sealed interface UpComingUiState {
	data object Loading : UpComingUiState

	data class Fail(
		val errorMessage: String
	) : UpComingUiState

	data class Success(
		val movie: List<UpComing>,
	) : UpComingUiState
}