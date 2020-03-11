package com.pablohildo.spacedailydi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablohildo.spacedailydi.network.APIInterface
import com.pablohildo.spacedailydi.network.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface MainView {
    fun setDailyPhoto(dailyPhoto: PhotoResponse)
}

class MainViewModel : ViewModel(), KoinComponent {
    val apiInterface: APIInterface by inject()
    var view: MainView? = null

    fun getDailyPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            val dailyPhoto = apiInterface.getDailyPhoto()
            withContext(Dispatchers.Main) {
                view?.setDailyPhoto(dailyPhoto)
            }
        }
    }
}