package com.pablohildo.spacedailydi

import android.view.LayoutInflater

class ActivityRetriever(val defaultCurrentActivityListener: DefaultCurrentActivityListener) {
    val layoutInflater = LayoutInflater.from(defaultCurrentActivityListener.currentActivity)

    val context = defaultCurrentActivityListener.context

    fun getActivity() = defaultCurrentActivityListener.currentActivity
}