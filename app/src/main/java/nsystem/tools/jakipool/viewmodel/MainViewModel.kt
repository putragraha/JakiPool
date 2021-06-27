package nsystem.tools.jakipool.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nsystem.tools.jakipool.common.Result
import nsystem.tools.jakipool.model.Faskes
import nsystem.tools.jakipool.model.MainState
import nsystem.tools.jakipool.repository.JakiRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val jakiRepository: JakiRepository): ViewModel() {

    val faskesListLiveData = MutableLiveData<MainState>()

    fun getFaskesList() {
        val initialState = MainState(loading = true, error = false, faskesList = emptyList())
        faskesListLiveData.postValue(initialState)

        viewModelScope.launch {
            val state = when (val result = jakiRepository.getFaskesList()) {
                is Result.SuccessGetFaskesList -> {
                    MainState(
                        loading = false,
                        error = false,
                        faskesList = result.data
                    )
                }
                else -> MainState(
                    loading = false,
                    error = true,
                    faskesList = emptyList()
                )
            }
            faskesListLiveData.postValue(state)
        }
    }

    fun filterExistAvailableDates(faskesList: List<Faskes>) = faskesList.filter { faskes ->
        faskes.availableDates?.isNotEmpty() ?: false
    }
}