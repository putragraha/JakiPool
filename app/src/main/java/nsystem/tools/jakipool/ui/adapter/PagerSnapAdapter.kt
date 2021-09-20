package nsystem.tools.jakipool.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.R
import nsystem.tools.jakipool.databinding.ItemChildListBinding
import nsystem.tools.jakipool.databinding.ItemTestBinding

class PagerSnapAdapter(
    private val onScrollingOut: (Int) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val testList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == R.layout.item_test) {
            PagerSnapViewHolder(
                ItemTestBinding.bind(
                    layoutInflater.inflate(R.layout.item_test, parent, false)
                )
            )
        } else {
            PagerSnapChildViewHolder(
                ItemChildListBinding.bind(
                    layoutInflater.inflate(R.layout.item_child_list, parent, false)
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PagerSnapViewHolder -> holder.bind(testList[position])
            is PagerSnapChildViewHolder -> holder.bind(onScrollingOut)
        }
    }

    override fun getItemCount() = testList.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 1) R.layout.item_child_list else R.layout.item_test
    }

    fun submitList(data: List<String>) {
        testList.clear()
        testList.addAll(data)
        notifyDataSetChanged()
    }
}
