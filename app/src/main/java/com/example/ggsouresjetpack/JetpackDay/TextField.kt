package com.example.ggsouresjetpack.JetpackDay

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun TextFieldDay(){
    GGSouresJetpackTheme {
        Scaffold {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.White)) {
                SimpleTextField()
                Spacer(modifier = Modifier.height(15.dp))
                DemoOutLineTextField()
                Spacer(modifier = Modifier.height(15.dp))
                PasswordOutline()
            }
        }
    }
}

@Composable
fun SimpleTextField(){
    var Readtext by remember {
        mutableStateOf("")
    }
    var keyboardController= LocalSoftwareKeyboardController.current
    TextField(value = Readtext, onValueChange={ newValue->
        Readtext = newValue
    }, textStyle = TextStyle(
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold),
        label = {Text(text = "Name")},
        placeholder = {Text(text = "Enter your Name")},
        leadingIcon = { Icon(Icons.Default.Person,contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = {
                Readtext = ""
            }) {
                Icon(Icons.Default.Clear,contentDescription = null)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Red,
            unfocusedTextColor = Color.Red,
            cursorColor = Color.Green,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedTrailingIconColor = Color.Magenta,

        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Characters
        ),
        keyboardActions = KeyboardActions (
            onDone = {
                keyboardController?.show()
            }
        )
    )
}
@Composable
fun DemoOutLineTextField(){
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = email, onValueChange = {
        newValue-> email = newValue
    },
        placeholder = {Text("Enter Your Email")},
        label = {Text("Email")},
        leadingIcon = {Icon(Icons.Default.Email,contentDescription = null)}
    )
}
@Composable
fun PasswordOutline(){
    var password by  remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(value = password, onValueChange = {
        newValue-> password = newValue
    },
        placeholder = {Text("Enter Your Password ")},
        label = {Text("PassWord")},
        leadingIcon = {Icon(Icons.Default.Lock,contentDescription = null)},
        trailingIcon = {IconButton(onClick =
            {
                showPassword = !showPassword
            }) {
            Icon(if(showPassword) Icons.Filled.Face else Icons.Default.Info,contentDescription = null)
        }},
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        )
}