package com.ridedott.dottapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ridedott.dottapp.R
import com.ridedott.dottapp.details.TodoDetailsFragment
import com.ridedott.dottapp.repository.TodoListItem
import com.ridedott.dottapp.repository.TodoRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoListFragment : Fragment(R.layout.todo_fragment) {

    private val viewModel by viewModels<TodoListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.NAVIGATE_TO.observeForever {
          parentFragmentManager.beginTransaction().replace(android.R.id.content, TodoDetailsFragment(it!!))
              .addToBackStack(it.toString())
              .commit()
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val items = TodoRepository.getTodoList()

            launch(Dispatchers.Main) {
                items.forEach { createItem(it) }
            }
        }
    }

    private fun createItem(todoListItem: TodoListItem) {
        val item = LayoutInflater.from(context!!).inflate(R.layout.todo_item, view as ViewGroup, false)
        item.findViewById<TextView>(R.id.itemId).text = todoListItem.id
        item.setOnClickListener { viewModel.onClick(todoListItem) }

        (view as ViewGroup).addView(item)
    }
}