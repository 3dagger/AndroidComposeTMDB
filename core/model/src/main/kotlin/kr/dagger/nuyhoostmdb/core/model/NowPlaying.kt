package kr.dagger.nuyhoostmdb.core.model

data class NowPlaying(
	val id: Long,
	val title: String,
	val posterPath: String,
	val overView: String,
)
