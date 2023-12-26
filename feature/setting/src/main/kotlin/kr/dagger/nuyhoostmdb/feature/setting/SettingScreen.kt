package kr.dagger.nuyhoostmdb.feature.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.nuyhoostmdb.core.ui.MainTemplate

@Composable
fun SettingScreen(
	modifier: Modifier = Modifier,
	viewModel: SettingViewModel = hiltViewModel(),
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