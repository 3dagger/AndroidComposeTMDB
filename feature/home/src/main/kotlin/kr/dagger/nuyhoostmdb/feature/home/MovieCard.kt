package kr.dagger.nuyhoostmdb.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kr.dagger.nuyhoostmdb.core.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(
	modifier: Modifier = Modifier,
	movie: Movie,
	navigateToDetail: (Int) -> Unit,
) {
	Card(
		shape = RoundedCornerShape(8.dp),
		modifier = modifier
			.padding(8.dp)
			.defaultMinSize(),
		onClick = {
			navigateToDetail(movie.id.toInt())
		}
	) {
		Column {
			Box(
				contentAlignment = Alignment.TopEnd
			) {
				PosterItem(
					posterUrl = movie.posterPath,
					itemName = movie.title
				)
			}

			Text(
				modifier = Modifier.align(Alignment.CenterHorizontally),
				text = movie.title,
				style = TextStyle(fontSize = 15.sp)
			)
		}

	}
}

@Composable
private fun BoxScope.PosterItem(posterUrl: String?, itemName: String) {
	val painter = rememberAsyncImagePainter(
//		model = "https://image.tmdb.org/t/p/w342/$posterUrl",
		model = "https://image.tmdb.org/t/p/original/$posterUrl",
		error = rememberVectorPainter(image = Icons.Filled.Edit)
	)
	val colorFilter = when (painter.state) {
		is AsyncImagePainter.State.Loading, is AsyncImagePainter.State.Error -> ColorFilter.tint(
			MaterialTheme.colorScheme.primary
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

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MovieCard(
//	modifier: Modifier = Modifier,
//	movie: Movie,
//	navigateToDetail: (Int) -> Unit,
//) {
//	Card(
//		shape = RoundedCornerShape(8.dp),
//		modifier = modifier
//			.padding(8.dp)
//			.defaultMinSize(),
//		onClick = {
//			navigateToDetail(movie.id.toInt())
//		}
//	) {
//		Box(
//			contentAlignment = Alignment.TopEnd
//		) {
//			PosterItem(
//				posterUrl = movie.posterPath,
//				itemName = movie.title
//			)
//		}
//	}
//}
//
//@Composable
//private fun BoxScope.PosterItem(posterUrl: String?, itemName: String) {
//	val painter = rememberAsyncImagePainter(
////		model = "https://image.tmdb.org/t/p/w342/$posterUrl",
//		model = "https://image.tmdb.org/t/p/original/$posterUrl",
//		error = rememberVectorPainter(image = Icons.Filled.Edit)
//	)
//	val colorFilter = when (painter.state) {
//		is AsyncImagePainter.State.Loading, is AsyncImagePainter.State.Error -> ColorFilter.tint(
//			MaterialTheme.colorScheme.primary
//		)
//
//		else -> null
//	}
//	val scale = if (painter.state !is AsyncImagePainter.State.Success) {
//		ContentScale.Crop
//	} else {
//		ContentScale.FillBounds
//	}
//
//	Image(
//		painter = painter,
//		colorFilter = colorFilter,
//		contentScale = scale,
//		contentDescription = itemName,
//		modifier = Modifier
//			.size(200.dp)
//			.align(Alignment.Center)
//	)
//}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

@Preview
@Composable
fun MovieCardPreview() {
	MovieCard(
		movie = Movie(
			id = 11,
			title = "Migration",
			posterPath = "/ptz5ETMxDoRRiE69BVuIxJzyTEO.jpg",
			overView = ""
		),
		navigateToDetail = {}
	)
}
//
//@Preview
//@Composable
//fun PosterItemPreview() {
//	val posterUrl = "https://image.tmdb.org/t/p/original/ptz5ETMxDoRRiE69BVuIxJzyTEO.jpg"
//	val itemName = "Migration"
//	Card(
//		shape = RoundedCornerShape(8.dp),
//		modifier = Modifier
//			.padding(8.dp)
//			.defaultMinSize()
//	){
//		Box(
//			modifier = Modifier.size(200.dp),
//			contentAlignment = Alignment.TopEnd
//		){
//			PosterItem(posterUrl = posterUrl, itemName = itemName)
//		}
//	}
//
//}


//@Composable
//fun FavoriteButton(
//	isFavorite: Boolean,
//	onClick: () -> Unit,
//	modifier: Modifier = Modifier
//) {
//	NuyhoosIconToggleButton(
//		isChecked = isFavorite,
//		onCheckedChange = { onClick() },
//		modifier = modifier,
//		icon = {
//			Icon(
//				imageVector = NuyhoosIcons.FavoriteBorder,
//				contentDescription = null
//			)
//		},
//		checkedIcon = {
//			Icon(
//				imageVector = NuyhoosIcons.Favorite,
//				contentDescription = null
//			)
//		}
//	)
//}