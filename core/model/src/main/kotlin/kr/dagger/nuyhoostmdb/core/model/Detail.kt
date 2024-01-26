package kr.dagger.nuyhoostmdb.core.model

data class Detail(
	val id: Long,
	val adult: Boolean,
	val backdropPath: String,
	val genre: List<Genre>,
	val originalTitle: String,
	val overview: String,
	val popularity: Double,
	val posterPath: String,
	val releaseDate: String,
	val runTime: Int,
	val status: String,
	val voteAverage: Double,
	val voteCount: Int,
	var isBookmarked: Boolean,
) {
	data class Genre(
		val id: Long,
		val name: String,
	)
}
