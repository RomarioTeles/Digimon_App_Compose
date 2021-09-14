package app.romario.digimon_app_compose.utils

import android.app.Application
import app.romario.digimon_app_compose.api.DigimonAPI
import app.romario.digimon_app_compose.api.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class DigimonHilt : Application() {

}

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun providerDigimonRepository(api: DigimonAPI) = DigimonRepository(api)

    @Singleton
    @Provides
    fun digimonApi() : DigimonAPI{
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://digimon-api.vercel.app/api/")
            .build().create(DigimonAPI::class.java)
    }

}