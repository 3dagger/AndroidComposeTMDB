package kr.dagger.composetmdb.data.model.response

import com.google.gson.annotations.SerializedName

data class PopularResponse(
	@SerializedName("results")
	val results: List<PopularItemResponse>
)
