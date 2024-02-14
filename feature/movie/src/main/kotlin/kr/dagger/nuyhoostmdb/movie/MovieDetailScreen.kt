package kr.dagger.nuyhoostmdb.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosIconToggleButton
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.model.Detail

@Composable
fun MovieDetailRoute(
	modifier: Modifier = Modifier,
	viewModel: MovieDetailViewModel = hiltViewModel(),
	navigateBack: () -> Unit
) {
	val movieUiState: MovieUiState by viewModel.movieUiState.collectAsStateWithLifecycle()
	MovieDetailScreen(
		movieUiState = movieUiState,
		modifier = modifier,
		navigateBack = navigateBack,
		bookmarkClick = viewModel::updateBookmark,
	)
}

@Composable
fun MovieDetailScreen(
	movieUiState: MovieUiState,
	modifier: Modifier = Modifier,
	navigateBack: () -> Unit,
	bookmarkClick: (Detail) -> Unit,
) {
	val state = rememberLazyListState()
	Box(
		modifier = modifier.fillMaxSize()
	) {
		LazyColumn(
			state = state,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			when (movieUiState) {
				is MovieUiState.Loading -> item {}
				is MovieUiState.Success -> {
					item {
						Box {
							BackdropPosterItem(
								modifier = modifier
									.fillMaxWidth()
									.wrapContentWidth(),
								posterUrl = movieUiState.data.backdropPath
							)
							MovieToolbar(
								modifier = modifier,
								navigateBack = navigateBack,
								movieDetail = movieUiState.data,
								bookmarkClick = bookmarkClick
							)
						}
					}
					item {
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									start = 10.dp,
									end = 10.dp,
									top = 10.dp,
									bottom = 10.dp
								),
							text = movieUiState.data.originalTitle,
							textAlign = TextAlign.Left,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Bold,
								fontSize = 25.sp
							)
						)
					}
					item {
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									start = 10.dp,
									end = 10.dp,
								),
							text = "개봉일 : ${movieUiState.data.releaseDate}",
							textAlign = TextAlign.Left,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Medium,
								fontSize = 15.sp
							)
						)
					}
					item {
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									top = 5.dp,
									bottom = 5.dp,
									start = 10.dp,
									end = 10.dp,
								),
							text = "평점 : ${movieUiState.data.voteAverage}",
							textAlign = TextAlign.Left,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Medium,
								fontSize = 15.sp
							)
						)
					}
					item {
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									bottom = 5.dp,
									start = 10.dp,
									end = 10.dp,
								),
							text = "투표수 : ${movieUiState.data.voteCount}",
							textAlign = TextAlign.Left,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Medium,
								fontSize = 15.sp
							)
						)
					}
					item {
						val isAdult = movieUiState.data.adult
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									bottom = 10.dp,
									start = 10.dp,
									end = 10.dp,
								),
							text = "청소년 관람 여부 : ${if (isAdult) "N" else "Y"}",
							textAlign = TextAlign.Left,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Medium,
								fontSize = 15.sp
							)
						)
					}
					item {
						Text(
							modifier = Modifier
								.fillMaxWidth()
								.padding(
									start = 10.dp,
									end = 10.dp,
								),
							text = movieUiState.data.overview,
							style = TextStyle(
								color = MaterialTheme.colorScheme.onBackground,
								fontWeight = FontWeight.Medium,
								fontSize = 15.sp
							)
						)
					}
				}

				is MovieUiState.Fail -> {}
			}
		}
	}
}

@Composable
private fun MovieToolbar(
	modifier: Modifier = Modifier,
	movieDetail: Detail,
	navigateBack: () -> Unit,
	bookmarkClick: (Detail) -> Unit,
) {
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier
			.fillMaxWidth()
			.padding(bottom = 32.dp),
	) {
		IconButton(onClick = navigateBack) {
			Icon(
				imageVector = NuyhoosIcons.ArrowBack,
				contentDescription = null,
				tint = Color.White,
			)
		}

		BookmarkButton(
			modifier = modifier,
			isBookmarked = movieDetail.isBookmarked
		) {
			bookmarkClick(movieDetail)
		}

	}
}

@Composable
private fun BookmarkButton(
	modifier: Modifier = Modifier,
	isBookmarked: Boolean,
	onClick: () -> Unit,
) {
	NuyhoosIconToggleButton(
		isChecked = isBookmarked,
		onCheckedChange = { onClick() },
		icon = {
			Icon(
				imageVector = NuyhoosIcons.BookmarkBorder,
				contentDescription = null,
				tint = Color.White,
			)
		},
		checkedIcon = {
			Icon(
				imageVector = NuyhoosIcons.Bookmark,
				contentDescription = null,
				tint = Color.White,
			)
		}
	)
}

@Composable
private fun BoxScope.BackdropPosterItem(
	modifier: Modifier = Modifier,
	posterUrl: String?
) {
	val painter = rememberAsyncImagePainter(
		model = "https://image.tmdb.org/t/p/original/$posterUrl",
		error = rememberVectorPainter(image = NuyhoosIcons.Person),
	)

	val colorFilter = when (painter.state) {
		is AsyncImagePainter.State.Loading, is AsyncImagePainter.State.Error -> ColorFilter.tint(
			MaterialTheme.colorScheme.onBackground
		)

		else -> null
	}

	val scale = if (painter.state !is AsyncImagePainter.State.Success) {
		ContentScale.Crop
	} else {
		ContentScale.FillBounds
	}

	if (painter.state is AsyncImagePainter.State.Loading) {
		CircularProgressIndicator(
			modifier = modifier
				.align(Alignment.Center)
				.size(60.dp),
			color = MaterialTheme.colorScheme.onBackground
		)
	}

	Image(
		modifier = modifier
			.fillMaxWidth()
			.height(300.dp),
		painter = painter,
		colorFilter = colorFilter,
		contentScale = scale,
		contentDescription = "itemName",
	)
}