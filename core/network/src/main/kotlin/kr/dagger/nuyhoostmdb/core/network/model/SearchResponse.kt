package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
	@SerializedName("page")
	val page: Int? = null,
	@SerializedName("results")
	val results: List<SearchItemResponse>? = null,
	@SerializedName("total_pages")
	val totalPages: Int? = null,
	@SerializedName("total_results")
	val totalResults: Int? = null
)