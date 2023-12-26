package kr.dagger.nuyhoostmdb.core.designsystem.theme

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
	primary = Purple80,
	secondary = PurpleGrey80,
	tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
	primary = Purple40,
	secondary = PurpleGrey40,
	tertiary = Pink40
)

private val DarkColorPalette = darkColorScheme(
	primary = md_theme_dark_primary,
	onPrimary = md_theme_dark_onPrimary,
	primaryContainer = md_theme_dark_primaryContainer,
	secondary = md_theme_dark_secondary,
	secondaryContainer = md_theme_dark_secondaryContainer,
	background = md_theme_dark_background,
	surface = md_theme_dark_surface,
	error = md_theme_dark_error,
	onSecondary = md_theme_dark_onSecondary,
	onError = md_theme_dark_onError,
)

private val LightColorPalette = lightColorScheme(
	primary = md_theme_light_primary,
	onPrimary = md_theme_light_onPrimary,
	primaryContainer = md_theme_light_primaryContainer,
	secondary = md_theme_light_secondary,
	secondaryContainer = md_theme_light_secondaryContainer,
	background = md_theme_light_background,
	surface = md_theme_light_surface,
	error = md_theme_light_error,
	onSecondary = md_theme_light_onSecondary,
	onError = md_theme_light_onError,
)

@Composable
fun nuyhoostmdbTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {

	Log.d("leeam", "isDarkTheme : $darkTheme")

	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	MaterialTheme(
		colorScheme = colors,
		typography = MaterialTheme.typography,
		shapes = Shapes,
		content = content
	)
}