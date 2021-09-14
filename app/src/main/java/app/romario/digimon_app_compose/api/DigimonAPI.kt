package app.romario.digimon_app_compose.api

import app.romario.digimon_app_compose.response.DigimonList
import retrofit2.http.GET

interface DigimonAPI {

    @GET("digimon")
    suspend fun getDigimonList(): DigimonList
}