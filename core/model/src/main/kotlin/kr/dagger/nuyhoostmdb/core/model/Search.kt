package kr.dagger.nuyhoostmdb.core.model

data class Search(
	val page: Int,
	val result: List<SearchItem>,
	val totalPages: Int,
	val totalResults: Int,

) {
	data class SearchItem(
		val adult: Boolean,
		val backdropPath: String,
		val id: Long,
		val originalTitle: String,
		val overview: String,
		val popularity: Double,
		val posterPath: String,
		val releaseDate: String,
		val title: String,
		val voteAverage: Double,
		val voteCount: Int
	)
}