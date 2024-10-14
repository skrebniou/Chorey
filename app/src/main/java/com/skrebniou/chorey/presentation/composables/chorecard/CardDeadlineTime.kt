package com.skrebniou.chorey.presentation.composables.chorecard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel

@Composable
fun CardDeadlineTime(
    choreId: Int,
    deadlineTime: String,
    viewModel: MainViewModel = hiltViewModel()
) {
    Row(
        Modifier.clickable { viewModel.onCardDeadlineTimeClick(choreId) }
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Time and date",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = deadlineTime,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}