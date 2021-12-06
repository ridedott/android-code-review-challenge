package com.ridedott.dottapp.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.ridedott.dottapp.R
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoItemId
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class TodoDetailsFragment(val todoItem: TodoItem) : Fragment(R.layout.todo_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).text = todoItem.title
        view.findViewById<TextView>(R.id.description).text = todoItem.description
        view.findViewById<TextView>(R.id.subdescription).text = todoItem.subdescription
    }
}