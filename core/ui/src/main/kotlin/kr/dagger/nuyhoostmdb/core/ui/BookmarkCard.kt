package kr.dagger.nuyhoostmdb.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kr.dagger.nuyhoostmdb.core.designsystem.component.NuyhoosIconToggleButton
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.utils.click.clickableSingle

@Composable
fun BookmarkCard(
	modifier: Modifier = Modifier,
	bookmark: Bookmark,
	onClickRemove: (Long) -> Unit,
	navigateToDetail: (Int) -> Unit,
) {
	Card(
		shape = RoundedCornerShape(8.dp),
		modifier = modifier
			.padding(8.dp)
			.defaultMinSize()
			.clickableSingle { navigateToDetail(bookmark.id.toInt()) },
	) {
		Column {
			Box(
				contentAlignment = Alignment.TopEnd
			) {
				PosterItem(
					posterUrl = bookmark.posterPath,
					itemName = bookmark.title
				)
				NuyhoosIconToggleButton(
					isChecked = true,
					onCheckedChange = {
						onClickRemove(bookmark.id)
					},
					icon = {
						Icon(
							imageVector = NuyhoosIcons.BookmarkBorder,
							contentDescription = null,
							tint = Color.White,
						)
					},
					checkedIcon = {
						Icon(
							imageVector = NuyhoosIcons.Bookmark,
							contentDescription = null,
							tint = Color.White,
						)
					},
				)
			}
		}
	}
}

@Composable
private fun BoxScope.PosterItem(posterUrl: String?, itemName: String) {
	val painter = rememberAsyncImagePainter(
		model = "https://image.tmdb.org/t/p/original/$posterUrl",
		error = rememberVectorPainter(image = NuyhoosIcons.Person)
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