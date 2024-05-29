package com.ridedott.dottapp.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

object TodoRepository {

    suspend fun getTodoList(): Flow<List<TodoListItem>> = withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos")
            .build()

        flowOf(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.decodeFromString(
                client.newCall(request).execute().body!!.string()
            )
        )
    }
}

