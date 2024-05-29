package com.ridedott.dottapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner))

            setContent {
                TodoListScreen(
                    onNavigation = ::onNavigationChange,
                )
            }
        }
    }

    private fun onNavigationChange(navigation: Navigation?) {
        when (navigation) {
            is Navigation.Detail ->
                findNavController().navigate(TodoListFragmentDirections.toDetails(navigation.id))
            null -> Unit
        }
    }
}
