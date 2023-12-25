package kr.dagger.composetmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(
	@SerializedName("adult")
	val adult: Boolean? = null,
	@SerializedName("original_title")
	val originalTitle: String? = null,
	@SerializedName("poster_path")
	val posterPath: String? = null,
	@SerializedName("release_date")
	val releaseDate: String? = null,
	@SerializedName("runtime")
	val runTime: Int? = null,
	@SerializedName("vote_average")
	val voteAverage: Double? = null
)
