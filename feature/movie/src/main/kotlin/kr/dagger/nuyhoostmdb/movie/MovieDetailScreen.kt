package kr.dagger.nuyhoostmdb.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieDetailScreen(
	id: Int,
	modifier: Modifier = Modifier,
	viewModel: MovieDetailViewModel = hiltViewModel(),
	navigateBack: () -> Unit
) {
	Box(
		modifier = modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background)
	) {
		Row {
			viewModel.getMovieDetail(id)
//			Text(text = 'MovieDetail')
		}
	}
}