package kr.dagger.composetmdb.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
	tableName = "favorite_movies"
)
data class Favorite(
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
