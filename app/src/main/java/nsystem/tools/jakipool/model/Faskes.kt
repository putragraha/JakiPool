package nsystem.tools.jakipool.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Faskes(
    @Json(name = "kode_lokasi_vaksinasi") val code: Int? = -1,
    @Json(name = "nama_lokasi_vaksinasi") val name: String? = "",
    @Json(name = "alamat_lokasi_vaksinasi") val address: String? = "",
    @Json(name = "wilayah") val districts: String? = "",
    @Json(name = "kecamatan") val subDistrict: String? = "",
    @Json(name = "kelurahan") val village: String? = "",
    @Json(name = "rt") val rt: String? = "",
    @Json(name = "rw") val rw: String? = "",
    @Json(name = "kodepos") val postCode: String? = "",
    @Json(name = "jenis_faskes") val faskesType: String? = "",
    @Json(name = "email") val email: String? = "",
    @Json(name = "no_wa_pic") val picNumber: String? = "",
    @Json(name = "jumlah_tim_vaksinator") val vaccinatorTeamAmount: Int? = -1,
    @Json(name = "nama_faskes") val faskesName: String? = "",
    @Json(name = "created_at") val createdDate: String? = "",
    @Json(name = "updated_at") val updatedDate: String? = "",
    var availableDates: List<String>? = emptyList()
)