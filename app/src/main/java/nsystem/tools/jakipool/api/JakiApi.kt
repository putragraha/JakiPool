package nsystem.tools.jakipool.api

import nsystem.tools.jakipool.model.AvailableDate
import nsystem.tools.jakipool.model.Faskes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JakiApi {

    @GET("faskes")
    suspend fun getAllFaskes(): Response<List<Faskes>>

    @GET("faskes/tanggal")
    suspend fun getAvailableDates(
        @Query("kode_lokasi_vaksinasi") code: Int,
        @Query("from_capil") fromCapil: Boolean
    ): Response<List<AvailableDate>>
}