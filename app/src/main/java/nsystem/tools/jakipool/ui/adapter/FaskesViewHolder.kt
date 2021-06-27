package nsystem.tools.jakipool.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemAvailableDateBinding
import nsystem.tools.jakipool.model.Faskes

class FaskesViewHolder(
    private val binding: ItemAvailableDateBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(faskes: Faskes) {
        binding.tvFaskesName.text = faskes.name
        binding.tvDetailedAddress.text = createDetailedAddress(faskes)
        binding.tvAvailableDates.text = createAvailableDateList(
            faskes.availableDates ?: return
        )
    }

    private fun createDetailedAddress(faskes: Faskes): String {
        return "${faskes.address}, " +
                "Kel. ${faskes.village}, " +
                "Kec. ${faskes.subDistrict}, ${faskes.districts}"
    }

    private fun createAvailableDateList(availableDates: List<String>): String {
        return availableDates.joinToString(separator = "\n")
    }
}