package kr.dagger.nuyhoostmdb.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteButton(
	modifier: Modifier = Modifier,
	color: Color = Color(0xFFE91E63),
	isFavorite: Boolean,
	isFavoriteScreen: Boolean,
	onFavoriteClick: (Boolean) -> Unit
) {
	var isFavoriteState by remember { mutableStateOf(isFavorite) }

	IconToggleButton(checked = isFavoriteState, onCheckedChange = {
		isFavoriteState = !isFavoriteState
		onFavoriteClick(isFavoriteState)
	}) {
		if (isFavoriteScreen) {
			Icon(
				tint = color,
				modifier = modifier.graphicsLayer {
					scaleX = 1.3F
					scaleY = 1.3F
				},
				imageVector = Icons.Filled.Close,
				contentDescription = "Close"
			)
		} else {
			Icon(
				tint = color,
				modifier = modifier.graphicsLayer {
					scaleX = 1.3F
					scaleY = 1.3F
				},
				imageVector = if (isFavoriteState) {
					Icons.Filled.Favorite
				} else {
					Icons.Filled.FavoriteBorder
				},
				contentDescription = "Favorite"
			)
		}
	}

}

@Preview
@Composable
fun FavoriteButtonPreview() {
//	FavoriteButton{
//
//	}
}