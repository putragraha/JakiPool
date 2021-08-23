package nsystem.tools.jakipool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import nsystem.tools.jakipool.databinding.ActivityTestBinding

class TestActivity: AppCompatActivity() {

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
                    adapter = TestListAdapter().also {
                        it.submitList(Mock.LOREM_LIST)
                    }
                }
            )
        }
    }
}