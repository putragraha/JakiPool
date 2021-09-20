package nsystem.tools.jakipool.utils

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class ScrollInterceptorListener(
    private val onOverScroll: (Int) -> Unit,
    private val onInterceptTouchEvent: ((RecyclerView, MotionEvent) -> Boolean)? = null,
    private val onTouchEvent: ((RecyclerView, MotionEvent) -> Unit)? = null,
    private val onRequestDisallowInterceptTouchEvent: ((Boolean) -> Unit)? = null
) : RecyclerView.OnScrollListener(),
    RecyclerView.OnItemTouchListener {

    private var startDragPosition: Float = 0F

    override fun onInterceptTouchEvent(recyclerView: RecyclerView, event: MotionEvent): Boolean {
        return onInterceptTouchEvent?.invoke(recyclerView, event)
            ?: requestDisallowInterceptTouchEvent(recyclerView, event)
    }

    override fun onTouchEvent(recyclerView: RecyclerView, event: MotionEvent) {
        onTouchEvent?.invoke(recyclerView, event)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        onRequestDisallowInterceptTouchEvent?.invoke(disallowIntercept)
    }

    private fun requestDisallowInterceptTouchEvent(
        recyclerView: RecyclerView,
        event: MotionEvent
    ): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startDragPosition = event.rawY
                recyclerView.parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_UP -> {
                val endDragPosition = event.rawY
                recyclerView.parent.requestDisallowInterceptTouchEvent(false)
                recyclerView.onOverScrollVertically(startDragPosition, endDragPosition)
                when {
                    !recyclerView.canScrollVertically(-1) -> onOverScroll(-1)
                    !recyclerView.canScrollVertically(1) -> onOverScroll(1)
                }
            }
        }

        return false
    }

    private fun RecyclerView.onOverScrollVertically(
        startDragPosition: Float,
        endDragPosition: Float
    ) {
        when {
            !canScrollVertically(-1) && startDragPosition < endDragPosition -> {
                onOverScroll(-1)
            }
            !canScrollVertically(1) && startDragPosition > endDragPosition -> {
                onOverScroll(1)
            }
        }
    }
}