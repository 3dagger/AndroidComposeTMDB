package kr.dagger.composetmdb.core.designsystem.theme

import android.app.Activity
import android.os.Build
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
fun ComposeTMDBTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	dynamicColor: Boolean = true,
	content: @Composable () -> Unit
) {
	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	val colorScheme = when {
		dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
			val context = LocalContext.current
			if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
		}

		darkTheme -> DarkColorScheme
		else -> LightColorScheme
	}
	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = colorScheme.primary.toArgb()
			WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
		}
	}

	MaterialTheme(
		colorScheme = colors,
		typography = MaterialTheme.typography,
		shapes = Shapes,
		content = content
	)
}