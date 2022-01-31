package com.aredruss.jet_shop.domain

import android.content.Context
import android.content.SharedPreferences

class ShopPreferences(
    appContext: Context,
) {
    private val TAG = "JetShopPrefs"

    private val prefs: SharedPreferences =
        appContext.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    companion object {
        private const val prefsName = "JetShopPrefs"
        private const val userNameKey = "userName"
        private const val onBoardingShownKey = "onBoardingShown"
    }

    var userName: String?
        set(value) = prefs.edit().putString(userNameKey, value).apply()
        get() = prefs.getString(userNameKey, null)

    var onBoardingShown: Boolean
        set(value) = prefs.edit().putBoolean(onBoardingShownKey, value).apply()
        get() = prefs.getBoolean(onBoardingShownKey, false)
}