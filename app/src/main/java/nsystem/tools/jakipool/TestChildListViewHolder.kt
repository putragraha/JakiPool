package nsystem.tools.jakipool

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemChildListBinding

class TestChildListViewHolder(
    private val binding: ItemChildListBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.rvChild.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TestListChildAdapter().apply {
                submitList(Mock.LOREM_LIST)
            }
            addOnItemTouchListener(TouchInterceptorListener())
        }
    }
}