package com.skrebniou.chorey.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.models.Chore
import data.repositories.ChoreRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ChoreRepository
) : ViewModel() {
    private val _pendingChores = MutableLiveData<List<Chore>>()
    val pendingChores: LiveData<List<Chore>> get() = _pendingChores

    private val _completedChores = MutableLiveData<List<Chore>>()
    val completedChores: LiveData<List<Chore>> get() = _completedChores

    init {
        viewModelScope.launch {
            repository.getPendingChores().collect {
                _pendingChores.value = it
            }
            repository.getCompletedChores().collect {
                _completedChores.value = it
            }
        }
    }

    fun onCreateChoreBtnClick() {
        viewModelScope.launch {
            repository.createChore()
        }
    }

    fun onCardTitleClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardDeadlineTimeClick(choreId: Int) {
        // TODO: Open time picker
    }

    fun onCardReminderClick(choreId: Int) {
        // TODO: Open duration picker
    }

    fun onCardDescriptionClick(choreId: Int) {
        // TODO: Open editing dialog
    }

    fun onCardCompletionSwitchClick(choreId: Int, isChoreCompleted: Boolean) {
        viewModelScope.launch {
            repository.setChoreCompletionStatus(choreId, isChoreCompleted)
        }
    }

    fun onCardDeleteBtnClick(choreId: Int) {
        // TODO: Open confirmation dialog
    }
}
