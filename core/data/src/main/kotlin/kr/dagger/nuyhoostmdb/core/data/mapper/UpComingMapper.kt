package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.UpComing
import kr.dagger.nuyhoostmdb.core.network.model.UpComingItemResponse

object UpComingMapper {

	fun mapFromUpComingResponseToModel(upComingItemResponse: UpComingItemResponse) =
		UpComing(
			id = upComingItemResponse.id ?: 0,
			title = upComingItemResponse.title ?: "",
			posterPath = upComingItemResponse.posterPath ?: "",
			overView = upComingItemResponse.overView ?: "",
		)
}