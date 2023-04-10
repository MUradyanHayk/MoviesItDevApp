package com.example.moviesitdevapp.utils

import android.app.Activity
import android.content.Context

object SaveSharedManager {
    fun setFavorite(activity: Activity?, key: String, value: Boolean) {
        val sharedFavorite = activity?.getPreferences(Context.MODE_PRIVATE)
        sharedFavorite?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getFavorite(activity: Activity?, key: String): Boolean {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return false
        return sharedPref.getBoolean(key, false)
    }
}