package nsystem.tools.jakipool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemTestBinding

class TestListChildAdapter: RecyclerView.Adapter<TestListChildAdapter.TestViewHolder>()  {

    private val testList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TestViewHolder(
        ItemTestBinding.bind(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_test, parent, false)
        )
    )

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(testList[position])
    }

    override fun getItemCount() = testList.size

    fun submitList(data: List<String>) {
        testList.clear()
        testList.addAll(data)
        notifyDataSetChanged()
    }

    class TestViewHolder(
        private val binding: ItemTestBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(value: String) {
            binding.tvTest.text = value
        }
    }
}