package com.ridedott.dottapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ridedott.dottapp.R
import com.ridedott.dottapp.details.TodoDetailsFragment
import com.ridedott.dottapp.repository.TodoListItem
import com.ridedott.dottapp.repository.TodoRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TodoListFragment : Fragment(R.layout.todo_fragment) {

    private val viewModel by viewModels<TodoListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.NAVIGATE_TO.observeForever {
            parentFragmentManager.beginTransaction()
                .replace(android.R.id.content, TodoDetailsFragment(it!!))
                .addToBackStack(it.toString())
                .commit()
        }

        val button = view.findViewById<FloatingActionButton>(R.id.refresh)
        button.setOnClickListener {
            lifecycleScope.launch { loadItems() }
        }
        button.performClick()
    }

    private suspend fun loadItems() {
        val list = view!!.findViewById<LinearLayout>(R.id.list)
        list.removeAllViews()
        val items = withContext(Dispatchers.IO) { TodoRepository.getTodoList() }
        items.forEach { todoItem ->
            val itemView =
                LayoutInflater.from(context!!).inflate(R.layout.todo_item, view as ViewGroup, false)
            itemView.findViewById<TextView>(R.id.itemId).text = todoItem.id
            itemView.setOnClickListener { viewModel.onClick(todoItem) }
            list.addView(itemView)
        }
    }
}
