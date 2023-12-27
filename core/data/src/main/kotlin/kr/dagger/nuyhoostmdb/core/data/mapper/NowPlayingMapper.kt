package kr.dagger.nuyhoostmdb.core.data.mapper

import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.network.model.NowPlayingItemResponse

object NowPlayingMapper {

	fun mapFromNowPlayingResponseToModel(nowPlayingItemResponse: NowPlayingItemResponse) =
		NowPlaying(
			id = nowPlayingItemResponse.id ?: 0,
			title = nowPlayingItemResponse.title ?: "",
			posterPath = nowPlayingItemResponse.posterPath ?: "",
			overView = nowPlayingItemResponse.overView ?: "",
		)
}