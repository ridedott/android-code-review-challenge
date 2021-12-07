package com.ridedott.dottapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ridedott.dottapp.list.TodoListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, TodoListFragment()).commit()
    }
}
