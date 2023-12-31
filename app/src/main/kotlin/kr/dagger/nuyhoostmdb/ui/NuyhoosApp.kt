package kr.dagger.nuyhoostmdb.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.dagger.nuyhoostmdb.R
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosNavigationBar
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosNavigationBarItem
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosTopAppBar
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.navigation.MainNavHost
import kr.dagger.nuyhoostmdb.navigation.BottomBarScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuyhoosApp(
	modifier: Modifier = Modifier,
	navController: NavHostController = rememberNavController()
) {
	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentRoute = navBackStackEntry?.destination?.route

	Scaffold(
		modifier = modifier,
		containerColor = MaterialTheme.colorScheme.onBackground,
		bottomBar = {
			if (isBottomScreen(currentRoute)) {
				NuyhoosBottomBar(navController = navController)
			}
		}
	) {
		Column(
			modifier = modifier.fillMaxSize()
		) {
			if (isBottomScreen(currentRoute)) {
				NuyhoosTopAppBar(
					titleRes = getCurrentTitleRes(currentRoute),
					actionIcon = NuyhoosIcons.MoreVert,
					actionIconContentDescription = "",
					onActionClick = {},
				)
			}
			MainNavHost(navController = navController, innerPadding = it)
		}
	}
}

@Composable
private fun NuyhoosBottomBar(
	navController: NavHostController,
	modifier: Modifier = Modifier,
) {
	val screens = listOf(
		BottomBarScreen.Home,
		BottomBarScreen.Bookmark,
		BottomBarScreen.Search,
		BottomBarScreen.Setting
	)

	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry?.destination

	NuyhoosNavigationBar(
		modifier = modifier
	) {
		screens.forEach { screen ->
			val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
			NuyhoosNavigationBarItem(
				modifier = modifier,
				selected = selected,
				icon = {
					Icon(
						imageVector = screen.icon,
						contentDescription = null,
					)
				},
				selectedIcon = {
					Icon(
						imageVector = screen.selectedIcon,
						contentDescription = null,
					)
				},
				label = {
					Text(
						text = stringResource(id = screen.label)
					)
				},
				onClick = {
					navController.navigate(screen.route) {
						popUpTo(navController.graph.findStartDestination().id) {
							saveState = true
						}
						launchSingleTop = true
						restoreState = true
					}
				}
			)
		}
	}
}

private fun isBottomScreen(currentRoute: String?): Boolean{
	val screens = listOf(
		BottomBarScreen.Home.route,
		BottomBarScreen.Bookmark.route,
		BottomBarScreen.Search.route,
		BottomBarScreen.Setting.route,
	)

	return screens.any { it == currentRoute }
}

private fun getCurrentTitleRes(currentRoute: String?): Int {
	return when (currentRoute) {
		BottomBarScreen.Home.route -> R.string.app_name
		BottomBarScreen.Bookmark.route -> BottomBarScreen.Bookmark.label
		BottomBarScreen.Search.route -> BottomBarScreen.Search.label
		BottomBarScreen.Setting.route -> BottomBarScreen.Setting.label
		else -> R.string.app_name
	}
}