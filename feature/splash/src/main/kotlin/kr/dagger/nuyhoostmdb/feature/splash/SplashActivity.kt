package kr.dagger.nuyhoostmdb.feature.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.StatusBarColor
import kr.dagger.nuyhoostmdb.core.navigator.MainNavigator
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

	private val viewModel: SplashViewModel by viewModels()

	@Inject
	lateinit var mainNavigator: MainNavigator

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		installSplashScreen()

		WindowCompat.setDecorFitsSystemWindows(window, false)

		setContent {
			NuyhoosTheme {
				StatusBarColor(
					color = MaterialTheme.colorScheme.background,
					isDarkIcons = !isSystemInDarkTheme(),
				)
				SplashRoute(
					modifier = Modifier,
					viewModel = viewModel,
					navigateToMain = ::movieMainScreen
				)
			}
		}

		onBackPressedDispatcher.addCallback(this) {
			// Nothing..
		}
	}

	private fun movieMainScreen() {
		mainNavigator.openMainActivity(this)
		finish()
	}
}