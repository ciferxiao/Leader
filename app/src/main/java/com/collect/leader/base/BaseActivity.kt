package com.mcl.kotlin_mvvm.base

import android.os.Bundle
import android.view.View
import com.collect.leader.R
import com.collect.leader.widget.TitleBar
import com.ggh.baselibrary.base.activity.AbsActivity
import kotlinx.android.synthetic.main.base_title_layout.*
import kotlinx.android.synthetic.main.layout_title_bar.*

abstract class BaseActivity() : AbsActivity(R.layout.base_title_layout) {

    lateinit var mTitleBar: TitleBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(getLayout(), null)
        frame_content.addView(view)
        main()
        initTitle()
    }

    protected abstract fun getLayout(): Int
    /**
     * 初始化标题内容
     */
    private fun initTitle() {
        mTitleBar = title_bar
        title_bar.apply {

            visibility = if (setTitleText().trim().isNotEmpty()) View.VISIBLE else View.GONE

            if (visibility == View.GONE) else {
                //设置公共属性
                title_bar.setBackgroundColor(resources.getColor(R.color.white))
                //左侧控件
                title_bar_left_img.apply {
                    title_bar_left_img.setImageResource(R.drawable.icon_title_back_white)
                    setOnClickListener { onBackPressed() }
                }
                //标题
                title_bar_center.apply {
                    title_bar_center.setTextColor(resources.getColor(R.color.black))
                    text = setTitleText()
                }
            }
        }
    }

    abstract fun main()

    /**
     * 默认不显示标题
     */
    open fun setTitleText(): String = " "

    override fun onBackPressed() {
        super.onBackPressed()
        // Fragment 逐个出栈
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}