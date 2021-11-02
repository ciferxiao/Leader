package com.ggh.baselibrary.base.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.collect.leader.base.BaseView
import com.collect.leader.utils.ViewManager

/**
 *  * description : 
 *  * Author : Xiao
 *  * Date : 2021-07-13
 *  
 **/
abstract class AbsActivity(val layoutId: Int) : AppCompatActivity(),
        BaseView {
    protected var TAG = this.javaClass.simpleName
    protected lateinit var mActivity: Activity
    protected lateinit var mContext: Context
    protected var loadDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        mActivity = this
        mContext = this
        //输入框位于软键盘上方
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //强制竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //设置状态栏透明
        /*StatusBarUtils.setStatusBarTransparent(mActivity)
        //设置状态栏字体颜色
        StatusBarUtils.setStateBarTextColor(mActivity, true)
        //将Activity添加到栈中
        ViewManager.getInstance().addActivity(this)
        loadDialog = DialogUtil.loadingDialog(mContext!!,"加载中")*/

        ViewManager.getInstance().addActivity(this)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            //当键盘弹出是，点击键盘之外的区域隐藏键盘
            val view = currentFocus
            hideKeyboard(ev, view, this)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (loadDialog != null) {
            loadDialog!!.dismiss()
        }
        ViewManager.getInstance().finishActivity(this)
    }

/*
    override fun showLoading(){
        if (loadDialog!=null){
            loadDialog!!.show()
        }
    }

    override fun dissLoading(){
        if (loadDialog!=null && loadDialog!!.isShowing){
            loadDialog!!.hide()
        }
    }
*/

    fun hideKeyboard(event: MotionEvent, view: View?, activity: Activity) {
        try {
            if (view != null && view is EditText) {
                val location = intArrayOf(0, 0)
                view.getLocationInWindow(location)
                val left = location[0]
                val top = location[1]
                val right = (left
                        + view.getWidth())
                val bootom = top + view.getHeight()
                // 判断焦点位置坐标是否在空间内，如果位置在控件外，则隐藏键盘
                if (event.rawX < left || event.rawX > right || event.y < top || event.rawY > bootom
                ) {
                    // 隐藏键盘
                    val token = view.getWindowToken()
                    val inputMethodManager: InputMethodManager = activity
                            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(
                            token,
                            InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}