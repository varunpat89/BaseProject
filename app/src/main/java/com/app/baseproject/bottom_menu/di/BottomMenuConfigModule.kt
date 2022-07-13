package com.app.baseproject.bottom_menu

import android.content.Context
import com.app.baseproject.R
import org.koin.dsl.module

internal val bottomMenuConfigModule = module {
    single {
        bottomMenuConfiguration {
            val context = get<Context>()
            items = listOf(
                BottomMenuItem(
                    title = context.getString(R.string.contacts),
                    icon = android.R.drawable.sym_contact_card,
                    startDestination = R.navigation.contacts_nav
                ),
                BottomMenuItem(
                    title = context.getString(R.string.calls),
                    icon = android.R.drawable.stat_sys_vp_phone_call,
                    startDestination = R.navigation.calls_nav
                ),
                BottomMenuItem(
                    title = context.getString(R.string.chat),
                    icon = android.R.drawable.sym_action_chat,
                    startDestination = R.navigation.chat_nav
                ),
                BottomMenuItem(
                    title = context.getString(R.string.wallet),
                    icon = android.R.drawable.btn_star,
                    startDestination = R.navigation.wallet_nav
                ),
            )
        }
    }
}