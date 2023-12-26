//package kr.dagger.nuyhoostmdb.core.designsystem.component
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.Immutable
//import androidx.compose.runtime.staticCompositionLocalOf
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.Dp
//
//@Composable
//fun NuyhoosBackground(
//	modifier: Modifier = Modifier,
//	content: @Composable () -> Unit,
//) {
//	val color = LocalBackgroundTheme.current.color
//}
//
///**
// * A class to model background color and tonal elevation values for Now in Android.
// */
//@Immutable
//data class BackgroundTheme(
//	val color: Color = Color.Unspecified,
//	val tonalElevation: Dp = Dp.Unspecified,
//)
//
///**
// * A composition local for [BackgroundTheme].
// */
//val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }