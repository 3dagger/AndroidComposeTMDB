package kr.dagger.composetmdb.core.data.mapper

import kr.dagger.composetmdb.core.model.Popular
import kr.dagger.composetmdb.core.network.model.PopularItemResponse

object PopularMapper {

	fun mapFromPopularResponseToModel(popularItemResponse: PopularItemResponse) =
		Popular(
			popularItemResponse.id ?: 0,
			popularItemResponse.title ?: "",
			popularItemResponse.posterPath ?: "",
			popularItemResponse.overView ?: ""
		)
}