package com.skrebniou.chorey.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.skrebniou.chorey.presentation.screens.CompletedChoresScreen
import com.skrebniou.chorey.presentation.screens.PendingChoresScreen

@Composable
fun NavHostContainer(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "pendingChores",
        builder = {
            composable("pendingChores") {
                PendingChoresScreen()
            }
            composable("completedChores") {
                CompletedChoresScreen()
            }
        })
}
