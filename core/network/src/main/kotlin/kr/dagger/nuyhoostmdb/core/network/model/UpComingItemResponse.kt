package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class UpComingItemResponse(
	@SerializedName("id")
	val id: Long?,
	@SerializedName("title")
	val title: String?,
	@SerializedName("poster_path")
	val posterPath: String?,
	@SerializedName("overview")
	val overView: String?
)
