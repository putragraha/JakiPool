package nsystem.tools.jakipool.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemTestBinding

class PagerSnapViewHolder(
    private val binding: ItemTestBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(value: String) {
        binding.tvTest.text = value
    }
}