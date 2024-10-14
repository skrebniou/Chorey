package com.skrebniou.chorey.presentation.composables.chorecard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skrebniou.chorey.presentation.theme.ChoreyTheme
import com.skrebniou.chorey.presentation.util.formatDuration
import com.skrebniou.chorey.presentation.viewmodels.MainViewModel
import data.models.Chore
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun ChoreCard(chore: Chore, viewModel: MainViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            CardTitle(chore.id, chore.label)
            Spacer(modifier = Modifier.height(8.dp))
            CardDeadlineTime(
                chore.id,
                chore.deadlineTime.format(DateTimeFormatter.ofPattern("dd MMMM, HH:mm"))
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardReminder(chore.id, formatDuration(chore.reminderTime))
            Spacer(modifier = Modifier.height(8.dp))
            CardDescription(chore.id, chore.description)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                CardCompletionSwitch(chore.id, chore.isCompleted)
                Spacer(modifier = Modifier.width(8.dp))
                CardDeleteButton(chore.id)
            }
        }
    }
}


@Preview
@Composable
fun FunnyComposable() {
    ChoreyTheme {
        ChoreCard(
            Chore(
                1,
                "Take the trash out",
                LocalDateTime.now(),
                Duration.ofHours(5),
                description = "Seriously. Take that trash out.",
                isCompleted = false
            )
        )
    }
}