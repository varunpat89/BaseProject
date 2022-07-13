package com.app.baseproject.bottom_menu

import androidx.annotation.DrawableRes
import androidx.annotation.NavigationRes

data class BottomMenuItem(
    @NavigationRes
    val startDestination: Int,
    val title: String,
    @DrawableRes
    val icon: Int = 0
)