package com.app.baseproject.utils.preferance

import android.content.SharedPreferences

class PreferenceManager constructor(var sharedPreferences: SharedPreferences) {

    companion object {
        const val IS_DISPLAY_ONBOARDING = "pre.key.isDisplayOnboarding"
    }

    fun isDisplayOnBoarding(): Boolean {
        return sharedPreferences.getBoolean(IS_DISPLAY_ONBOARDING, false)
    }

    fun saveIsDisplayOnboarding(isSave: Boolean) {
        sharedPreferences.edit().putBoolean(IS_DISPLAY_ONBOARDING, isSave).apply()
    }

    fun clearPref() {
        sharedPreferences.edit().clear().apply()
    }
}