package nsystem.tools.jakipool.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import nsystem.tools.jakipool.R
import nsystem.tools.jakipool.databinding.ItemAvailableDateBinding
import nsystem.tools.jakipool.model.Faskes

class FaskesListAdapter: ListAdapter<Faskes, FaskesViewHolder>(FASKES_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaskesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_available_date, parent, false)
        val binding = ItemAvailableDateBinding.bind(view)
        return FaskesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FaskesViewHolder, position: Int) {
        val faskes = getItem(position)
        holder.bind(faskes ?: return)
    }

    companion object {
        private val FASKES_COMPARATOR = object : DiffUtil.ItemCallback<Faskes>() {
            override fun areItemsTheSame(oldItem: Faskes, newItem: Faskes): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(oldItem: Faskes, newItem: Faskes): Boolean {
                return oldItem == newItem
            }
        }
    }
}