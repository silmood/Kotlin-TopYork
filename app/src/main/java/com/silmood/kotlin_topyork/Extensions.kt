package com.silmood.kotlin_topyork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Pedro Hernández on 04/2016.
 */

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this,attachToRoot)
}