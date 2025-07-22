package com.example.ggsouresjetpack.Side_Effects.ui.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.example.ggsouresjetpack.Side_Effects.ui.register.RegisterUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun rememberFunAnalytics(uiState: RegisterUiState): FunAnalytics {
    val analytics = remember {
        FunAnalytics()
    }

    when (uiState) {

        is RegisterUiState.Default -> {
            //   SideEffect {
            analytics.setUserProperty("Register", "default")
            //  }
        }
        is RegisterUiState.RegisterSuccess -> {
            // SideEffect {
            analytics.setUserProperty("Register", "success")
            //}
        }

        RegisterUiState.Loading -> TODO()
        is RegisterUiState.RegisterError -> TODO()
    }

    return analytics
}

class FunAnalytics{

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val userProperties = hashMapOf<String,String>()

    fun setUserProperty(key: String,value: String){
        userProperties[key] = value
    }

    private fun getUserProperties() = userProperties.map { "${it.key}:${it.value}" }.joinToString(separator = ",")

    fun logEvent(key: String, value: String) {
        logEventToCloud(key, "{user:{${getUserProperties()}},event: $value}")
    }

    private fun logEventToCloud(key: String, value: String) {
        coroutineScope.launch {
            delay(100L)
            Log.e("Frank", "FunAnalytics logEvent($key,$value) Success <<<<<<<<<<<<<<<<<")
        }
    }


}