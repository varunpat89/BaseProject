package com.app.baseproject.bottom_menu

data class BottomMenuConfiguration(
    var items: List<BottomMenuItem>? = null
)

fun bottomMenuConfiguration(lambda: BottomMenuConfiguration.() -> Unit) =
    BottomMenuConfiguration().apply(lambda)

