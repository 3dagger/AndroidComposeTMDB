package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(
	@SerializedName("id")
	val id: Long? = null,
	@SerializedName("adult")
	val adult: Boolean? = null,
	@SerializedName("backdrop_path")
	val backdropPath: String? = null,
	@SerializedName("genres")
	val genre: List<GenreResponse>? = null,
	@SerializedName("original_title")
	val originalTitle: String? = null,
	@SerializedName("overview")
	val overview: String? = null,
	@SerializedName("popularity")
	val popularity: Double? = null,
	@SerializedName("poster_path")
	val posterPath: String? = null,
	@SerializedName("release_date")
	val releaseDate: String? = null,
	@SerializedName("runtime")
	val runTime: Int? = null,
	@SerializedName("status")
	val status: String? = null,
	@SerializedName("vote_average")
	val voteAverage: Double? = null,
	@SerializedName("vote_count")
	val voteCount: Int? = null,
	var isBookmark: Boolean? = null
) {
	data class GenreResponse(
		@SerializedName("id")
		val id: Long? = null,
		@SerializedName("name")
		val name: String? = null,
	)
}
