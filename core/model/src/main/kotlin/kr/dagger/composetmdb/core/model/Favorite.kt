package kr.dagger.composetmdb.core.model

data class Favorite(
	val id: Long,
	val title: String,
	val posterPath: String,
	val overView: String
)