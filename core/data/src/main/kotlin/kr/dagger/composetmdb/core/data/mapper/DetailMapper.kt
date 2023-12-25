package kr.dagger.composetmdb.core.data.mapper

import kr.dagger.composetmdb.core.model.Detail
import kr.dagger.composetmdb.core.network.model.DetailResponse

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