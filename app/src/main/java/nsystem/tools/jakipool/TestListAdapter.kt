package nsystem.tools.jakipool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemChildListBinding
import nsystem.tools.jakipool.databinding.ItemTestBinding

class TestListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val testList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == R.layout.item_test) {
            TestViewHolder(
                ItemTestBinding.bind(
                    layoutInflater.inflate(R.layout.item_test, parent, false)
                )
            )
        } else {
            TestChildListViewHolder(
                ItemChildListBinding.bind(
                    layoutInflater.inflate(R.layout.item_child_list, parent, false)
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TestViewHolder -> holder.bind(testList[position])
            is TestChildListViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = testList.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 2) R.layout.item_child_list else R.layout.item_test
    }

    fun submitList(data: List<String>) {
        testList.clear()
        testList.addAll(data)
        notifyDataSetChanged()
    }
}
