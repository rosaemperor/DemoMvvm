package com.demomvvm.utils

import android.content.Context
import java.lang.ref.WeakReference

class StringUtils {
    private var weakContext : WeakReference<Context> ?= null
     fun   getContext(context : Context) : Context?{
        weakContext = WeakReference<Context>(context)
        weakContext?.let {
           return weakContext!!.get()
        }
         return null
    }

}