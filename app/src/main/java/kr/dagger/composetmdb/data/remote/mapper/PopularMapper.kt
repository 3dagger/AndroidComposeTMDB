package kr.dagger.composetmdb.data.remote.mapper

import kr.dagger.composetmdb.data.model.response.PopularItemResponse
import kr.dagger.composetmdb.domain.model.Popular

object PopularMapper {

	fun mapFromPopularResponseToModel(popularItemResponse: PopularItemResponse) =
		Popular(
			popularItemResponse.id ?: 0,
			popularItemResponse.title ?: "",
			popularItemResponse.posterPath ?: "",
			popularItemResponse.overView ?: ""
		)
}