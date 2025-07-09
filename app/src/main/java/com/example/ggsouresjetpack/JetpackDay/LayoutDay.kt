package com.example.ggsouresjetpack.JetpackDay

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun LayOutDay(){
    GGSouresJetpackTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            DemoColum()
        }
    }
}
@Composable
fun HomeScreenLayOut(){

}
@Composable
fun DemoColum(){
    Box() {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.size(300.dp,400.dp)
                    .background(color = Color.Black)
                    .verticalScroll(rememberScrollState())
            ){
BoxItem(color = Color.Red)
BoxItem(color = Color.Blue)
BoxItem(color = Color.White)
BoxItem(color = Color.Yellow)
BoxItem(color = Color.Magenta)
BoxItem(color = Color.Gray)
BoxItem(color = Color.Green)
            }
    }
}
@Composable
fun DemoRow(){
    Box(){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.weight(2f))
            Icon(Icons.Default.Send,contentDescription = "Send", modifier = Modifier.weight(1f))
        }
    }

}
@Composable
fun DemoBox(){
    Box (){
        BoxItem(color = Color.Red, size = 150.dp, modifier = Modifier.align(Alignment.TopStart))
        BoxItem(color = Color.Blue, size = 200.dp, modifier = Modifier.align(Alignment.TopEnd))
        BoxItem(color = Color.Yellow, size = 200.dp, modifier = Modifier.align(Alignment.BottomEnd))
        BoxItem(color = Color.Green, size = 50.dp, modifier = Modifier.align(Alignment.BottomStart))
    }
}
@Composable
fun BoxItem(modifier: Modifier= Modifier, color: Color, size:Dp= 100.dp){
    Box(modifier = modifier
        .size(size)
        .background(color)){

    }
}