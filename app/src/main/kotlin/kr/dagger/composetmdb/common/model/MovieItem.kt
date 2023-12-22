package kr.dagger.composetmdb.common.model

import android.os.Parcelable

interface MovieItem : Parcelable {
	val id: Int
	val overView: String
	val releaseDate: String?
	val posterUrl: String?
	val backdropUrl: String?
	val name: String
	val voteAverage: Double
	val voteCount: Int
}