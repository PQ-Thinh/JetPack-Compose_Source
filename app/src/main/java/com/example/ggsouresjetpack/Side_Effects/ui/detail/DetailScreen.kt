package com.example.ggsouresjetpack.Side_Effects.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    onNavigateHome: () -> Unit
) {

    val uiState = viewModel.uiState.collectAsState()


    DetailScreen(uiState = uiState.value, onNavigateHome = onNavigateHome) {
        Log.e("Frank","DetailScreen ---> call fetchData")
        viewModel.handleAction(DetailUiAction.FetchData(System.currentTimeMillis()))
    }
}

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onNavigateHome: () -> Unit,
    fetchData: () -> Unit
) {
    Log.e("Frank","DetailScreen uiState ${uiState.javaClass.name}")
    when(uiState){
        is DetailUiState.Default -> {
            fetchData()
        }
        is DetailUiState.Loading -> {
            BaseDetailScreen {
                Text("Loading")
            }
        }
        is DetailUiState.Success -> {
            BaseDetailScreen {
                Button(onClick = onNavigateHome) {
                    Text(text = "Go home")
                }
            }
        }
        is DetailUiState.Error -> {
            BaseDetailScreen {
                Text(text = "Error ")
            }
        }
    }
}


@Composable
fun BaseDetailScreen(content: @Composable () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text("Detail")
        Spacer(modifier = Modifier.height(24.dp))
        content()
    }
}