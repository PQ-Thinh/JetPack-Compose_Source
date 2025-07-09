package com.example.ggsouresjetpack.JetpackDay

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import com.example.ggsouresjetpack.R
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GGSouresJetpackTheme {
                Scaffold(modifier = Modifier.padding(24.dp)) {
                    Column(modifier = Modifier.padding(15.dp)) {
//                        Greeting(
//                            name = "Android anh đến với em đêm nay ú ờ ơ,Thôi nào em ới ơi ợi vãi đạn thiệt chứ",
//                            //modifier = Modifier.padding(innerPadding)
//                        )
//                        HomScreen()
//                        Stringrs()
//                        Spacer(modifier = Modifier.height(50.dp))
//                        MultiplestypeText()
                        //    ImagesDay()
                        CalculatorGrid {  }
                    }

                    //HomScreen()
                }
            }
        }
    }
}

@Composable
fun HomScreen(){
    Column {
        Greeting(
            name = "Day one"
        )
    }
}

//val customh1: TextStyle
//    get()= TextStyle(
//        color = Color.LightGray
//    )
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "hello $name??",
        modifier = modifier,
        color= Color.Magenta,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        textAlign = TextAlign.Justify,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun Stringrs(){
    Text(
        text = stringResource(id = R.string.app_name),
        color = Color.Red,
        fontSize = 30.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )

}
@Composable
fun MultiplestypeText(){
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Cyan)){
            append("T")
        }
        append("hịnh")
        Spacer(modifier = Modifier.width(50.dp))
        withStyle(style = SpanStyle(color = Color.Magenta)){
            append("S")
        }
        append("a")

    })
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GGSouresJetpackTheme {
        HomScreen()
    }
}