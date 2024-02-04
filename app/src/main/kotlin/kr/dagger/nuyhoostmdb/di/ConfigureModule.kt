package kr.dagger.nuyhoostmdb.di

import com.orhanobut.logger.PrettyFormatStrategy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConfigureModule {

	@Provides
	@Singleton
	fun provideLoggerFormatStrategy(): PrettyFormatStrategy {
		return PrettyFormatStrategy.newBuilder()
			.showThreadInfo(true)
			.methodCount(2)
			.methodOffset(5)
			.tag("leeam")
			.build()
	}

}