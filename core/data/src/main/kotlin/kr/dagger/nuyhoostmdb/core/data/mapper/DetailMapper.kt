package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.network.model.DetailResponse

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