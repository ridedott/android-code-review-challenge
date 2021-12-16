package com.ridedott.dottapp.repository

import kotlinx.serialization.Serializable

@Serializable
class TodoItem(val id: String, val title: String, val completed: Boolean) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TodoItem

        if (id != other.id) return false
        if (title != other.title) return false
        if (completed != other.completed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + completed.hashCode()
        return result
    }
}
