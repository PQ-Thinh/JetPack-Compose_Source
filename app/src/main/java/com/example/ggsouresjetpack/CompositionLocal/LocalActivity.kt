package com.example.ggsouresjetpack.CompositionLocal

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ggsouresjetpack.CompositionLocal.ui.theme.GGSouresJetpackTheme
import kotlin.random.Random

// Step 1: define CompositionLocal
// Step 2: bind composable
// Step 3: using
class LocalActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(LocalAppColor provides AppColor(bodyTextColor = Color.Black)) {
            }
            GGSouresJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    Log.e("Frank","MainScreen")
    var bodyTextColor by remember {
        mutableStateOf(Color.Black)
    }
    Column {
        Header(title = "jetpack Compose")
        Spacer(modifier = Modifier.height(12.dp))
        Text("compositionLocal", style = TextStyle(color = LocalAppColor.current.bodyTextColor, fontSize = 18.sp))
        Spacer(modifier = Modifier.height(12.dp))
        Body(content = "Change text Color", bodyTextColor = bodyTextColor)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            bodyTextColor = getColor()
        }) {
            Text("Change text Color")
        }
    }
}
@Composable
fun Header(title: String){
    Log.e("Frank","Header")
    Text(title, style = TextStyle(color = Color.Black, fontSize = 24.sp))
}
@Composable
fun Body(content: String, bodyTextColor:Color){
    Log.e("Frank","Body")
    CompositionLocalProvider(LocalAppColor provides LocalAppColor.current.copy(bodyTextColor = bodyTextColor)) {
        Column {
            Text(content, style = TextStyle(
                color = LocalAppColor.current.bodyTextColor
            ))
            Spacer(modifier = Modifier.height(12.dp))
            ImagesFeature()
        }
    }
}

@Composable
fun ImagesFeature(){
    Log.e("Frank","ImagesFeature")
    Row {
        Icon(imageVector = Icons.Default.Person, contentDescription = null)
        Spacer(modifier = Modifier.height(12.dp))
        Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Surface(modifier = Modifier.background(color = Color.White).fillMaxSize().padding(12.dp)) {
        MainScreen()
    }
}

data class AppColor(val bodyTextColor:Color = Color.Black )
// khoi tao
val LocalAppColor = staticCompositionLocalOf { AppColor(bodyTextColor = Color.Black) }
//staticCompositionLocalOf sẽ recompose toàn bộ phần bên dưới nó
fun getColor():Color{
    val listColors = listOf(Color.Blue, Color.Red, Color.Yellow, Color.Magenta, Color.Green)
    val index = Random.nextInt(0,4)
    return listColors[index]

}