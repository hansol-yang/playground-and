package com.engflip.www.playgroundand.extension

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false) = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)