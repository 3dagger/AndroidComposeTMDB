package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.network.model.DetailResponse

object DetailMapper {
	fun mapFromDetailResponseToModel(detailResponse: DetailResponse) =
		Detail(
			id = detailResponse.id ?: 0,
			adult = detailResponse.adult ?: false,
			backdropPath = detailResponse.backdropPath ?: "",
			genre = detailResponse.genre?.map {
				Detail.Genre(
					id = it.id ?: 0,
					name = it.name ?: "",
				)
			} ?: listOf(),
			originalTitle = detailResponse.originalTitle ?: "",
			overview = detailResponse.overview ?: "",
			popularity = detailResponse.popularity ?: 0.0,
			posterPath = detailResponse.posterPath ?: "",
			releaseDate = detailResponse.releaseDate ?: "",
			runTime = detailResponse.runTime ?: 0,
			status = detailResponse.status ?: "",
			voteAverage = detailResponse.voteAverage ?: 0.0,
			voteCount = detailResponse.voteCount ?: 0,
		)
}