import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <T> LifecycleAwareFlowCollectEffect(
    flow: Flow<T>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    block: suspend (t: T) -> Unit,
) {
    LaunchedEffect(flow) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, minActiveState).collect { block(it) }
    }
}
