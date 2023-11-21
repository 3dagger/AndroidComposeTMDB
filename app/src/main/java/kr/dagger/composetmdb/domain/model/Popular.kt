package kr.dagger.composetmdb.domain.model

data class Popular(
	val id: Long,
	val title: String,
	val posterPath: String,
	val overView: String,
	var isFavorite: Boolean = false
)
//data class Popular(
//	val id: Long? = null,
//	val title: String? = null,
//	val posterPath: String? = null,
//	val overView: String? = null,
//	var isFavorite: Boolean = false
//)
