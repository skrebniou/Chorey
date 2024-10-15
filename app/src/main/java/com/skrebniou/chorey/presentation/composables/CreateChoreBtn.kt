package com.skrebniou.chorey.presentation.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel

@Composable
fun CreateChoreBtn(viewModel: MainViewModel = hiltViewModel()) {
    FloatingActionButton(
        onClick = { viewModel.onCreateChoreBtnClick() },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(Icons.Default.Add, contentDescription = "New Chore")
    }
}
