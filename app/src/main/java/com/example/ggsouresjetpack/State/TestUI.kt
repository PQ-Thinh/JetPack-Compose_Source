package com.example.ggsouresjetpack.State

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.ggsouresjetpack.State.ui.theme.GGSouresJetpackTheme
import com.example.ggsouresjetpack.ui.theme.Mojito


@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen(){
    val loginViewModel: LoginViewModel = LoginViewModel()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Log.e("frank","Login Screen start")
        WellCom()

//        Email(loginViewModel.email.value) {
//            loginViewModel.updateEmail(it)
//        }

//        Password(password) {
//            password = it
//        }
        Button(onClick = {}) {
            Text("Login")
        }
        Log.e("frank","Login Screen end")
    }
}
class LoginViewModel: ViewModel(){

    var screenState = mutableStateOf(LoginScreenState.Loading())

}
sealed class LoginScreenState{
    class Loading(): LoginScreenState()
    class Success(): LoginScreenState()
    class Fall(): LoginScreenState()
}
@Composable
fun Email(email: String, onEmailChange:(String)-> Unit){
    Log.e("frank","Email start")
    OutlinedTextField(value = email, onValueChange = onEmailChange)

}
@Composable
fun Password(password: String, onPassWordChange:(String)-> Unit){
    Log.e("frank","Password Start")
    OutlinedTextField(value = password, onValueChange = onPassWordChange )
}
@Composable
fun WellCom(){
    Log.e("frank","wellcome start")
    Text(text = "Login to your Account")
    Log.e("frank","wellcome Screen start")
}
//class LoginViewModel(): ViewModel(){
//    var _email =mutableStateOf("")
//    val email: State<String>
//        get() = _email
//    var password = mutableStateOf("")
//
//    fun updateEmail(newEmail: String){
//        _email.value =newEmail
//    }
//}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview(){
    GGSouresJetpackTheme {
        LoginScreen()
    }
}

//@Composable
//fun MiniCalculator() {
//    var a by remember { mutableStateOf("") }
//    var b by remember { mutableStateOf("") }
//    var result by remember { mutableStateOf("") }
//    var operation by remember { mutableStateOf("+") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Máy Tính Mini", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = a,
//            onValueChange = { a = it },
//            label = { Text("Số A") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        OutlinedTextField(
//            value = b,
//            onValueChange = { b = it },
//            label = { Text("Số B") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Row {
//            IconButton(onClick = { operation = "+" }) {
//                Text("+")
//            }
//            IconButton(onClick = { operation = "-" }) {
//                Text("-")
//            }
//            IconButton(onClick = {
//                val numA = a.toIntOrNull() ?: 0
//                val numB = b.toIntOrNull() ?: 0
//                result = when (operation) {
//                    "+" -> "${numA + numB}"
//                    "-" -> "${numA - numB}"
//                    else -> "?"
//                }
//            }) {
//                Text("=")
//            }
//            IconButton(onClick = {
//                a = ""
//                b = ""
//                result = ""
//                operation = "+"
//            }) {
//                Text("C") // Clear
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text("Kết quả: $result", fontSize = 18.sp)
//    }
//}
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun ScreenSum(){
//    GGSouresJetpackTheme {
//        MiniCalculator()
//    }
//}