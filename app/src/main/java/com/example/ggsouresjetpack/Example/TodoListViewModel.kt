package com.example.ggsouresjetpack.Example

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TodoListViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks
    private var taskId = 0

    fun addTask(title: String) {
        _tasks.value = _tasks.value + Task(id = taskId++, title = title, isChecked = false)
    }

    fun toggleTaskChecked(id: Int) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == id) task.copy(isChecked = !task.isChecked) else task
        }
    }
    fun removeTask(id: Int) {
        _tasks.value = _tasks.value.filter { it.id != id }
    }
}
data class Task(val id: Int, val title: String, val isChecked: Boolean)