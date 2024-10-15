package com.skrebniou.chorey.presentation.composables.chorecard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel

@Composable
fun CardTitle(choreId: Int, label: String, viewModel: MainViewModel = hiltViewModel()) {
    Row(
        Modifier.clickable { viewModel.onCardTitleClick(choreId) }
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}