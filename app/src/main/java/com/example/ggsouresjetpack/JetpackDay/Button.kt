package com.example.ggsouresjetpack.JetpackDay

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ggsouresjetpack.R
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun  ButtonDay(){
    GGSouresJetpackTheme {
        Scaffold {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(color = Color.White)) {
                SingleButton()
                Spacer(modifier = Modifier.height(20.dp))
                DisableSingleButton()
                Spacer(modifier = Modifier.height(20.dp))
                RoundedCornerButton()
                Spacer(modifier = Modifier.height(20.dp))
                BroderSimpleButton()
                Spacer(modifier = Modifier.height(20.dp))
                ElevationSimpleButton()
                Spacer(modifier = Modifier.height(20.dp))
//                OutlinedButton(onClick = { }){
//                    Text(text = "outLine Button")}
//                Spacer(modifier = Modifier.height(20.dp))
//                TextButton(onClick = {}) {
//                    Text(text = "Text Button")
//                }
//                Spacer(modifier = Modifier.height(20.dp))
//                IconButton(onClick = {}) {
//                    Icon(imageVector = Icons.Default.Info, contentDescription = "")
//                }
//                Spacer(modifier = Modifier.height(20.dp))
                DemoClickAble()
                Spacer(modifier = Modifier.height(20.dp))
                DemoDetectTapGestures()
            }
        }
   }
}
@Composable
fun SingleButton(){
    var count = remember {
        mutableStateOf(0)
    }
    Text(text = "số lần nhấn: ${count.value}")
    Column {
        Button(onClick = {
            count.value++;
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Blue
            ),
            shape = RectangleShape
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
            Text(
                text = "Add to cart"
            )

        }
    }

}
@Composable
fun DemoDetectTapGestures(){
    val textContent = remember {
        mutableStateOf("")
    }
    Column (){
        Text(text = textContent.value)
        Text(text= "something",
            modifier = Modifier.pointerInput(Unit){
                detectTapGestures(
                    onDoubleTap = {
                        textContent.value="double tap"
                    },
                    onPress = {
                        textContent.value="test"
                    }
                    , onLongPress = {
                        textContent.value="Long press"
                    }
                )
            })
    }

}
@Composable
fun DemoClickAble(){
    Column (modifier = Modifier.width(100.dp).clickable{}){
        Image(
            painter = painterResource(id = R.drawable.sunny3_background),
            contentDescription = ""
        )
        Text("product name")
        Text("200$")
    }

}
@Composable
fun RoundedCornerButton(){
    Button(onClick ={},
        shape = RoundedCornerShape(topStart = 12.dp, bottomEnd = 12.dp)
    ) {
        Text("nút bo góc")
    }
}
@Composable
fun BroderSimpleButton(){
    Button(onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
        ), shape = RoundedCornerShape(25.dp)) {
        Text(
            text = "Checkout", color = Color.
            Magenta
        )

    }
}
@Composable
fun ElevationSimpleButton(){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 25.dp,
            disabledElevation = 0.dp
        )
        ) {
        Text("Text", color = Color.Black)
    }
}
@Composable
fun DisableSingleButton(){
    Button(onClick = {},

        colors = ButtonDefaults.buttonColors(
           disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        enabled = false) {
        Text("Disable Button")
    }
}