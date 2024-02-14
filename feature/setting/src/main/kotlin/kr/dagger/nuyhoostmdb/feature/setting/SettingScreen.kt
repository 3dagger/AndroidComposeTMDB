package kr.dagger.nuyhoostmdb.feature.setting

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import kr.dagger.nuyhoostmdb.core.utils.click.clickableSingle

@Composable
fun SettingScreenRoute(
	modifier: Modifier = Modifier,
	viewModel: SettingViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	SettingScreen(
		modifier = modifier,
		navigateToDetail = {},
	)
}

@Composable
fun SettingScreen(
	modifier: Modifier = Modifier,
	navigateToDetail: (Int) -> Unit,
) {
	val context = LocalContext.current
	val state = rememberLazyListState()

	Box(
		modifier = modifier.fillMaxSize()
	) {
		LazyColumn(
			state = state,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			item {
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.clickableSingle {
							startOpenSourceLicenses(context)
						}
				) {
					Text(
						modifier = Modifier
							.fillMaxWidth()
							.align(Alignment.Center)
							.padding(
								vertical = 20.dp,
								horizontal = 15.dp
							),
						text = "오픈소스 라이선스",
						style = TextStyle(
							color = MaterialTheme.colorScheme.onBackground,
							fontSize = 15.sp
						)
					)
					Divider(
						modifier = Modifier
							.fillMaxWidth()
							.align(Alignment.BottomCenter),
						thickness = 0.5.dp,
						color = MaterialTheme.colorScheme.onBackground
					)
				}
			}
			item {
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.clickableSingle {
//							startOpenSourceLicenses(context)
						}
				) {
					Text(
						modifier = Modifier
							.fillMaxWidth()
							.align(Alignment.Center)
							.padding(
								vertical = 20.dp,
								horizontal = 15.dp
							),
						text = "버전 정보",
						style = TextStyle(
							color = MaterialTheme.colorScheme.onBackground,
							fontSize = 15.sp
						)
					)
					Divider(
						modifier = Modifier
							.fillMaxWidth()
							.align(Alignment.BottomCenter),
						thickness = 0.5.dp,
						color = MaterialTheme.colorScheme.onBackground
					)
				}
			}
		}
	}
}


private fun startOpenSourceLicenses(context: Context) {
	context.startActivity(Intent(context, OssLicensesMenuActivity::class.java))
}