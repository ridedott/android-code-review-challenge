package com.ridedott.dottapp.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ridedott.dottapp.R
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class TodoDetailsFragment(private val todoListItem: TodoListItem) :
    Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/${todoListItem.id}")
                .build()

            val result: TodoItem =
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }.decodeFromString(client.newCall(request).execute().body!!.string())

//            launch(Dispatchers.Main) {
//                view.findViewById<TextView>(R.id.title).text = result.title
//                view.findViewById<TextView>(R.id.isCompleted).text = result.completed.toString()
//            }
        }
    }
}
