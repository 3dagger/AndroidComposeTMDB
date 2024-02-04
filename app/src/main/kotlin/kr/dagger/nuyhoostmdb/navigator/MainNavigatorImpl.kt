package kr.dagger.nuyhoostmdb.navigator

import android.content.Context
import android.content.Intent
import kr.dagger.nuyhoostmdb.MainActivity
import kr.dagger.nuyhoostmdb.core.navigator.MainNavigator
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor() : MainNavigator {
	override fun openMainActivity(context: Context) {
		val intent = Intent(context, MainActivity::class.java)
		context.startActivity(intent)
	}
}