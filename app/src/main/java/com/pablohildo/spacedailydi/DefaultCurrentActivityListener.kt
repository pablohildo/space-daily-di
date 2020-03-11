package com.pablohildo.spacedailydi

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle

interface CurrentActivityListener {
    var currentActivity: Activity?
}

class DefaultCurrentActivityListener : Application.ActivityLifecycleCallbacks, CurrentActivityListener {
    override var currentActivity: Activity? = null
    lateinit var context: Context
    protected var currentActivityStack: MutableList<Activity> = ArrayList()

    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityDestroyed(activity: Activity) {
        if (activity == currentActivity) currentActivity = null
        currentActivityStack.remove(activity)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        currentActivity = activity
        context = activity
        currentActivityStack.add(activity)
    }

    fun isActivityRunning(activityClass: Class<out Activity>): Boolean {
        for (activity in currentActivityStack) {
            if (activity.javaClass == activityClass) return true
        }
        return false
    }
}