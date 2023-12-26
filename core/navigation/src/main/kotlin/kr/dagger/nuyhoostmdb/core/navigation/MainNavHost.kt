//package kr.dagger.nuyhoostmdb.core.navigation
//
//import android.app.appsearch.AppSearchSchema
//import android.util.Log
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//import kr.dagger.nuyhoostmdb.ui.navigation.model.BottomBarScreen
//import kr.dagger.nuyhoostmdb.ui.navigation.model.GeneralScreen
//import kr.dagger.nuyhoostmdb.ui.screen.detail.DetailScreen
//import kr.dagger.nuyhoostmdb.ui.screen.favorite.FavoriteScreen
//import kr.dagger.nuyhoostmdb.ui.screen.home.HomeScreen
//import kr.dagger.nuyhoostmdb.ui.screen.search.SearchScreen
//import kr.dagger.nuyhoostmdb.ui.screen.setting.SettingScreen
//
//@Composable
//fun MainNavHost(
//	navController: NavHostController,
//	innerPadding: PaddingValues
//) {
//	NavHost(
//		navController = navController,
//		startDestination = BottomBarScreen.Home.route,
//		modifier = Modifier.padding(innerPadding)
//	) {
//		composable(BottomBarScreen.Home.route) {
//			Log.d("leeam", "11?")
//			HomeScreen(
//				modifier = Modifier.fillMaxSize(),
//				navigateToDetail = { id ->
//					navController.navigate(GeneralScreen.DetailMovie.createRoute(id))
//				}
//			)
//		}
//
//		composable(BottomBarScreen.Favorite.route) {
//			FavoriteScreen(
//				modifier = Modifier.fillMaxSize(),
//				onAddFavoriteMovie = { }) {
//			}
//		}
//
//		composable(
//			route = GeneralScreen.DetailMovie.route,
//			arguments = listOf(navArgument("id") { type = NavType.IntType })
//			) {
//			val id = it.arguments?.getInt("id") ?: -1
//			DetailScreen(
//				id = id,
//				navigateBack = {
//					navController.navigateUp()
//				}
//			)
//		}
//
//		composable(
//			route = BottomBarScreen.Search.route
//		) {
//			SearchScreen(
//				modifier = Modifier.fillMaxSize()
//			)
//		}
//
//		composable(BottomBarScreen.Setting.route) {
//			SettingScreen(
//				modifier = Modifier.fillMaxSize()
//			)
//		}
//	}
//}