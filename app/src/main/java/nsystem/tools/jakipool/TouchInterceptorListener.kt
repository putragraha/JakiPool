package nsystem.tools.jakipool

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class TouchInterceptorListener(
    private val onInterceptTouchEvent: ((RecyclerView, MotionEvent) -> Boolean)? = null,
    private val onTouchEvent: ((RecyclerView, MotionEvent) -> Unit)? = null,
    private val onRequestDisallowInterceptTouchEvent: ((Boolean) -> Unit)? = null
): RecyclerView.OnItemTouchListener {

    override fun onInterceptTouchEvent(recyclerView: RecyclerView, event: MotionEvent): Boolean {
        return onInterceptTouchEvent
            ?.invoke(recyclerView, event)
            ?: requestDisallowInterceptTouchEvent(recyclerView, event)
    }

    override fun onTouchEvent(recyclerView: RecyclerView, event: MotionEvent) {
        onTouchEvent?.invoke(recyclerView, event)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        onRequestDisallowInterceptTouchEvent?.invoke(disallowIntercept)
    }

    private fun requestDisallowInterceptTouchEvent(recyclerView: RecyclerView, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> recyclerView.parent.requestDisallowInterceptTouchEvent(true)
        }

        return false
    }
}