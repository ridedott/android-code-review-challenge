package com.ridedott.dottapp.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoItemId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor() : ViewModel() {

    val NAVIGATE_TO = MutableLiveData<TodoItem>()

    fun onClick(todoItem: TodoItem) {
        NAVIGATE_TO.value = todoItem
    }
}