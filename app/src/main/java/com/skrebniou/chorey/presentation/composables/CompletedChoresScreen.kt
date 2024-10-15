package com.skrebniou.chorey.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.composables.chorecard.ChoreCard
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel

@Composable
fun CompletedChoresScreen(viewModel: MainViewModel = hiltViewModel()) {
    val pendingChores by viewModel.completedChores.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Completed chores",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (!pendingChores.isNullOrEmpty()) {
            LazyColumn {
                items(pendingChores!!) {
                    ChoreCard(it)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } else {
            EmptyIndicator(label = "No completed chores. Feeling lazy?")
        }
    }
}
