package nsystem.tools.jakipool.common

import nsystem.tools.jakipool.model.Faskes

sealed class Result {

    class SuccessGetFaskesList(val data: List<Faskes>): Result()

    object Error : Result()
}