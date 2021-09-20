package nsystem.tools.jakipool.ui.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.Mock
import nsystem.tools.jakipool.utils.ScrollInterceptorListener
import nsystem.tools.jakipool.databinding.ItemChildListBinding

class PagerSnapChildViewHolder(
    private val binding: ItemChildListBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(onScrollingOut: (Int) -> Unit) {
        val touchInterceptorListener = ScrollInterceptorListener(onScrollingOut)
        binding.rvChild.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PagerSnapChildAdapter().apply {
                submitList(Mock.LOREM_LIST)
            }
            addOnScrollListener(touchInterceptorListener)
            addOnItemTouchListener(touchInterceptorListener)
        }
    }
}