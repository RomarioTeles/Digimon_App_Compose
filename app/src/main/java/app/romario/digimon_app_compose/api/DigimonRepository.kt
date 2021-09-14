package app.romario.digimon_app_compose.api

import android.util.Log
import app.romario.digimon_app_compose.response.DigimonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DigimonRepository @Inject constructor(private val api: DigimonAPI){


    suspend fun getDigimonList(): DigimonList{
        try {
            return api.getDigimonList()
        }catch (e : Exception){
            Log.d("Error", e.message.toString())
        }
        return DigimonList()
    }


}