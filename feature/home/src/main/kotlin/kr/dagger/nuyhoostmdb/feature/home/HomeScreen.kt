package kr.dagger.nuyhoostmdb.feature.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.orhanobut.logger.Logger
import kr.dagger.nuyhoostmdb.core.model.Movie
import kr.dagger.nuyhoostmdb.core.model.Popular
import kr.dagger.nuyhoostmdb.core.model.UpComing
import kr.dagger.nuyhoostmdb.core.ui.Progress

@Composable
fun HomeRoute(
	modifier: Modifier = Modifier,
	viewModel: HomeViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	val upComingUiState by viewModel.upComingStateFlow.collectAsStateWithLifecycle()
	val lazyPagingItems = viewModel.popularPagingDataFlow.collectAsLazyPagingItems()
	HomeScreen(
		upComingState = upComingUiState,
		pagingItems = lazyPagingItems,
		navigateToDetail = navigateToDetail,
		modifier = modifier
	)
}

@Composable
internal fun HomeScreen(
	upComingState: UpComingUiState,
	modifier: Modifier = Modifier,
	pagingItems: LazyPagingItems<Popular>,
	navigateToDetail: (Int) -> Unit,
) {
	Box(
		modifier = modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background)
	) {
		LazyColumn(
//			modifier = Modifier.fillMaxSize()
		) {
			item {
				Text(text = "UpComing", style = TextStyle(fontSize = 20.sp))
			}

			item {
				when (upComingState) {
					UpComingUiState.Loading -> {
						Logger.d("loading")
					}

					is UpComingUiState.Fail -> {
						Logger.d("error : ${upComingState.errorMessage}")
					}

					is UpComingUiState.Success -> {
						Logger.d("success : ${upComingState.movie}")
						UpComingMovieItemContent(
							items = upComingState.movie,
							navigateToDetail = navigateToDetail
						)
					}
				}
			}

			item {
				pagingItems.let {
					when (it.loadState.refresh) {
						is LoadState.Loading -> Progress()
						is LoadState.Error -> {
							val message =
								(it.loadState.refresh as? LoadState.Error)?.error?.message
									?: return@let
							Text(text = message, color = Color.White)
						}

						else -> {
							PopularMovieItemContent(
								items = it,
								navigateToDetail = navigateToDetail
							)
						}
					}
				}
			}
		}

//		Column {
//			Text(text = "UpComing", style = TextStyle(fontSize = 20.sp))
//
//			when (upComingState) {
//				UpComingUiState.Loading -> { Logger.d("loading")}
//				is UpComingUiState.Fail -> { Logger.d("error : ${upComingState.errorMessage}") }
//				is UpComingUiState.Success -> {
//					Logger.d("success : ${upComingState.movie}")
//					UpComingMovieItemContent(
//						items = upComingState.movie,
//						navigateToDetail = navigateToDetail
//					)
//				}
//			}
//
//			pagingItems.let {
//				when (it.loadState.refresh) {
//					is LoadState.Loading -> Progress()
//					is LoadState.Error -> {
//						val message =
//							(it.loadState.refresh as? LoadState.Error)?.error?.message ?: return@let
//						Text(text = message, color = Color.White)
//					}
//					else -> {
//						PopularMovieItemContent(
//							items = it,
//							navigateToDetail = navigateToDetail
//						)
//					}
//				}
//			}
//		}
	}
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpComingMovieItemContent(
	items: List<UpComing>,
	navigateToDetail: (Int) -> Unit
) {
	LazyRow(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight(),
		contentPadding = PaddingValues(8.dp),
		content = {
			items(
				count = items.size,
				itemContent = { idx ->
					MovieCard(
						modifier = Modifier
							.fillMaxWidth()
							.animateItemPlacement(tween(durationMillis = 100)),
						movie = Movie(
							id = items[idx].id,
							title = items[idx].title,
							posterPath = items[idx].posterPath,
							overView = items[idx].overView,
						),
						navigateToDetail = navigateToDetail,
					)
				},
			)
		}
	)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularMovieItemContent(
	items: LazyPagingItems<Popular>,
	navigateToDetail: (Int) -> Unit
) {
	LazyVerticalGrid(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(max = 35_000.dp)
			.wrapContentHeight(),
		userScrollEnabled = false,
		columns = GridCells.Adaptive(140.dp),
		content = {
			items(items.itemCount) { idx ->
				MovieCard(
					modifier = Modifier
						.fillMaxWidth()
						.animateItemPlacement(tween(durationMillis = 100)),
					movie = Movie(
						id = items[idx]?.id ?: 0,
						title = items[idx]?.title ?: "",
						posterPath = items[idx]?.posterPath ?: "",
						overView = items[idx]?.overView ?: "",
					),
					navigateToDetail = navigateToDetail,
				)
			}
		}, contentPadding = PaddingValues(8.dp)
	)
}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun PopularMovieItemContent(
//	items: LazyPagingItems<Popular>,
//	navigateToDetail: (Int) -> Unit
//) {
//	Column(
//		modifier = Modifier.fillMaxSize()
//	) {
//		LazyVerticalGrid(
//			columns = GridCells.Adaptive(140.dp),
//			content = {
//				items(items.itemCount) { idx ->
//					MovieCard(
//						modifier = Modifier
//							.fillMaxWidth()
//							.animateItemPlacement(tween(durationMillis = 100)),
//						movie = Movie(
//							id = items[idx]?.id ?: 0,
//							title = items[idx]?.title ?: "",
//							posterPath = items[idx]?.posterPath ?: "",
//							overView = items[idx]?.overView ?: "",
//						),
//						navigateToDetail = navigateToDetail,
//					)
//				}
//			}, contentPadding = PaddingValues(8.dp)
//		)
//	}
//}