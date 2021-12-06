package com.ridedott.dottapp.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.ridedott.dottapp.R
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoItemId
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class TodoDetailsFragment(val todoItem: TodoItem) : Fragment(R.layout.todo_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).text = todoItem.title
        view.findViewById<TextView>(R.id.description).text = todoItem.description
        view.findViewById<TextView>(R.id.subdescription).text = todoItem.subdescription

        lifecycleScope.launch(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/${todoItem.id.value}")
                .build()

            val result = client.newCall(request).execute().body?.string()

            launch(Dispatchers.Main) {
                view.findViewById<TextView>(R.id.dataFromBackend).text = result
            }
        }
    }
}