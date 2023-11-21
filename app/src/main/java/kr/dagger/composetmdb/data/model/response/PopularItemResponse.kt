package kr.dagger.composetmdb.data.model.response

import com.google.gson.annotations.SerializedName

data class PopularItemResponse(
	@SerializedName("id")
	val id: Long?,
	@SerializedName("title")
	val title: String? = null,
	@SerializedName("poster_path")
	val posterPath: String? = null,
	@SerializedName("overview")
	val overView: String? = null
)
