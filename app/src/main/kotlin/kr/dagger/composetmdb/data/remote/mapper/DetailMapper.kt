package kr.dagger.composetmdb.data.remote.mapper

import kr.dagger.composetmdb.data.model.response.DetailResponse
import kr.dagger.composetmdb.data.model.response.PopularItemResponse
import kr.dagger.composetmdb.domain.model.Detail
import kr.dagger.composetmdb.domain.model.Popular

object DetailMapper {

	fun mapFromDetailResponseToModel(detailResponse: DetailResponse) =
		Detail(
			adult = detailResponse.adult,
			originalTitle = detailResponse.originalTitle,
			posterPath = detailResponse.posterPath,
			releaseDate = detailResponse.releaseDate,
			runTime = detailResponse.runTime,
			voteAverage = detailResponse.voteAverage
		)
}