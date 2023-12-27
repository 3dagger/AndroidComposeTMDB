package kr.dagger.nuyhoostmdb.core.network.service

import kr.dagger.nuyhoostmdb.core.network.model.DetailResponse
import kr.dagger.nuyhoostmdb.core.network.model.NowPlayingItemResponse
import kr.dagger.nuyhoostmdb.core.network.model.NowPlayingResponse
import kr.dagger.nuyhoostmdb.core.network.model.PopularResponse
import kr.dagger.nuyhoostmdb.core.network.model.UpComingItemResponse
import kr.dagger.nuyhoostmdb.core.network.model.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

	@GET("/3/movie/now_playing")
	suspend fun getNowPlaying(
		@Query("page") page: Int = 1,
		@Query("language") language: String = "ko-KR",
		@Query("region") region: String = "KR",
	): NowPlayingResponse

	@GET("/3/movie/upcoming")
	suspend fun getUpComing(
		@Query("page") page: Int = 1,
		@Query("language") language: String = "ko-KR",
		@Query("region") region: String = "KR",
	): UpComingResponse

	@GET("/3/movie/popular")
	suspend fun getPopular(
		@Query("page") page: Int,
		@Query("language") language: String = "ko-KR",
		@Query("region") region: String = "KR",
	): PopularResponse

	@GET("/3/movie/{id}")
	suspend fun getDetail(
		@Path(value = "id") id: Int,
		@Query("language") language: String = "ko-KR",
		@Query("region") region: String = "KR",
	): DetailResponse
}