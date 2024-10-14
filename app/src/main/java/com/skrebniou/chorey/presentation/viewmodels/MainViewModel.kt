package com.skrebniou.chorey.presentation.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import data.repositories.ChoreRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ChoreRepository
) : ViewModel() {
    fun onCardTitleClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardDeadlineTimeClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardReminderClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardDescriptionClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardCompletionSwitchClick(choreId: Int, isChoreCompleted: Boolean) {
        // TODO: Move card
    }

    fun onCardDeleteBtnClick(choreId: Int) {
        // TODO: Open confirmation dialog
    }
}
