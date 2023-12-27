package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class UpComingResponse(
	@SerializedName("results")
	val results: List<UpComingItemResponse>
)
