package com.collect.leader

import android.databinding.ViewDataBinding
import android.graphics.Color
import com.ggh.baselibrary.base.activity.BaseDBActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import java.util.*

class MainActivity : BaseDBActivity<ViewDataBinding>(), OnChartValueSelectedListener {

    override fun main() {
        included.pieChart.let {
            it.setUsePercentValues(true)
            it.description.isEnabled = true
            it.setExtraOffsets(35f, 10f, 5f, 5f)

            it.dragDecelerationFrictionCoef = 0.95f

            it.centerText = "Xiao test"

            it.isDrawHoleEnabled = true
            it.setHoleColor(Color.TRANSPARENT)

            it.setTransparentCircleColor(Color.WHITE)
            it.setTransparentCircleAlpha(110)

            it.holeRadius = 58f
            it.transparentCircleRadius = 61f

            it.setDrawCenterText(true)

            it.setRotationAngle(0f)
            // enable rotation of the it by touch
            // enable rotation of the it by touch
            it.isRotationEnabled = false
            it.isHighlightPerTapEnabled = true
            // it.setUnit(" €");
            // it.setDrawUnitsInit(true);
            it.animateY(1400, Easing.EasingOption.EaseInOutQuad)
            it.setOnChartValueSelectedListener(this)
            // entry label styling
            it.setEntryLabelColor(Color.GREEN)
            it.setEntryLabelTextSize(12f)
        }

        val legend = pieChart.legend
        legend?.let {
            it.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            it.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
            it.orientation = Legend.LegendOrientation.VERTICAL
            it.setDrawInside(false)
            it.textColor = Color.GREEN
            it.xEntrySpace = 10f
            it.yEntrySpace = 5f
            it.yOffset = 1f
            it.xOffset = 1f
        }

        setData(4, 1f)
    }

    override fun onNothingSelected() {

    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {

    }

    fun setData(count: Int, range: Float) {
        val entries = ArrayList<PieEntry>()
        for (i in 0 until count) {
            entries.add(PieEntry((Math.random() * range + range / 5).toFloat(),
                    ""/* parties [i % parties.length]*/,
                    resources.getDrawable(R.drawable.star)))
        }

        val dataSet = PieDataSet(entries, "Election Results")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        val colors = ArrayList<Int>()

        for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)

        for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)

        for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)

        colors.add(ColorTemplate.getHoloBlue())

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        included.pieChart.let {
            it.data = data
            it.highlightValues(null)
            it.invalidate()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

}