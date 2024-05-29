package com.ridedott.dottapp.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridedott.dottapp.repository.TodoListItem
import com.ridedott.dottapp.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor() : ViewModel() {

    init {
        viewModelScope.launch {  TodoRepository.getTodoList().collect{
            _items.value = it
        } }
    }

    private val _items = MutableStateFlow<List<TodoListItem>>(emptyList())
    val items : Flow<List<TodoListItem>> = _items.asStateFlow()

    val NAVIGATE_TO = MutableLiveData<TodoListItem>()

    fun onClick(todoListItem: TodoListItem) {
        NAVIGATE_TO.value = todoListItem
    }
}

sealed interface Navigation {
    data class Detail(val id: String)
}
