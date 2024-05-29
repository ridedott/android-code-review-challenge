package com.ridedott.dottapp.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridedott.dottapp.repository.TodoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

@HiltViewModel
class TodoDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val args = TodoDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val id = args.argTodoId

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/todos/${id}")
                    .build()

                val result: TodoItem =
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }.decodeFromString(client.newCall(request).execute().body!!.string())
                _item.value = result
            }
        }

    }

    private val _item = MutableStateFlow<TodoItem?>(null)
    val item = _item.asStateFlow()
}

sealed interface Navigation {
    data object Dismiss : Navigation
}
