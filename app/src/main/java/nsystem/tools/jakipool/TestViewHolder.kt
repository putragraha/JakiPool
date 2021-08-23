package nsystem.tools.jakipool

import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemTestBinding

class TestViewHolder(
    private val binding: ItemTestBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(value: String) {
        binding.tvTest.text = value
    }
}