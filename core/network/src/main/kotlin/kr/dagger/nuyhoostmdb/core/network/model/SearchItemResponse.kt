package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class SearchItemResponse(
	@SerializedName("adult")
	val adult: Boolean? = null,
	@SerializedName("backdrop_path")
	val backdropPath: String? = null,
	@SerializedName("id")
	val id: Long? = null,
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
	@SerializedName("title")
	val title: String? = null,
	@SerializedName("vote_average")
	val voteAverage: Double? = null,
	@SerializedName("vote_count")
	val voteCount: Int? = null,
)