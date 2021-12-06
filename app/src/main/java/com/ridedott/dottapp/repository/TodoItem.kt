package com.ridedott.dottapp.repository

class TodoItem(val id: TodoItemId, val title: String, val description: String, val subdescription: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TodoItem

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (subdescription != other.subdescription) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + subdescription.hashCode()
        return result
    }
}

class TodoItemId(val value: String)