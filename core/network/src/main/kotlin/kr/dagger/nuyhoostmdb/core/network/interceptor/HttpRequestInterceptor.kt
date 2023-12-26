package kr.dagger.nuyhoostmdb.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
//		val tmdbKey = "bearer ${BuildConfig.TMDB_KEY}"
//		val tmdbKey = "bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTAxNzYyNjc4YTI3YzE5MjcwNjNmNzJjM2QyNWNjYiIsInN1YiI6IjYxZDVhZmQwYzE1Zjg5MDA5ZmZiMGE1YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mkIe-90-oVhnDI3ca3KzOrVHbjqIVstiKeT9p7YgqnA"
		val tmdbKey = "bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2ZDNmYzY1YzQ0MDEyMmI4ZWMyYjc4MGYxMDJhNGIzZCIsInN1YiI6IjYxZDVhZmQwYzE1Zjg5MDA5ZmZiMGE1YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.v9magKc6YIV3jofOZzqHFApxeG6vXtoImaQJN8gax_E"
		val originalRequest = chain.request()
		val request = originalRequest.newBuilder()
			.addHeader(name = "accept", value = "application/json")
			.addHeader(name = "Authorization", value = tmdbKey)
			.build()
		return chain.proceed(request)
	}
}