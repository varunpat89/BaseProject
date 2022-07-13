package com.app.baseproject.bottom_menu

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.baseproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.color.MaterialColors
import org.koin.android.ext.android.inject


class BottomMenuScreen : Fragment(R.layout.fragment_bottom_menu_screen) {

    private val bottomMenuConfig by inject<BottomMenuConfiguration>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavigationColor()

        val bottomNavigationView =
            view.findViewById<BottomNavigationView>(R.id.bottomMenuScreen_menuView)

        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.bottomMenuScreen_navHostFragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.bottom_nav)

        bottomMenuConfig.items?.forEachIndexed { index, menuItem ->
            // Get destination graph
            val customGraph = navInflater.inflate(menuItem.startDestination)

            // Add title and icons
            bottomNavigationView.menu.add(Menu.NONE, customGraph.id, Menu.NONE, menuItem.title)
                .setIcon(menuItem.icon)

            // Set start destination from first menu
            if (index == 0) navGraph.setStartDestination(customGraph.id)
//            if (index == 0) navGraph.startDestination = customGraph.id

            // Generate dynamic graph
            navGraph.addDestination(customGraph)
        }

        navController.graph = navGraph
        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onDestroyView() {
        resetNavigationColor()
        super.onDestroyView()
    }

    private fun setNavigationColor() {
        val color = MaterialColors.getColor(requireView(), com.google.android.material.R.attr.colorSurface)
        requireActivity().window.navigationBarColor = color
    }

    private fun resetNavigationColor() {
        val color = MaterialColors.getColor(requireView(), com.google.android.material.R.attr.backgroundColor)
        requireActivity().window.navigationBarColor = color
    }

}