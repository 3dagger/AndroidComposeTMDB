package kr.dagger.nuyhoostmdb.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.dagger.nuyhoostmdb.feature.favorite.FavoriteScreen
import kr.dagger.nuyhoostmdb.feature.home.HomeScreen
import kr.dagger.nuyhoostmdb.feature.search.SearchScreen
import kr.dagger.nuyhoostmdb.feature.setting.SettingScreen
import kr.dagger.nuyhoostmdb.movie.MovieDetailScreen
import kr.dagger.nuyhoostmdb.navigation.model.BottomBarScreen
import kr.dagger.nuyhoostmdb.navigation.model.GeneralScreen

@Composable
fun MainNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier,
	innerPadding: PaddingValues
) {
	NavHost(
		navController = navController,
		startDestination = BottomBarScreen.Home.route,
		modifier = modifier.padding(innerPadding)
	) {
		composable(BottomBarScreen.Home.route) {
			HomeScreen(
				modifier = modifier.fillMaxSize(),
				navigateToDetail = { id ->
					navController.navigate(GeneralScreen.DetailMovie.createRoute(id))
				}
			)
		}

		composable(BottomBarScreen.Favorite.route) {
			FavoriteScreen(
				modifier = modifier.fillMaxSize(),
				onAddFavoriteMovie = { },
			) {
			}
		}

		composable(
			route = GeneralScreen.DetailMovie.route,
			arguments = listOf(navArgument("id") { type = NavType.IntType })
		) {
			val id = it.arguments?.getInt("id") ?: -1
			MovieDetailScreen(
				modifier = modifier.fillMaxSize(),
				id = id,
				navigateBack = {
					navController.navigateUp()
				}
			)
		}

		composable(BottomBarScreen.Search.route) {
			SearchScreen(
				modifier = modifier.fillMaxSize(),
			) {}
		}

		composable(BottomBarScreen.Setting.route) {
			SettingScreen(
				modifier = modifier.fillMaxSize()
			) {}
		}
	}
}