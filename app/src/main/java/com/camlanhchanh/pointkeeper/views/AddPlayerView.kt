package com.camlanhchanh.pointkeeper.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.camlanhchanh.pointkeeper.R

class AddPlayerView : LinearLayout {

    lateinit var mView: LinearLayout

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    public interface OnRowRemovedListener {
        fun onRemove()
    }

    private fun init() {
        mView = inflate(context, R.layout.layout_add_player_view, this) as LinearLayout
    }
}