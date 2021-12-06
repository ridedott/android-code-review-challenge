package com.ridedott.dottapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment(R.layout.todo_fragment) {

    private val viewModel by viewModels<TodoViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.NAVIGATE_TO.observeForever {
            Toast.makeText(activity!!.applicationContext, it!!.value , Toast.LENGTH_LONG).show()
        }

        val items = TodoRepository.getTodoList()

        items.forEach { createItem(it) }
    }

    private fun createItem(todoItem: TodoItem) {
        val item = LayoutInflater.from(context!!).inflate(R.layout.todo_item, view as ViewGroup, false)
        item.findViewById<TextView>(R.id.title).text = todoItem.title
        item.findViewById<TextView>(R.id.description).text = todoItem.description
        item.findViewById<TextView>(R.id.subdescription).text = todoItem.subdescription
        item.setOnClickListener { viewModel.onClick(todoItem.id) }

        (view as ViewGroup).addView(item)
    }
}