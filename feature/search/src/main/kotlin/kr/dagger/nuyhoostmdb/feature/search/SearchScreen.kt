package kr.dagger.nuyhoostmdb.feature.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.nuyhoostmdb.core.ui.MainTemplate

@Composable
fun SearchScreen(
	modifier: Modifier = Modifier,
	viewModel: SearchViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	MainTemplate(
		modifier = modifier,
		topBar = {

		},
		content = {

		}
	)
}