package com.example.ggsouresjetpack.GridAndList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ggsouresjetpack.GridAndList.ui.theme.GGSouresJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GGSouresJetpackTheme {
                    MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var currentScreen by remember {
        mutableStateOf(Screen.VideoDetailScreen)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        if (currentScreen == Screen.VideoDetailScreen) {
            VideoDetailScreen() {
                currentScreen = Screen.CategoryScreen
            }
        } else {
            CategoryScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GGSouresJetpackTheme {
        MainApp()
    }
}

enum class Screen {
    VideoDetailScreen,
    CategoryScreen
}