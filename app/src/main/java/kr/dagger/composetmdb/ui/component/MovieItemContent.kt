package kr.dagger.composetmdb.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kr.dagger.composetmdb.domain.model.Popular

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItemContent(
	modifier: Modifier = Modifier,
	popular: Popular,
	navigateToDetail: (Int) -> Unit,
	isFavoriteScreen: Boolean,
	favoriteClick: (Boolean) -> Unit
) {
	Card(
		shape = RoundedCornerShape(8.dp),
		modifier = Modifier
			.padding(8.dp)
			.defaultMinSize(),
		onClick = {
			navigateToDetail(popular.id.toInt())
		}
	) {
		Box(
			contentAlignment = Alignment.TopEnd
		) {
			PosterItem(
				posterUrl = popular.posterPath,
				itemName = popular.title
			)
			FavoriteButton(
				isFavorite = popular.isFavorite,
				isFavoriteScreen = isFavoriteScreen
			) {
				favoriteClick(it)
			}

		}
	}
}

@Composable
private fun BoxScope.PosterItem(posterUrl: String?, itemName: String) {
	val painter = rememberAsyncImagePainter(
		model = "https://image.tmdb.org/t/p/w342/$posterUrl",
		error = rememberVectorPainter(image = Icons.Filled.Edit)
	)
	val colorFilter = when (painter.state) {
		is AsyncImagePainter.State.Loading, is AsyncImagePainter.State.Error -> ColorFilter.tint(
			MaterialTheme.colors.primary
		)
		else -> null
	}
	val scale = if (painter.state !is AsyncImagePainter.State.Success) {
		ContentScale.Crop
	} else {
		ContentScale.FillBounds
	}

	Image(
		painter = painter,
		colorFilter = colorFilter,
		contentScale = scale,
		contentDescription = itemName,
		modifier = Modifier
			.size(200.dp)
			.align(Alignment.Center)
	)
}