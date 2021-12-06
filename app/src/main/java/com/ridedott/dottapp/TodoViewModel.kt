package com.ridedott.dottapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ridedott.dottapp.repository.TodoItemId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor() : ViewModel() {

    val NAVIGATE_TO = MutableLiveData<TodoItemId?>()

    fun onClick(todoItemId: TodoItemId) {
        NAVIGATE_TO.value = todoItemId
    }
}