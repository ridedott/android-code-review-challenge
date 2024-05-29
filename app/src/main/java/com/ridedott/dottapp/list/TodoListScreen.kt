package com.ridedott.dottapp.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoListScreen(
    viewModel: TodoListViewModel = viewModel(),
    onNavigation: (navigation: Navigation) -> Unit,
) {

    val items = viewModel.items.collectAsState(initial = emptyList())

    Column(modifier = Modifier.background(Color.White)) {
        items.value.forEach { todoItem ->
            Row(modifier = Modifier.padding(vertical = 16.dp).background(Color.Red)) {
                Text(text = todoItem.title)
            }
        }
    }

}
