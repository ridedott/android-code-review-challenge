package com.ridedott.dottapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ridedott.dottapp.R
import com.ridedott.dottapp.details.TodoDetailsFragment
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment(R.layout.todo_fragment) {

    private val viewModel by viewModels<TodoViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.NAVIGATE_TO.observeForever {
          parentFragmentManager.beginTransaction().replace(android.R.id.content, TodoDetailsFragment(it!!))
              .addToBackStack(it.toString())
              .commit()
        }

        val items = TodoRepository.getTodoList()

        items.forEach { createItem(it) }
    }

    private fun createItem(todoItem: TodoItem) {
        val item = LayoutInflater.from(context!!).inflate(R.layout.todo_item, view as ViewGroup, false)
        item.findViewById<TextView>(R.id.itemId).text = todoItem.id.value
        item.setOnClickListener { viewModel.onClick(todoItem) }

        (view as ViewGroup).addView(item)
    }
}