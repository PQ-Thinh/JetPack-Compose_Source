package com.example.ggsouresjetpack.JetpackDay

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@Composable
fun Main(){
    GGSouresJetpackTheme {
        CalculatorGrid {  }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    )

    LazyVerticalGrid(
        columns =  GridCells.Fixed(4), // 4 cột
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(buttons.size) { index ->
            val label = buttons[index]
            Button(
                onClick = { onButtonClick(label) },
                modifier = Modifier
                    .padding(8.dp)
                    .aspectRatio(1f) // vuông đều
            ) {
                Text(text = label)
            }
        }
    }
}