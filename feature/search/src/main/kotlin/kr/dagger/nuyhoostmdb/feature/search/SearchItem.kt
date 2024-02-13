package kr.dagger.nuyhoostmdb.feature.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.utils.click.clickableSingle

@Composable
fun SearchItem(
	modifier: Modifier = Modifier,
	id: Int,
	posterPath: String,
	title: String,
	voteAverage: Double,
	onClick: (Int) -> Unit,
) {
	ListItem(
		leadingContent = {
			MovieImage(posterUrl = posterPath)
		},
		headlineContent = {
			Text(text = title)
		},
		supportingContent = {
			Text(text = "평점 : $voteAverage")
		},
		colors = ListItemDefaults.colors(
			containerColor = Color.Transparent,
		),
		modifier = modifier
			.clickableSingle {
				onClick(id)
			}
	)
}

@Composable
private fun MovieImage(
	modifier: Modifier = Modifier,
	posterUrl: String
) {
	if (posterUrl.isEmpty()) {
		Icon(
			modifier = modifier
				.background(Color.Transparent)
				.size(100.dp)
				.padding(4.dp),
			imageVector = NuyhoosIcons.Person,
			contentDescription = null
		)
	} else {
		val painter = rememberAsyncImagePainter(
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

//		if (painter.state is AsyncImagePainter.State.Loading) {
//			CircularProgressIndicator(
//				modifier = Modifier
//					.size(40.dp),
//				color = MaterialTheme.colorScheme.onBackground
//			)
//		}

		Image(
			painter = painter,
			colorFilter = colorFilter,
			contentScale = scale,
			contentDescription = null,
			modifier = Modifier
				.size(100.dp)
		)
	}
}

@Preview
@Composable
private fun SearchItemPreview() {
	NuyhoosTheme {
		Surface {
			SearchItem(
				id = 0,
				posterPath = "",
				title = "title test",
				voteAverage = 9.78,
				onClick = {}
			)
		}
	}
}