package com.example.ggsouresjetpack.Side_Effects.ui.register


import android.graphics.Rect
import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ggsouresjetpack.Side_Effects.ui.component.BaseScreen

@Composable
fun RegisterRoute(
    viewModel: RegisterViewModel = hiltViewModel(),
    onNavigateProfile: (String) -> Unit,
) {

    Log.e("Frank", "RegisterRoute Recompose")

    val uiState = viewModel.uiState.collectAsState()

    when (uiState.value) {
        is RegisterUiState.RegisterSuccess -> {
            Log.e("Frank", "RegisterRoute Success")
            LaunchedEffect(Unit) {
                Log.e("Frank", "RegisterRoute Success ---> call to onNavigateProfile")
                viewModel.sendAction(RegisterAction.OnNavigated)
                onNavigateProfile((uiState.value as RegisterUiState.RegisterSuccess).userName)
            }
        }
        else -> {
            Log.e("Frank", "RegisterRoute ${uiState.value}")
        }
    }
    BaseScreen(titleScreen = "Register") {
        RegisterScreen(onRegisterSuccess = {
            viewModel.sendAction(RegisterAction.OnRegister(userName = it))
        })
    }
}

@Composable
fun RegisterScreen(
    onRegisterSuccess: (String) -> Unit,
) {
    Log.e("Frank", "RegisterRoute")
    var userName by remember {
        mutableStateOf("")
    }

    val keyboardStatus by keyboardAsState(initial = KeyboardStatus.Closed)

    // closed opened
    Log.e("Frank", "RegisterRoute keyboardStatus $keyboardStatus")

//    var x by remember(keyboardStatus) {
//        mutableStateOf(false)
//    }
//
//    x = if (keyboardStatus == KeyboardStatus.Closed) {
//        userName.length < 3
//    } else {
//        false
//    }
//
//    // keyboardState
//    // userName
//    // -> showWarning

    val isShowWarning by remember(keyboardStatus) {
        Log.e("Frank", "RegisterRoute isShowWarning 01")
        derivedStateOf {
            Log.e("Frank", "RegisterRoute isShowWarning 02")
            if (keyboardStatus == KeyboardStatus.Closed) {
                Log.e("Frank", "RegisterRoute isShowWarning 03")
                if (userName.length < 3) {
                    Log.e("Frank", "RegisterRoute isShowWarning 04")
                    return@derivedStateOf true
                }
            }
            false
        }
    }

    val focusRequester = remember {
        FocusRequester()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = userName, onValueChange = {
            userName = it
        },
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (isShowWarning) {
            WarningMessage()
        }
        Button(onClick = {
            onRegisterSuccess(userName)
        }) {
            Text("Save")
        }
    }

//    LaunchedEffect(Unit){
//        focusRequester.requestFocus()
//    }

}

@Composable
fun WarningMessage() {
    Log.e("Frank", "Warning Recomposition")
    Column() {
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Input invalid", color = MaterialTheme.colorScheme.error)
    }

}

enum class KeyboardStatus {
    Opened,
    Closed
}

@Composable
fun keyboardAsState(
    initial: KeyboardStatus = KeyboardStatus.Closed
): State<KeyboardStatus> {
    val keyboardState = remember { mutableStateOf(initial) }
    val view = LocalView.current
    DisposableEffect(true) {
        val onGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            Log.e("Frank", "keyboardAsState $keypadHeight")
            keyboardState.value = if (keypadHeight > screenHeight * 0.15) {
                KeyboardStatus.Opened
            } else {
                KeyboardStatus.Closed
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalListener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalListener)
        }
    }
    return keyboardState
}