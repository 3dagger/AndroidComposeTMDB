package kr.dagger.nuyhoostmdb.navigation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kr.dagger.nuyhoostmdb.core.designsystem.theme.nuyhoostmdbTheme
import kr.dagger.nuyhoostmdb.core.ui.ThemePreviews
import kr.dagger.nuyhoostmdb.navigation.model.BottomBar
import kr.dagger.nuyhoostmdb.navigation.model.BottomBarScreen

@Composable
fun BottomNavigationItem(
	screen: BottomBar,
	currentDestination: NavDestination?,
	navController: NavHostController
) {
	val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
//	val background = if (selected) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1F) else Color.Transparent
//	val contentColor = if (selected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.background.copy(alpha = 0.4F)

	val background = MaterialTheme.colorScheme.background.copy(alpha = 0.1F)
	val contentColor = MaterialTheme.colorScheme.onBackground

	Box(
		modifier = Modifier
			.height(42.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(background)
			.clickable {
				navController.navigate(screen.route) {
					popUpTo(navController.graph.findStartDestination().id)
					launchSingleTop = true
				}
			}
	) {
		Row(
			modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(4.dp)
		) {
			Icon(
				painter = painterResource(id = if (selected) screen.iconFocused else screen.icon),
				contentDescription = stringResource(id = screen.titleResId),
				tint = contentColor
			)
			AnimatedVisibility(visible = selected) {
				Text(
					text = stringResource(id = screen.titleResId),
					color = contentColor
				)
			}
		}
	}
}



@Preview(widthDp = 100, heightDp = 100, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
@Composable
fun BottomNavigationItemDarkPreview() {
	val ctx = LocalContext.current
	val navController = NavHostController(ctx)

	nuyhoostmdbTheme {
		BottomNavigationItem(
			screen = BottomBarScreen.Home,
			currentDestination = NavDestination(""),
			navController = navController
		)
	}
}

@Preview(widthDp = 100, heightDp = 100, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Composable
fun BottomNavigationItemLightPreview() {
	val ctx = LocalContext.current
	val navController = NavHostController(ctx)

	nuyhoostmdbTheme {
		BottomNavigationItem(
			screen = BottomBarScreen.Home,
			currentDestination = NavDestination(""),
			navController = navController
		)
	}
}