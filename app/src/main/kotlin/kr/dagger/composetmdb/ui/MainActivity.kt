package kr.dagger.composetmdb.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
//				StatusBarColor(color = MaterialTheme.colorScheme.primary)
				Surface(
					modifier = Modifier.fillMaxSize(),
//					color = MaterialTheme.colorScheme.background
					color = Color.Black,
				) {
					BottomNav(Modifier, rememberNavController())
				}
			}
		}
	}
}
