package com.sons.jawad.apiPresentationLibrary.views

import android.animation.IntEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.hanks.htextview.scale.ScaleTextView
import mohamad.ammar.abu.kalam.apipresentationlibrary.R

class LogoView : RelativeLayout {

    lateinit var successLayout: View
    lateinit var logo: ImageView
    lateinit var scaleTextView: ScaleTextView

    private var mlsx = 0f
    private var mlsy = 0f
    private var mlex = 0f
    private var mley = 0f

    private var cx: Int = 0
    private var cy: Int = 0
    private var cr: Int = 0

    lateinit var paint: Paint

    val DEFAULT_ANIM_TIME = 500
    val DEFAULT_ANIM_STARTF = 0f
    val DEFAULT_ANIM_ENDF = 1f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    internal fun init(context: Context, attrs: AttributeSet) {
        try {
            paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.style = Paint.Style.STROKE
            paint.color = ContextCompat.getColor(context, R.color.secondary_color)
            paint.strokeWidth = 4f
            setWillNotDraw(false)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        initAnimate()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(mlsx, mlsy, mlex, mley, paint)
    }


    private fun initLayers() {
        successLayout = this
        logo = successLayout.findViewById<View>(R.id.logoImage) as ImageView
        scaleTextView = successLayout.findViewById<View>(R.id.scaleTextView) as ScaleTextView
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        initLayers()

    }

    private fun initAnimate() {
        cr = width / 5
        cx = width / 2
        cy = height / 2
        mlsx = cr.toFloat()
        mley = cy.toFloat()
        mlsy = mley
        var ny = logo.y
        ny -= (logo.height / 2).toFloat()
        logo.y = ny
        logo.requestLayout()
        scaleTextView.animateText(resources.getString(R.string.app_name))
        val valueAnimator = ValueAnimator.ofInt(1, 2 * cx - 2 * cr)
        valueAnimator.repeatCount = 0
        valueAnimator.duration = DEFAULT_ANIM_TIME.toLong()
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.setEvaluator(IntEvaluator())
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener { animation ->
            val integer = animation.animatedValue as Int
            mlex = mlsx + integer
            logo.x = mlex - logo.width + 5
            logo.y = mley - logo.height + 2
            scaleTextView.y = (mley - scaleTextView.height + 2)
            postInvalidate()
        }
        valueAnimator.start()
    }


}
