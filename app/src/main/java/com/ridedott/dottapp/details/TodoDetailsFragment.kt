package com.ridedott.dottapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ridedott.dottapp.R
import com.ridedott.dottapp.list.TodoListScreen
import com.ridedott.dottapp.repository.TodoItem
import com.ridedott.dottapp.repository.TodoListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class TodoDetailsFragment :
    Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner))

            setContent {
                TodoDetailsScreen(
                    onNavigation = ::onNavigationChange,
                )
            }
        }
    }

    private fun onNavigationChange(navigation: Navigation?) {
        when (navigation) {
            Navigation.Dismiss -> findNavController().popBackStack()
            null -> Unit
        }
    }
}
