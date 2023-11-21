package kr.dagger.composetmdb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.dagger.composetmdb.ui.navigation.BottomNav
import kr.dagger.composetmdb.ui.theme.ComposeTMDBTheme
import kr.dagger.composetmdb.ui.theme.StatusBarColor

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComposeTMDBTheme {
				StatusBarColor(color = MaterialTheme.colors.primary)
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					BottomNav(Modifier, rememberNavController())
				}
			}
		}
	}
}
