package nsystem.tools.jakipool.model

data class MainState(
    val loading: Boolean,
    val error: Boolean,
    val faskesList: List<Faskes>
)