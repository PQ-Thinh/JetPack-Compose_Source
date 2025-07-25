package com.example.ggsouresjetpack.Side_Effects.ui.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainRoute(
    onNavigateToHome: () -> Unit,
    onNavigateDetail: () -> Unit,
    onNavigateList: () -> Unit
) {
    Log.e("Frank", "MainRoute Recomposition")

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = Color.Red)

    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    val show = {
        coroutineScope.launch {
            modalBottomSheetState.show()
        }
    }

    val hide = {
        coroutineScope.launch {
            modalBottomSheetState.hide()
        }
    }
    var sheetContentType by remember {
        mutableStateOf(SheetContentType.UNKNOWN)
    }
    MainScreen(
        modalBottomSheetState = modalBottomSheetState,
        sheetContentType = sheetContentType,
        showBottom = { type ->
            sheetContentType = type
            show()
        },
        close = {
            sheetContentType = SheetContentType.UNKNOWN
            hide()
        },
        onNavigateToHome = onNavigateToHome,
        onNavigateDetail = onNavigateDetail,
        onNavigateList = onNavigateList
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modalBottomSheetState: SheetState, // Thay ModalBottomSheetState bằng SheetState
    sheetContentType: SheetContentType,
    showBottom: (SheetContentType) -> Unit,
    close: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateDetail: () -> Unit,
    onNavigateList: () -> Unit
) {
    Log.e("Frank", "MainScreen Recomposition ${sheetContentType.name}")

    // Thay ModalBottomSheetLayout bằng ModalBottomSheet
    if (sheetContentType != SheetContentType.UNKNOWN) {
        ModalBottomSheet(
            sheetState = modalBottomSheetState,
            onDismissRequest = { close() }
        ) {
            when (sheetContentType) {
                SheetContentType.ONE -> SheetContentScreen(context = "ONE") { close() }
                SheetContentType.SECOND -> SheetContentScreen(context = "TWO") { close() }
                else -> Spacer(modifier = Modifier.height(1.dp))
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(onClick = { showBottom(SheetContentType.ONE) }) {
            Text("Show one")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { showBottom(SheetContentType.SECOND) }) {
            Text("Show two")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateToHome) {
            Text("Go home")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateDetail) {
            Text("Go Detail")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateList) {
            Text("Go to list user")
        }
    }
}

enum class SheetContentType {
    ONE,
    SECOND,
    UNKNOWN
}

@Composable
fun SheetContentScreen(
    context: String,
    close: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text(context, fontSize = 28.sp, color = Color.White)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = close) {
            Text("Close", color = Color.White)
        }
    }
}