package kr.dagger.nuyhoostmdb.core.network.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.nuyhoostmdb.core.network.interceptor.HttpRequestInterceptor
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideHttpRequestInterceptor(): HttpRequestInterceptor {
		return HttpRequestInterceptor()
	}

	@Provides
	@Singleton
	fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
		return HttpLoggingInterceptor()
			.setLevel(HttpLoggingInterceptor.Level.BODY)
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(
		httpRequestInterceptor: HttpRequestInterceptor,
		httpLoggingInterceptor: HttpLoggingInterceptor,
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(httpRequestInterceptor)
			.addInterceptor(httpLoggingInterceptor)
			.build()
	}

	@Provides
	@Singleton
	fun provideConverterFactory(): GsonConverterFactory {
		return GsonConverterFactory.create(GsonBuilder().create())
	}

	@Provides
	@Singleton
	fun provideRetrofit(
		converterFactory: GsonConverterFactory,
		okHttpClient: OkHttpClient
	): Retrofit {
		return Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/")
			.addConverterFactory(converterFactory)
			.client(okHttpClient)
			.build()
	}

	@Provides
	@Singleton
	fun provideMovieService(retrofit: Retrofit): MovieService {
		return retrofit.create(MovieService::class.java)
	}
}