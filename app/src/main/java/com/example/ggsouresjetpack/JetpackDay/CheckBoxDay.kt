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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun CheckBoxDay(){
    GGSouresJetpackTheme {
        Scaffold {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.White)) {
              //  SimpleCheckbox()
                TitleCheckbox(title = "eat")
            }
        }
    }
}
@Composable
fun SimpleCheckbox(){
    Checkbox(checked = true, onCheckedChange = {

    }, colors = CheckboxDefaults.colors(
        checkedColor = Color.Red,
        uncheckedColor = Color.Green
    ))
    Checkbox(checked = false, onCheckedChange = {

    }, colors = CheckboxDefaults.colors(
        checkedColor = Color.Red,
        uncheckedColor = Color.Green
    ))
}
@Composable
fun TitleCheckbox(title: String){
    var isCheckBox by remember {
        mutableStateOf(false)
    }
    return Row (modifier = Modifier.selectable(
        selected = isCheckBox,
        onClick = {
            isCheckBox=!isCheckBox
        }
    )){
        Checkbox(checked = isCheckBox, onCheckedChange = null, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green
        ))
        Text(text = title, modifier = Modifier.padding(start = 12.dp))
        val icon = if(isCheckBox) Icons.Default.Add else Icons.Default.Check
        Icon(icon,contentDescription = null)
        Text(if(isCheckBox) title else "don't eat")
    }
}