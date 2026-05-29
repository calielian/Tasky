package com.calielian.tasky.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calielian.tasky.database.TaskDao
import com.calielian.tasky.database.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class TaskViewModel(private val dao: TaskDao) : ViewModel() {

	val allTasks: StateFlow<List<TaskEntity>> = dao.getAllTasks()
		.stateIn(
			scope = viewModelScope,
			started = SharingStarted.WhileSubscribed(5000),
			initialValue = emptyList()
		)

	fun insertTask(task: TaskEntity) {
		viewModelScope.launch {
			dao.insert(task)
		}
	}

	fun deleteTask(task: TaskEntity) {
		viewModelScope.launch {
			dao.delete(task)
		}
	}

	fun deleteAllTasks() {
		viewModelScope.launch {
			dao.deleteAllTasks()
			dao.resetId()
		}
	}

	fun deleteTaskById(id: Int) {
		viewModelScope.launch {
			dao.deleteTask(id)
		}
	}

	fun updateTitle(id: Int, title: String) {
		viewModelScope.launch {
			dao.updateTaskTitle(id, title)
		}
	}

	fun updateDescription(id: Int, description: String) {
		viewModelScope.launch {
			dao.updateTaskDescription(id, description)
		}
	}

	fun updateDateTime(id: Int, datetime: LocalDateTime) {
		viewModelScope.launch {
			dao.updateTaskDate(id, datetime)
		}
	}

	fun resetTableIds() {
		viewModelScope.launch {
			dao.resetId()
		}
	}
}