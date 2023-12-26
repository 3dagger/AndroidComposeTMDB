package kr.dagger.nuyhoostmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.dagger.nuyhoostmdb.core.designsystem.theme.nuyhoostmdbTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.StatusBarColor
import kr.dagger.nuyhoostmdb.navigation.BottomNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			nuyhoostmdbTheme {
				StatusBarColor(
					color = MaterialTheme.colorScheme.background,
					isDarkIcons = !isSystemInDarkTheme(),
				)
				Surface(
					modifier = Modifier.fillMaxSize(),
//					color = MaterialTheme.colorScheme.primary,
				) {
					BottomNavigation(Modifier, rememberNavController())
				}
			}
		}
	}
}