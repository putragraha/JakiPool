package nsystem.tools.jakipool

import androidx.recyclerview.widget.RecyclerView
import nsystem.tools.jakipool.databinding.ItemChildListBinding

class TestChildListViewHolder(
    private val binding: ItemChildListBinding
): RecyclerView.ViewHolder(binding.root) {

    private val mockString by lazy {
        listOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum. Ut lacus ipsum, maximus ut tortor non, imperdiet sollicitudin massa. Donec faucibus euismod congue.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum. Ut lacus ipsum, maximus ut tortor non, imperdiet sollicitudin massa. Donec faucibus euismod congue.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum. Ut lacus ipsum, maximus ut tortor non, imperdiet sollicitudin massa. Donec faucibus euismod congue.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet dolor pharetra, pulvinar diam ac, tempor velit. In mauris lacus, maximus et commodo at, iaculis finibus mi. Maecenas aliquet hendrerit arcu, eu porta nisl sollicitudin et. Vestibulum malesuada libero velit, at cursus ligula aliquam eu. Integer vulputate fermentum placerat. Phasellus facilisis porta augue, et consectetur lorem porttitor eget. Proin tempor augue quis risus iaculis cursus. Nam nunc ligula, euismod ut hendrerit eget, pharetra a justo. Cras vulputate dignissim purus eget dapibus. Vestibulum euismod quis ante eu condimentum. Ut lacus ipsum, maximus ut tortor non, imperdiet sollicitudin massa. Donec faucibus euismod congue."
        )
    }

    fun bind() {
        binding.rvChild.apply {
            adapter = TestListChildAdapter().apply {
                submitList(mockString)
            }
            addOnItemTouchListener(TouchInterceptorListener())
        }
    }
}