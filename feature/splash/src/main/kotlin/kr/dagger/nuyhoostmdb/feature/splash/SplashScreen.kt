package kr.dagger.nuyhoostmdb.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.ui.ThemePreviews

@Composable
fun SplashRoute(
	modifier: Modifier = Modifier,
	viewModel: SplashViewModel = hiltViewModel(),
	navigateToMain: () -> Unit,
) {
	val isMoveToMain by viewModel.observe.collectAsStateWithLifecycle(initialValue = false)

	SplashScreen(
		modifier = modifier
			.background(MaterialTheme.colorScheme.background)
	)

	if (isMoveToMain) {
		LaunchedEffect(key1 = true) {
			delay(500L)
			navigateToMain()
		}
	}
}

@Composable
internal fun SplashScreen(
	modifier: Modifier = Modifier,
) {
	Box(
		modifier = modifier.fillMaxSize()
	) {
		Text(
			text = "NuyhoosTMDB",
			modifier = Modifier.align(Alignment.Center),
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.Bold,
			fontSize = 45.sp
		)
	}
}

@ThemePreviews
@Composable
fun SplashScreenPreview() {
	NuyhoosTheme {
		SplashScreen()
	}
}