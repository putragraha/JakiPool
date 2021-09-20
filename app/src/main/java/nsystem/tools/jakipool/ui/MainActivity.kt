package nsystem.tools.jakipool.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import nsystem.tools.jakipool.R
import nsystem.tools.jakipool.databinding.ActivityMainBinding
import nsystem.tools.jakipool.ext.viewModels
import nsystem.tools.jakipool.model.MainState
import nsystem.tools.jakipool.ui.adapter.FaskesListAdapter
import nsystem.tools.jakipool.viewmodel.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var binding: ActivityMainBinding? = null

    private val faskesListAdapter = FaskesListAdapter()

    private val viewModel by lazy {
        viewModels<MainViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        viewModel.getFaskesList()
        setupRecyclerView()
        setupButton()
        observeFaskesList()
    }

    private fun setupRecyclerView() {
        binding?.let {
            it.rvFaskesList.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = faskesListAdapter
            }
        }
    }

    private fun setupButton() {
        binding?.btnPagerSnapCustomView?.setOnClickListener {
            startActivity(Intent(this, PagerSnapActivity::class.java))
        }
    }

    private fun observeFaskesList() {
        viewModel.faskesListLiveData.observe(this, Observer { mainState ->
            render(mainState)
        })
    }

    private fun render(mainState: MainState) {
        binding?.let {
            val faskesList = viewModel.filterExistAvailableDates(mainState.faskesList)
            if (faskesList.isNotEmpty()) {
                faskesListAdapter.submitList(faskesList)
            }
            val warningDrawableResId = when {
                !mainState.error && faskesList.isEmpty() -> R.drawable.ic_empty
                else -> R.drawable.ic_error
            }
            val warningTextResId = when {
                !mainState.error && faskesList.isEmpty() -> R.string.empty_title
                else -> R.string.error_title
            }

            it.tvMainTitle.visibility = if (faskesList.isEmpty()) View.GONE else View.VISIBLE
            it.rvFaskesList.visibility = if (faskesList.isEmpty()) View.GONE else View.VISIBLE
            it.cpiLoading.visibility = if (mainState.loading) View.VISIBLE else View.GONE
            it.acivWarningMessage.visibility = when {
                mainState.error || (!mainState.loading && faskesList.isEmpty()) -> View.VISIBLE
                else -> View.GONE
            }
            it.acivWarningMessage.setBackgroundResource(warningDrawableResId)
            it.tvWarningMessage.visibility = when {
                mainState.error || (!mainState.loading && faskesList.isEmpty()) -> View.VISIBLE
                else -> View.GONE
            }
            it.tvWarningMessage.text = getString(warningTextResId)
        }
    }
}