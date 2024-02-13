package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.Search
import kr.dagger.nuyhoostmdb.core.network.model.SearchResponse

object SearchMapper {

	fun mapFromSearchResponseToModel(searchResponse: SearchResponse) =
		Search(
			page = searchResponse.page ?: 0,
			result = searchResponse.results?.map {
				Search.SearchItem(
					adult = it.adult ?: false,
					backdropPath = it.backdropPath ?: "",
					id = it.id ?: 0,
					originalTitle = it.originalTitle ?: "",
					overview = it.overview ?: "",
					popularity = it.popularity ?: 0.0,
					posterPath = it.posterPath ?: "",
					releaseDate = it.releaseDate ?: "",
					title = it.title ?: "",
					voteAverage = it.voteAverage ?: 0.0,
					voteCount = it.voteCount ?: 0
				)
			} ?: emptyList(),
			totalPages = searchResponse.totalPages ?: 0,
			totalResults = searchResponse.totalResults ?: 0
		)
}