package kr.dagger.nuyhoostmdb.core.network.interceptor

import kr.dagger.nuyhoostmdb.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

private const val TMDB_API_KEY = BuildConfig.TMDB_KEY
class HttpRequestInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val tmdbKey = "bearer $TMDB_API_KEY"
		val originalRequest = chain.request()
		val request = originalRequest.newBuilder()
			.addHeader(name = "accept", value = "application/json")
			.addHeader(name = "Authorization", value = tmdbKey)
			.build()
		return chain.proceed(request)
	}
}