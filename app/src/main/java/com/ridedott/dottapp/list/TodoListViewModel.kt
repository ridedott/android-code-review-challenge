package com.ridedott.dottapp.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ridedott.dottapp.repository.TodoListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor() : ViewModel() {

    val NAVIGATE_TO = MutableLiveData<TodoListItem>()

    fun onClick(todoListItem: TodoListItem) {
        NAVIGATE_TO.value = todoListItem
    }
}
