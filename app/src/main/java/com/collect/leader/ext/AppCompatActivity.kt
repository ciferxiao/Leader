package com.collect.leader.ext

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup

fun <T : ViewDataBinding> AppCompatActivity.binding(@LayoutRes resId: Int): T =
        DataBindingUtil.setContentView<T>(this, resId).apply {
            setLifecycleOwner(this@binding)
        }

fun <T : ViewDataBinding> AppCompatActivity.bindingInflate(inflater: LayoutInflater = layoutInflater, @LayoutRes resId: Int, viewGroup: ViewGroup? = null): T =
        DataBindingUtil.inflate<T>(inflater, resId, viewGroup, false).apply {
            setLifecycleOwner(this@bindingInflate)
        }

fun <T> AppCompatActivity.start(clazz: Class<T>) {
    startActivity(Intent(this, clazz))
}
