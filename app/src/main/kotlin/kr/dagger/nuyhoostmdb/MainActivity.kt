package kr.dagger.nuyhoostmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import dagger.hilt.android.AndroidEntryPoint
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTmdbTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.StatusBarColor
import kr.dagger.nuyhoostmdb.ui.NuyhoosApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			NuyhoosTmdbTheme{
				StatusBarColor(
					color = MaterialTheme.colorScheme.background,
					isDarkIcons = !isSystemInDarkTheme(),
				)
				NuyhoosApp()
			}
		}
	}
}