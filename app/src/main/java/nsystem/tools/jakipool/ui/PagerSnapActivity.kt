package nsystem.tools.jakipool.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import nsystem.tools.jakipool.Mock
import nsystem.tools.jakipool.ui.adapter.PagerSnapAdapter
import nsystem.tools.jakipool.databinding.ActivityTestBinding

class PagerSnapActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityTestBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        PagerSnapHelper().run {
            attachToRecyclerView(
                binding.rvOne.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PagerSnapAdapter {
                        when (it) {
                            -1 -> binding.rvOne.smoothScrollToPosition(0)
                            1 -> binding.rvOne.smoothScrollToPosition(2)
                        }
                    }.also { it.submitList(Mock.LOREM_LIST) }
                }
            )
        }
    }
}