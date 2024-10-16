package com.skrebniou.chorey.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.skrebniou.chorey.presentation.composables.CompletedChoresScreen
import com.skrebniou.chorey.presentation.composables.PendingChoresScreen

@Composable
fun NavHostContainer(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "pendingChores",
        enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
        }
    ) {
        composable("pendingChores") {
            PendingChoresScreen()
        }
        composable("completedChores") {
            CompletedChoresScreen()
        }
    }
}
