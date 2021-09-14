package app.romario.digimon_app_compose.response


import com.google.gson.annotations.SerializedName

data class DigimonListItem(
    @SerializedName("img")
    val img: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("name")
    val name: String
)