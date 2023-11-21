package kr.dagger.composetmdb.ui.screen.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.composetmdb.ui.templete.MainTemplate

@Composable
fun SettingScreen(
	modifier: Modifier = Modifier,
	viewModel: SettingViewModel = hiltViewModel(),
) {
	MainTemplate(
		modifier = modifier,
		topBar = {},
		content = {
			Box(
				modifier = Modifier.fillMaxSize()
					.background(MaterialTheme.colors.primary)
			)
		}
	)
}