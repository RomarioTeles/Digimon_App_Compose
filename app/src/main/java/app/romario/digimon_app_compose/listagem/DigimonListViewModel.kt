package app.romario.digimon_app_compose.listagem

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.romario.digimon_app_compose.api.DigimonRepository
import app.romario.digimon_app_compose.response.DigimonList
import app.romario.digimon_app_compose.response.DigimonListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigimonListViewModel @Inject constructor(private val repository: DigimonRepository): ViewModel(){

    var digimonList = mutableStateOf<List<DigimonListItem>>(listOf())

    init {
        loadDigimons()
    }

    fun loadDigimons(){
        viewModelScope.launch {
            digimonList.value = repository.getDigimonList()
        }
    }

}