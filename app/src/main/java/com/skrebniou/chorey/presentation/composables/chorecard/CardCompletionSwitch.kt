package com.skrebniou.chorey.presentation.composables.chorecard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel

@Composable
fun CardCompletionSwitch(
    choreId: Int,
    isChoreCompleted: Boolean,
    viewModel: MainViewModel = hiltViewModel()
) {
    Icon(
        imageVector = when (isChoreCompleted) {
            false -> Icons.Default.Check
            true -> Icons.Default.CheckCircle
        },
        contentDescription = "Completion Switch",
        modifier = Modifier
            .size(50.dp)
            .clickable(onClick = {
                viewModel.onCardCompletionSwitchClick(
                    choreId,
                    isChoreCompleted
                )
            })
            .padding(8.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}
