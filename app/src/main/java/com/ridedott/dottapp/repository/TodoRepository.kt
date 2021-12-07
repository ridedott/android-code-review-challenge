package com.ridedott.dottapp.repository

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

object TodoRepository {

    fun getTodoList(): List<TodoListItem> {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos")
            .build()

        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }.decodeFromString(
            client.newCall(request).execute().body!!.string()
        )
    }
}

