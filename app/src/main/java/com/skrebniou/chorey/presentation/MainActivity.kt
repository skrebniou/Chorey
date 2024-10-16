package com.skrebniou.chorey.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.skrebniou.chorey.presentation.composables.CreateChoreBtn
import com.skrebniou.chorey.presentation.navigation.BottomNavigationBar
import com.skrebniou.chorey.presentation.navigation.NavHostContainer
import com.skrebniou.chorey.presentation.theme.ChoreyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChoreyTheme {
                window.navigationBarColor = MaterialTheme.colorScheme.primary.toArgb()
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) },
                    content = { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            NavHostContainer(navController = navController)
                        }
                    },
                    floatingActionButton = {
                        CreateChoreBtn()
                    }
                )
            }
        }
    }
}