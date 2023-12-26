package kr.dagger.nuyhoostmdb.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kr.dagger.nuyhoostmdb.core.model.Favorite

@Entity(
	tableName = "favorite_movies"
)
data class FavoriteEntity(
	@ColumnInfo(name = "id")
	@PrimaryKey
	val id: Long,
	@ColumnInfo(name = "title")
	val title: String,
	@ColumnInfo(name = "poster_path")
	val posterPath: String,
	@ColumnInfo(name = "over_view")
	val overView: String
)

fun FavoriteEntity.asExternalModel() = Favorite(
	id = id,
	title = title,
	posterPath = posterPath,
	overView = overView
)
