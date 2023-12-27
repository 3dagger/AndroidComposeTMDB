package kr.dagger.nuyhoostmdb.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosTopAppBar
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.navigation.BottomBar
import kr.dagger.nuyhoostmdb.navigation.MainNavHost
import kr.dagger.nuyhoostmdb.navigation.model.BottomBarScreen

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
			if (currentRoute == BottomBarScreen.Home.route ||
				currentRoute == BottomBarScreen.Favorite.route ||
				currentRoute == BottomBarScreen.Search.route ||
				currentRoute == BottomBarScreen.Setting.route
			) {
				BottomBar(navController)
			}
		}
	) {
		Column(
			modifier = modifier.fillMaxSize()
		) {
			if (currentRoute == BottomBarScreen.Home.route ||
				currentRoute == BottomBarScreen.Favorite.route ||
				currentRoute == BottomBarScreen.Search.route ||
				currentRoute == BottomBarScreen.Setting.route
			) {
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

private fun getCurrentTitleRes(currentRoute: String?): Int {
	return when (currentRoute) {
		BottomBarScreen.Home.route -> BottomBarScreen.Home.titleResId
		BottomBarScreen.Favorite.route -> BottomBarScreen.Favorite.titleResId
		BottomBarScreen.Search.route -> BottomBarScreen.Search.titleResId
		BottomBarScreen.Setting.route -> BottomBarScreen.Setting.titleResId
		else -> BottomBarScreen.Home.titleResId
	}
}