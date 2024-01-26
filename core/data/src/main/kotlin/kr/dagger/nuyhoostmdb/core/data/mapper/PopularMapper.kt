package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.Movie
import kr.dagger.nuyhoostmdb.core.network.model.PopularItemResponse

object PopularMapper {

	fun mapFromPopularResponseToModel(popularItemResponse: PopularItemResponse) =
		Movie(
			id = popularItemResponse.id ?: 0,
			title = popularItemResponse.title ?: "",
			posterPath = popularItemResponse.posterPath ?: "",
			overView = popularItemResponse.overView ?: "",
		)
}