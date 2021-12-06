package com.ridedott.dottapp.repository

object TodoRepository {

    fun getTodoList(): List<TodoItem> {
        return mutableListOf<TodoItem>().apply {
            add(TodoItem(TodoItemId("1"),"First todo item",  "And its description", "subdescription"))
            add(TodoItem(TodoItemId("2"),"Second todo item",  "And its description", "subdescription"))
            add(TodoItem(TodoItemId("3"),"Third todo item",  "And its description", "subdescription"))
            add(TodoItem(TodoItemId("4"),"Forth todo item",  "And its description", "subdescription"))
        }
    }
}

