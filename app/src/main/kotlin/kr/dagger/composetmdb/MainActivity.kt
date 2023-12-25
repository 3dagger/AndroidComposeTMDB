package kr.dagger.composetmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.dagger.composetmdb.core.designsystem.theme.ComposeTMDBTheme
import kr.dagger.composetmdb.core.designsystem.theme.StatusBarColor
import kr.dagger.composetmdb.navigation.BottomNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComposeTMDBTheme {
				StatusBarColor(color = MaterialTheme.colorScheme.primary)
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.primary,
				) {
					BottomNavigation(Modifier, rememberNavController())
				}
			}
		}
	}
}
