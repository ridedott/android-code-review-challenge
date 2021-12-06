package com.ridedott.dottapp.repository

class TodoItem(val id: TodoItemId, val title: String, val description: String, val subdescription: String)

class TodoItemId(val value: String)