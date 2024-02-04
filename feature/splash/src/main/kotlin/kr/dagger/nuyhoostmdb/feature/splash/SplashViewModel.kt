package kr.dagger.nuyhoostmdb.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel()  {
	private val _initLoading = MutableStateFlow(false)
	val observe: StateFlow<Boolean> get() = _initLoading

	init {
		viewModelScope.launch {
			delay(2_000)
			_initLoading.value = true
		}
	}
}