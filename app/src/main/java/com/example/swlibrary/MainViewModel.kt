package com.example.swlibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swlibrary.data.repository.GetStarWarsApiRepository
import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.StarshipModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    var repo = GetStarWarsApiRepository()
    val characterList: MutableLiveData<Response<CharacterModel>> = MutableLiveData()
    val planetList: MutableLiveData<Response<PlanetModel>> = MutableLiveData()
    val starshipList: MutableLiveData<Response<StarshipModel>> = MutableLiveData()

    fun getCharacterList(){
        viewModelScope.launch {
            characterList.value = repo.getCharacter()
        }
    }

    fun getPlanetList(){
        viewModelScope.launch {
            planetList.value = repo.getPlanet()
        }
    }

    fun getStarshipList(){
        viewModelScope.launch {
            starshipList.value = repo.getStarship()
        }
    }

}