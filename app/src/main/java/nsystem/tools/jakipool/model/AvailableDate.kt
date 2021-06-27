package nsystem.tools.jakipool.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AvailableDate(
    @Json(name = "id") val date: String? = "",
    @Json(name = "label") val dateAndDay: String? = ""
)