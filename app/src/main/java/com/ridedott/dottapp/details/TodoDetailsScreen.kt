package com.ridedott.dottapp.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoDetailsScreen(
    viewModel: TodoDetailsViewModel = viewModel(),
    onNavigation: (navigation: Navigation?) -> Unit,
) {

    val item = viewModel.item.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = item.value?.title ?: "no title")
    }
}
