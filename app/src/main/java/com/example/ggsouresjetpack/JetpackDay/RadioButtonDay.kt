package com.example.ggsouresjetpack.JetpackDay

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun RadioButtonDay(){
    GGSouresJetpackTheme {
        Scaffold {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.White)) {
                TitleRadioButton(title = "Click me")
                Spacer(modifier = Modifier.height(14.dp))
                DemoCustomRadioButton(title = "Male")
            }
        }
    }
}
@Composable
fun TitleRadioButton(title: String){
    var isSelected by remember {
        mutableStateOf(true)
    }
    Row (modifier = Modifier.selectable(
          selected = isSelected,
        onClick = {isSelected = !isSelected},
        role = Role.RadioButton
        )){
        RadioButton(selected = isSelected, onClick =null, colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            unselectedColor = Color.Yellow,
            disabledSelectedColor = Color.Black,
            disabledUnselectedColor = Color.Black))
        Text(text = title, modifier = Modifier.padding(start = 12.dp))
    }
}
@Composable
fun DemoCustomRadioButton( title: String){
    var isSelected by remember {
        mutableStateOf(true)
    }
    CustomRadioButton2(title = "Male",isSelected=isSelected) {
        isSelected =!isSelected
    }
}
@Composable
fun CustomRadioButton2(title: String,isSelected: Boolean,onClick:()-> Unit){
    Row (modifier = Modifier.selectable(
        selected = isSelected,
        onClick = onClick,
        role = Role.RadioButton
    )){
        val  iconRadio = if(isSelected) Icons.Default.ArrowDropDown else Icons.Default.Check
        Icon(iconRadio,contentDescription = null)
        Text(if (isSelected) title else "Female",modifier = Modifier.padding(start = 12.dp))
    }
}