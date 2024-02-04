package kr.dagger.nuyhoostmdb.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.nuyhoostmdb.core.navigator.MainNavigator
import kr.dagger.nuyhoostmdb.navigator.MainNavigatorImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigatorModule {

	@Binds
	abstract fun provideMainNavigator(
		navigator: MainNavigatorImpl
	): MainNavigator

}