package kr.dagger.nuyhoostmdb

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class NuyhoosTMDB : Application() {

	@Inject
	lateinit var formatStrategy: PrettyFormatStrategy

	override fun onCreate() {
		super.onCreate()
		initLogger()
	}

	private fun initLogger() {
		Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
			override fun isLoggable(priority: Int, tag: String?): Boolean {
				return BuildConfig.DEBUG
			}
		})
	}
}