package nsystem.tools.jakipool.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nsystem.tools.jakipool.api.JakiApi
import nsystem.tools.jakipool.common.Result
import javax.inject.Inject

class JakiRepository @Inject constructor(private val jakiApi: JakiApi) {

    suspend fun getFaskesList(): Flow<Result> = flow {
        try {
            val faskesResponse = jakiApi.getAllFaskes()
            val result = when (faskesResponse.isSuccessful) {
                true -> {
                    val faskesList = faskesResponse.body()?.map { faskes ->
                        faskes.apply {
                            availableDates = getAvailableDates(faskes.code ?: return@apply)
                        }
                    } ?: emptyList()
                    Result.SuccessGetFaskesList(faskesList)
                }
                false -> Result.Error
            }

            emit(result)
        } catch (exception: Exception) {
            emit(Result.Error)
        }
    }

    private suspend fun getAvailableDates(code: Int): List<String>? {
        val availableDateResponse = jakiApi.getAvailableDates(code, false)
        return when (availableDateResponse.isSuccessful) {
            true -> availableDateResponse.body()?.mapNotNull {
                it.dateAndDay
            }
            false -> emptyList()
        }
    }
}